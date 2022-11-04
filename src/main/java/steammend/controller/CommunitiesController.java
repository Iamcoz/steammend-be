package steammend.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import steammend.model.dto.AttachmentsDTO;
import steammend.model.dto.CommunitiesDTO;
import steammend.service.AttachmentsService;
import steammend.service.CommunitiesService;

@RestController
@RequestMapping("community")
public class CommunitiesController {

	@Autowired
	private CommunitiesService commuService;

	@Autowired
	private AttachmentsService atchService;
	

	/* 하나의 게시글 작성 + 첨부파일 */
	@PostMapping(value = "/add", consumes = { "multipart/form-data" })
	public boolean addCommunity(CommunitiesDTO commuDTO,
			@RequestPart(value = "attachment", required = false) MultipartFile attachment) throws Exception {
		System.out.println("**** controller addCommunity\n" + attachment);

		try {

			String originalName = attachment.getOriginalFilename();
			String uploadNameExt = originalName.substring(originalName.lastIndexOf("."));
			String uploadName = UUID.randomUUID().toString();

//			String saveDir = System.getProperty("user.home") + File.separator + "steammend" + File.separator + "download";
			String saveDir = "/Users/oz/Documents/steamUpload";

			if (!new File(saveDir).exists()) {
				try {
					new File(saveDir).mkdir();
				} catch (Exception e) {
					e.getStackTrace();
				}
			}

			String uploadPath = saveDir + File.separator + uploadName + uploadNameExt;
			
			Path path = Paths.get(uploadPath).toAbsolutePath();
			attachment.transferTo(path.toFile());

			AttachmentsDTO atchDTO = new AttachmentsDTO(commuDTO.getId(), originalName, uploadName, uploadPath);
			atchService.addAttachment(atchDTO);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return commuService.addCommunity(commuDTO);
	}

	/* 전체 게시글을 10개씩 페이징 하여 조회 */
	@GetMapping("/allCommunity")
	public List<CommunitiesDTO> allCommunity(
			@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) throws Exception {
		return commuService.getAllCommunity(pageable);
	}

	/* 하나의 게시글 조회수 1씩 증가하며 조회 */
//	@GetMapping("/community")
//	public CommunitiesDTO community(Long id) throws Exception {
//		commuService.modifyHit(id);
//		return commuService.getCommunity(id);
//	}
	/* 하나의 게시글 조회수 1씩 증가하며 조회 + 첨부파일 */
	@GetMapping("/community")
	public CommunitiesDTO community(Long id) throws Exception {
		commuService.modifyHit(id);
//		List<AttachmentsDTO> atchList =  atchService.getAllAttachment(id);
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
