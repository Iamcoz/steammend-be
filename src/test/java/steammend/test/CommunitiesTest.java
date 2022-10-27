package steammend.test;

import java.util.List;

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

        try {
			List<CommunitiesDTO> result = commuService.getAllCommunity(pagable);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	/* 하나의 게시글 조회수 1씩 증가하며 조회 */
//	@Test
	void community() {
		long communityId = 3;
		
		try {
			commuService.modifyHit(communityId);
			commuService.getCommunity(communityId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/* 하나의 게시글 수정 */
	@Test
	void modifyCommunity() {
		long communityId = 3;
		String header = "수정 말머리";
		String title = "수정 제목";
		String content = "수정 내용";
		String memberId = "coz";
		
		try {
			commuService.modifyCommunity(communityId, header, title, content, memberId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
