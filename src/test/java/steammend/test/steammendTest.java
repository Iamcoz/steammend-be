package steammend.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import steammend.model.dto.CommunitiesDTO;
import steammend.service.CommunitiesService;

@SpringBootTest
public class steammendTest {

	@Autowired
	CommunitiesService commuService;
	
	
	/* 하나의 게시글 등록 */
	@Test
	void addCommunity() {
		CommunitiesDTO commuDTO =  new CommunitiesDTO("coz", "말머리", "제목", "내용", true);
		
		try {
			commuService.addCommunity(commuDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/* 전체 게시글 조회 */
	@Test
	void allCommunity() {
		try {
			commuService.getAllCommunity();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/* 하나의 게시글 조회수 1씩 증가하며 조회 */
	@Test
	void community() {
		long communityId = 3;
		
		try {
			commuService.modifyHit(communityId);
			commuService.getCommunity(communityId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
