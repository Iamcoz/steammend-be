package steammend.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import steammend.model.dto.CommunitiesDTO;
import steammend.model.entity.Communities;
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
	
	
	/* 전체 게시글을 10개씩 페이징 하여 조회 */
	@Test
	void allCommunity() {
		Pageable pagable = PageRequest.of(1, 10, Sort.Direction.DESC, "communityId");

        try {
			List<CommunitiesDTO> result = commuService.getAllCommunity(pagable);
			System.out.println("**********\n" + result + "\n");
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
