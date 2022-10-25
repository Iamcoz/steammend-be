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
	
	
	/** 하나의 게시글 등록
	 * 
	 */
	@Test
	void save() {
		CommunitiesDTO commuDTO =  new CommunitiesDTO("coz", "말머리", "제목", "내용", true);
		
		try {
			commuService.addCommunity(commuDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
