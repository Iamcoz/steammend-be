package steammend.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import steammend.model.dto.RepliesDTO;
import steammend.service.RepliesService;

@SpringBootTest
public class RepliesTest {

	@Autowired
	RepliesService replyService;
	
	
	/* 하나의 댓글 등록 */
//	@Test
	void addReply() {
		RepliesDTO replyDTO = new RepliesDTO(31L, "coz", "내용");
		
		try {
			replyService.addReply(replyDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
