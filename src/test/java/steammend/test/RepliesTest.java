package steammend.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import steammend.model.dto.RepliesDTO;
import steammend.service.RepliesService;

/** given / when / then 수정 필요
 * 
 * @author oz
 *
 */
@SpringBootTest
public class RepliesTest {

	@Autowired
	RepliesService replyService;
	
	
	/* 하나의 댓글 등록 */
//	@Test
//	void addReply() {
//		RepliesDTO replyDTO = new RepliesDTO(31L, "coz", "내용");
//		
//		try {
//			replyService.addReply(replyDTO);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
//	/* 하나의 댓글 조회 */
////	@Test
//	void reply() {
//		Long replyId = 16L;
//		
//		try {
//			RepliesDTO reply = replyService.getReply(replyId);
//			System.out.println("****** \n"+reply);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
//	/* 하나의 댓글 수정 */
////	@Test
//	void modifyReply() {
//		Long replyId = 17L;
//		String content = "내 수정 용";
//		String memberId = "coz";
//		
//		try {
//			replyService.modifyReply(replyId, content, memberId);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
//	/* 하나의 댓글 삭제(수정) */
//	@Test
//	void deleteReply() {
//		Long replyId = 12L;
//		
//		try {
//			replyService.deleteReply(replyId);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
