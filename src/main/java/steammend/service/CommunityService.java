package steammend.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import steammend.exception.MessageException;
import steammend.model.CommunityDAO;
import steammend.model.dto.CommunityDTO;
import steammend.model.entity.Community;

@Service
public class CommunityService {

	@Autowired
	private CommunityDAO commuDAO;
	
	private ModelMapper mapper = new ModelMapper();
	
	
	/** 하나의 게시글 작성
	 * 
	 * @param commuDTO
	 * @return
	 * @throws Exception
	 */
	public boolean insertCommu(CommunityDTO commuDTO) throws Exception{
		Community commuEntity = mapper.map(commuDTO, Community.class);
		
		boolean result = false;
		
		try {
			commuEntity = commuDAO.save(commuEntity);

			if(commuEntity != null) {
				result = true;
			}
		}catch (Exception e) {
			throw new MessageException("게시글 작성 실패");
		}
		
		return result;
	}
	
	
	/** 하나의 게시글 조회
	 * 
	 * @param commuNo
	 * @return
	 * @throws Exception
	 */
	public CommunityDTO selectOneCommu(int commuNo) throws Exception{
		Optional<Community> commuEntity = commuDAO.findById(commuNo);
		
		if(commuEntity.get() == null) {
			throw new MessageException("존재하지 않는 게시글 번호 입니다.");
		}
		
		CommunityDTO commuDTO = mapper.map(commuEntity.get(), CommunityDTO.class);
		
		return commuDTO;
	}
	
	
	@Transactional
	public boolean updateCommunity(int commuNo, String commuHeader, String commuTitle, String commuContent) throws Exception{
		int result = commuDAO.updateCommunity(commuNo, commuHeader, commuTitle, commuContent);
		
		if(result == 0) {
			throw new MessageException("게시글 수정 성공");
		}
		
		return true;
	}
	
}
