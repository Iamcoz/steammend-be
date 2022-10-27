package steammend.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import steammend.exception.MessageException;
import steammend.model.RepliesDAO;
import steammend.model.dto.RepliesDTO;
import steammend.model.entity.Replies;

@Service
public class RepliesService {
	
	@Autowired
	private RepliesDAO replyDAO;
	
	private ModelMapper mapper = new ModelMapper();
	
	
	/** 하나의 댓글 작성
	 * 
	 * @param replyDTO
	 * @return
	 * @throws Exception
	 */
	public boolean addReply(RepliesDTO replyDTO) throws Exception {
		replyDTO.setState(true);
		Replies replyEntity = mapper.map(replyDTO, Replies.class);
		
		try {
			replyEntity = replyDAO.save(replyEntity);
			
			if(replyEntity != null) {
				return true;
			}
		} catch (Exception e) {
			throw new MessageException("댓글 작성 실패");
		}
		return false;
	}
	
}
