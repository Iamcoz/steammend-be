package steammend.test;

import java.time.LocalDateTime;

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
	void addReply() {
		RepliesDTO replyDTO = new RepliesDTO(2L, "coz", "내용");
		
		try {
			replyService.addReply(replyDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/* 하나의 댓글 조회 */
//	@Test
	void reply() {
		Long id = 1L;
		
		try {
			RepliesDTO reply = replyService.getReply(id);
			System.out.println("****** \n"+reply);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/* 하나의 댓글 수정 */
//	@Test
	void modifyReply() {
		Long id = 2L;
		String content = "내 수정 용";
		LocalDateTime updatedAt = LocalDateTime.now();
		String memberId = "coz";
		
		try {
			replyService.modifyReply(id, content, updatedAt, memberId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/* 하나의 댓글 삭제(수정) */
	@Test
	void deleteReply() {
		Long id = 2L;
		
		try {
			replyService.deleteReply(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
