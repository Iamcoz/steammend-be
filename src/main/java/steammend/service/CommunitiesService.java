package steammend.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import steammend.exception.MessageException;
import steammend.model.CommunitiesDAO;
import steammend.model.dto.CommunitiesDTO;
import steammend.model.entity.Communities;

@Service
public class CommunitiesService {

	@Autowired
	private CommunitiesDAO commuDAO;

//	@Autowired
//	private AttachmentsDAO atchDAO;

	private ModelMapper mapper = new ModelMapper();

	
	/**
	 * 하나의 게시글 작성
	 * 
	 * @param commuDTO
	 * @return
	 * @throws Exception
	 */
	public boolean addCommunity(CommunitiesDTO commuDTO) throws Exception {
		Communities commuEntity = mapper.map(commuDTO, Communities.class);

		try {
			commuEntity = commuDAO.save(commuEntity);

			if (commuEntity != null) {
				return true;
			}
		} catch (Exception e) {
			throw new MessageException("게시글 작성 실패");
		}

		return false;
	}
	
	
	/** 전체 게시글을 10개씩 페이징 하여 조회
	 * 
	 * @param pageable
	 * @return
	 * @throws Exception
	 */
	public List<CommunitiesDTO> getAllCommunity(Pageable pageable) throws Exception{
		Page<Communities> commuAllPageEntity = commuDAO.findAll(pageable);
		List<Communities> commuAllEntity = commuAllPageEntity.getContent();
		
		if(commuAllEntity == null) {
			throw new MessageException("존재하는 게시글이 없습니다.");
		}
		
		List<CommunitiesDTO> commuAllDTO = Arrays.asList(mapper.map(commuAllEntity, CommunitiesDTO[].class));
		
		return commuAllDTO;
	}
	/* 전체 게시글 조회 */
//	public List<CommunitiesDTO> getAllCommunity() throws Exception{
//		List<Communities> commuAllEntity = commuDAO.findAll();
//		
//		if(commuAllEntity == null) {
//			throw new MessageException("존재하는 게시글이 없습니다.");
//		}
//		
//		List<CommunitiesDTO> commuAllDTO = Arrays.asList(mapper.map(commuAllEntity, CommunitiesDTO[].class));
//		
//		return commuAllDTO;
//	}

	
	/** 하나의 게시글 조회
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public CommunitiesDTO getCommunity(Long id) throws Exception {
		
		Optional<Communities> commuEntity = commuDAO.findById(id);
		
		if(commuEntity.get() == null) {
			throw new MessageException("존재하지 않는 게시글입니다.");
		}
		
		CommunitiesDTO commuDTO = mapper.map(commuEntity.get(), CommunitiesDTO.class);
	
		
		return commuDTO;
	}
	
	
	/** 게시글 조회 시 조회수 1씩 증가
	 * 
	 * @param communityId
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public int modifyHit(Long id) throws Exception {
		return commuDAO.updateHitByCommunityId(id);
	}
	
	
	/** 하나의 게시글 수정
	 * 
	 * @param id
	 * @param header
	 * @param title
	 * @param content
	 * @param memberId
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public boolean modifyCommunity(Long id, String header, String title, String content, LocalDateTime updatedAt, String memberId/*session*/) throws Exception {
		CommunitiesDTO commuDTO = getCommunity(id);
		
		int result = 0;
		
		if(id != 0 && commuDTO.getMemberId() != null) { // 임시코드
//		if(communityId != 0 && commuDTO.getMemberId() == 세션id값) { // 이 방식으로 수정
			result = commuDAO.updateCommunityByCommunityId(id, header, title, content, updatedAt, memberId);
		} else if (result == 0) {
			throw new MessageException("게시글 수정 실패");
		}
		return true;
	}
	
	
	/** 하나의 게시글 삭제(수정)
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public boolean deleteCommunity(Long id) throws Exception {
		CommunitiesDTO commuDTO = getCommunity(id);
		
		int result = 0;
		
		if(id != 0 && commuDTO.isDeleted() == false && commuDTO.getMemberId() != null) { // 임시코드
//		if(communityId != 0 && commuDTO.isState() == true && commuDTO.getMemberId() == 세션id값) { // 이 방식으로 수정
			result = commuDAO.deleteCommunityByCommunityId(id, LocalDateTime.now());
		} else if(result == 0) {
			throw new MessageException("게시글 삭제 실패");
		}
		return true;
	}
//
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
////	/** 하나의 첨부파일 등록
////	 * 
////	 * @param atchDTO
////	 * @return
////	 * @throws Exception
////	 */
////	@Transactional
////	public Long addCommunity(CommunitiesDTO commuDTO, AttachmentsDTO atchDTO) throws Exception {
////		Communities commuEntity = mapper.map(commuDTO, Communities.class);
////		Attachments atchEntity = mapper.map(atchDTO, Attachments.class);
////		
////		return atchDAO.save(atchEntity).getAttachmentId();
////	}
//	
////	public boolean addCommu(CommunitiesDTO commuDTO) throws Exception {
////		Communities commuEntity = mapper.map(commuDTO, Communities.class);
//////		Communities commuEntity = commuDTO.toEntity(); //mapper.map(commuDTO, Communities.class);
////		
////		boolean result = false;
////		
////		try {
////			commuEntity = commuDAO.save(commuEntity);
////			
////			if (commuEntity != null) {
////				result = true;
////			}
////		} catch (Exception e) {
////			throw new MessageException("게시글 작성 실패");
////		}
////		
////		return result;
////	}



}
