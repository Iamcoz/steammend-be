package steammend.service;

<<<<<<< HEAD
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

=======
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import steammend.exception.MessageException;
import steammend.model.RepliesDAO;
import steammend.model.dto.RepliesDTO;
import steammend.model.entity.Replies;

@Service
public class RepliesService {
<<<<<<< HEAD

	@Autowired
	private RepliesDAO replyDAO;

	private ModelMapper mapper = new ModelMapper();

	/**
	 * 하나의 댓글 작성
=======
	
	@Autowired
	private RepliesDAO replyDAO;
	
	private ModelMapper mapper = new ModelMapper();
	
	
	/** 하나의 댓글 작성
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
	 * 
	 * @param replyDTO
	 * @return
	 * @throws Exception
	 */
	public boolean addReply(RepliesDTO replyDTO) throws Exception {
<<<<<<< HEAD
		replyDTO.setDeleted(false);
		Replies replyEntity = mapper.map(replyDTO, Replies.class);

		try {
			replyEntity = replyDAO.save(replyEntity);

			if (replyEntity != null) {
=======
		replyDTO.setState(true);
		Replies replyEntity = mapper.map(replyDTO, Replies.class);
		
		try {
			replyEntity = replyDAO.save(replyEntity);
			
			if(replyEntity != null) {
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
				return true;
			}
		} catch (Exception e) {
			throw new MessageException("댓글 작성 실패");
		}
		return false;
	}
<<<<<<< HEAD

	/**
	 * 하나의 댓글 조회
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public RepliesDTO getReply(Long id) throws Exception {
		Optional<Replies> replyEntity = replyDAO.findById(id);

		if (replyEntity.get() == null) {
			throw new MessageException("존재하지 않는 댓글입니다.");
		}

		RepliesDTO replyDTO = mapper.map(replyEntity.get(), RepliesDTO.class);

		return replyDTO;
	}

	/**
	 * 동일한 communityId를 가진 모든 댓글 조회
	 * 
	 * @param communityId
	 * @return
	 * @throws Exception
	 */
	public List<RepliesDTO> getAllReply(Long communityId) throws Exception {
		List<Replies> replyAllEntity = replyDAO.getAllReplyByCommunityId(communityId);

		if (replyAllEntity == null) {
			throw new MessageException("존재하는 댓글이 없습니다.");
		}

		List<RepliesDTO> replyAllDTO = Arrays.asList(mapper.map(replyAllEntity, RepliesDTO[].class));

		return replyAllDTO;
	}

	/**
	 * 하나의 댓글 수정
	 * 
	 * @param replyId
	 * @param content
	 * @param memberId
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public boolean modifyReply(Long replyId, String content, String memberId/* session */) throws Exception {
		RepliesDTO replyDTO = getReply(replyId);

		int result = 0;

		if (replyId != 0 && replyDTO.getMemberId() != null) { // 임시코드
//		if(replyId != 0 && replyDTO.getMemberId() == 세션id값) {  // 수정 방향 코드
			result = replyDAO.updateReplyContentByReplyId(replyId, content, LocalDateTime.now(), memberId);
		} else if (result == 0) {
			throw new MessageException("댓글 수정 실패");
		}
		return true;
	}

	/**
	 * 하나의 댓글 삭제(수정)
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public boolean deleteReply(Long id) throws Exception {
		RepliesDTO replyDTO = getReply(id);

		int result = 0;

		if (id != 0 && replyDTO.isDeleted() == false && replyDTO.getMemberId() != null) { // 임시 코드
//		if(replyId != 0 && replyDTO.isState() == true && replyDTO.getMemberId() == 세션값) { // 수정 지향
			result = replyDAO.deleteReplyByReplyId(id, LocalDateTime.now());
		} else if (result == 0) {
			throw new MessageException("댓글 삭제 실패");
		}
		return true;
	}

=======
	
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
}
