package steammend.test;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import steammend.model.dto.RepliesDTO;
import steammend.service.RepliesService;

<<<<<<< HEAD
/** given / when / then 수정 필요
 * 
 * @author oz
 *
 */
=======
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
@SpringBootTest
public class RepliesTest {

	@Autowired
	RepliesService replyService;
	
	
	/* 하나의 댓글 등록 */
//	@Test
	void addReply() {
<<<<<<< HEAD
		RepliesDTO replyDTO = new RepliesDTO(2L, "coz", "내용");
=======
		RepliesDTO replyDTO = new RepliesDTO(31L, "coz", "내용");
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
		
		try {
			replyService.addReply(replyDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
<<<<<<< HEAD
	
	
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
	
	/* 동일한 communityId를 가진 모든 댓글 조회 */
	@Test
	void allReply() {
		Long communityId = 2L;
		
		try {
			List<RepliesDTO> allReply = replyService.getAllReply(communityId);
			System.out.println("***** allReply\n" + allReply + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/* 하나의 댓글 수정 */
//	@Test
	void modifyReply() {
		Long id = 3L;
		String content = "내 수정 용";
		String memberId = "coz";
		
		try {
			replyService.modifyReply(id, content, memberId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/* 하나의 댓글 삭제(수정) */
//	@Test
	void deleteReply() {
		Long id = 2L;
		
		try {
			replyService.deleteReply(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
=======
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
}
