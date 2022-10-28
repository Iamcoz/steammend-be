package steammend.service;

import java.util.Optional;

import javax.transaction.Transactional;

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
	
	
	/** 하나의 댓글 조회
	 * 
	 * @param replyId
	 * @return
	 * @throws Exception
	 */
	public RepliesDTO getReply(Long replyId) throws Exception {
		Optional<Replies> replyEntity = replyDAO.findById(replyId);
		
		if(replyEntity.get() == null) {
			throw new MessageException("존재하지 않는 댓글입니다.");
		}
		
		RepliesDTO replyDTO = mapper.map(replyEntity.get(), RepliesDTO.class);
		
		return replyDTO;
	}
	
	
	/** 하나의 댓글 수정
	 * 
	 * @param replyId
	 * @param content
	 * @param memberId
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public boolean modifyReply(Long replyId, String content, String memberId/*session*/) throws Exception {
		RepliesDTO replyDTO = getReply(replyId);
		
		int result = 0;
		
		if(replyId != 0 && replyDTO.getMemberId() != null) {  // 임시코드
//		if(replyId != 0 && replyDTO.getMemberId() == 세션id값) {  // 수정 방향 코드
			result = replyDAO.updateReplyContentByReplyId(replyId, content, memberId);
		} else if (result == 0) {
			throw new MessageException("댓글 수정 실패");
		}
		return true;
	}
	
	
	/** 하나의 댓글 삭제(수정)
	 * 
	 * @param replyId
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public boolean deleteReply(Long replyId) throws Exception {
		RepliesDTO replyDTO = getReply(replyId);
		
		int result = 0;
		
		if(replyId != 0 && replyDTO.isState() == true && replyDTO.getMemberId() !=  null) { // 임시 코드
//		if(replyId != 0 && replyDTO.isState() == true && replyDTO.getMemberId() == 세션값) { // 수정 지향
			result = replyDAO.deleteReplyByReplyId(replyId);
		} else if(result == 0) {
			throw new MessageException("댓글 삭제 실패");
		}
		return true;
	}











}
