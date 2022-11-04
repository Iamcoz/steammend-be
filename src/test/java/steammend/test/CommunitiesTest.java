package steammend.test;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import steammend.model.dto.CommunitiesDTO;
import steammend.service.CommunitiesService;


/** given / when / then으로 수정 필요
 * 
 * @author oz
 *
 */
@SpringBootTest
public class CommunitiesTest {

	@Autowired
	CommunitiesService commuService;
	
	
	/* 하나의 게시글 등록 */
//	@Test
<<<<<<< HEAD
//	void addCommunity() {
//		CommunitiesDTO commuDTO = new CommunitiesDTO("coz", "말머리", "제목", "내용");
//		
//		try {
//			commuService.addCommunity(commuDTO);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	
	/* 삭제되지 않은 게시글들만 10개씩 페이징 하여 조회 */
//	@Test
	void allCommunity() {
		Pageable pagable = PageRequest.of(1, 10, Sort.Direction.DESC, "id");
=======
	void addCommunity() {
		CommunitiesDTO commuDTO =  new CommunitiesDTO("coz", "말머리", "제목", "내용", true);
		
		try {
			commuService.addCommunity(commuDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/* 전체 게시글을 10개씩 페이징 하여 조회 */
//	@Test
	void allCommunity() {
		Pageable pagable = PageRequest.of(1, 10, Sort.Direction.DESC, "communityId");
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8

        try {
			commuService.getAllCommunity(pagable);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	/* 하나의 게시글 조회수 1씩 증가하며 조회 */
//	@Test
	void community() {
<<<<<<< HEAD
		Long id = 2L;
		
		try {
			commuService.modifyHit(id);
			commuService.getCommunity(id);
=======
		Long communityId = 15L;
		
		try {
			commuService.modifyHit(communityId);
			commuService.getCommunity(communityId);
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/* 하나의 게시글 수정 */
<<<<<<< HEAD
//	@Test
	void modifyCommunity() {
		Long id = 10L;
=======
	@Test
	void modifyCommunity() {
		Long communityId = 17L;
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
		String header = "수정 말머리";
		String title = "수정 제목";
		String content = "수정 내용";
		String memberId = "coz";
		
		try {
<<<<<<< HEAD
			commuService.modifyCommunity(id, header, title, content, memberId);
=======
			commuService.modifyCommunity(communityId, header, title, content, memberId);
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/* 하나의 게시글 삭제(수정) */
<<<<<<< HEAD
	@Test
	void deleteCommunity() {
		Long id = 10L;
		
		try {
			commuService.deleteCommunity(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/* 제목 or 내용에 특정 키워드를 포함한 게시글을 10개씩 페이징 하여 조회 */
//	@Test
	void searchCommunity() {
		String keyword = "제";
		Pageable pagable = PageRequest.of(0, 2, Sort.Direction.DESC, "id");

        try {
			List<CommunitiesDTO> searchCommunity = commuService.searchCommunity(keyword, pagable);
			System.out.println("*****\n " + searchCommunity + "\n");
=======
//	@Test
	void deleteCommunity() {
		Long communityId = 18L;
		
		try {
			commuService.deleteCommunity(communityId);
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
