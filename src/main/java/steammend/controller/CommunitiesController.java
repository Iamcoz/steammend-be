package steammend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import steammend.model.dto.CommunitiesDTO;
import steammend.service.CommunitiesService;

@RestController
public class CommunitiesController {

	@Autowired
	private CommunitiesService commuService;

	/* 하나의 게시글 작성 */
	@PostMapping("/add")
	public boolean addCommunity(@RequestBody CommunitiesDTO commuDTO) throws Exception {
		System.out.println(commuDTO);
		return commuService.addCommunity(commuDTO);
	}

	/* 전체 게시글을 10개씩 페이징 하여 조회 */
	@GetMapping("/allCommunity")
	public List<CommunitiesDTO> allCommunity(
			@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) throws Exception {
		return commuService.getAllCommunity(pageable);
	}

	/* 하나의 게시글 조회수 1씩 증가하며 조회 */
	@GetMapping("/community")
	public CommunitiesDTO community(Long id) throws Exception {
		commuService.modifyHit(id);
		return commuService.getCommunity(id);
	}

	/* 하나의 게시글 수정 */
	@PostMapping("/modify")
	public boolean modifyCommunity(@RequestBody CommunitiesDTO commuDTO) throws Exception {
		return commuService.modifyCommunity(commuDTO.getId(), commuDTO.getHeader(), commuDTO.getTitle(),
				commuDTO.getContent(), commuDTO.getMemberId());

	}

	/* 하나의 게시글 삭제 */
	@PostMapping("/delete")
	public boolean deleteCommunity(@RequestBody CommunitiesDTO commuDTO) throws Exception {
		return commuService.deleteCommunity(commuDTO.getId());
	}

	/* 검색된 게시글을 10개씩 페이징 하여 조회 */
	@GetMapping("/search")
	public List<CommunitiesDTO> searchCommunity(String keyword,
			@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) throws Exception {
		return commuService.searchCommunity(keyword, pageable);
	}

}
