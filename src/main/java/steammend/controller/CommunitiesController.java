package steammend.controller;

<<<<<<< HEAD
import java.io.File;
=======
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import steammend.model.dto.AttachmentsDTO;
import steammend.model.dto.CommunitiesDTO;
import steammend.service.AttachmentsService;
import steammend.service.CommunitiesService;
import steammend.util.MD5Generator;
=======
import org.springframework.web.bind.annotation.RestController;

import steammend.model.dto.CommunitiesDTO;
import steammend.service.CommunitiesService;
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8

@RestController
@RequestMapping("community")
public class CommunitiesController {

	@Autowired
	private CommunitiesService commuService;

<<<<<<< HEAD
	@Autowired
	private AttachmentsService atchService;

	/* 하나의 게시글 작성 */
//	@PostMapping("/add")
//	public boolean addCommunity(@RequestBody CommunitiesDTO commuDTO) throws Exception {
//		return commuService.addCommunity(commuDTO);
//	}

	/* 하나의 게시글 작성 + 첨부파일 */
	@PostMapping(value = "/add", consumes = { "multipart/form-data" })
	public boolean addCommunity(CommunitiesDTO commuDTO,
			@RequestPart(value = "attachment", required = false) MultipartFile attachment) throws Exception {// List<MultipartFile>
																												// attachments)
																												// {//
																												// throws
																												// Exception
																												// {
		System.out.println("**** controller addCommunity\n" + attachment);

		try {

			String originalName = attachment.getOriginalFilename();
			String uploadName = new MD5Generator(originalName).toString();

			// local 파일 저장 위치
//			String saveDir = System.getProperty("user.home") + File.separator + "steammend" + File.separator + "download";
			String saveDir = "/Users/oz/Documents/steamdownload";

			if (!new File(saveDir).exists()) {
				try {
					new File(saveDir).mkdir();
				} catch (Exception e) {
					e.getStackTrace();
				}
			}

			String uploadPath = saveDir + File.separator + uploadName;
			attachment.transferTo(new File(uploadPath));

			System.out.println("전 ***");

			AttachmentsDTO atchDTO = new AttachmentsDTO(commuDTO.getId(), originalName, uploadName, uploadPath);
			atchService.addAttachment(atchDTO);
			System.out.println("후 ***");

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
=======
	
	/* 하나의 게시글 작성 */
	@PostMapping("/add")
	public boolean addCommunity(@RequestBody CommunitiesDTO commuDTO) throws Exception {
		return commuService.addCommunity(commuDTO);
	}

	
	/* 전체 게시글을 10개씩 페이징 하여 조회 */
	@GetMapping("/allCommunity")
	public List<CommunitiesDTO> allCommunity(@PageableDefault(sort = "communityId", direction = Sort.Direction.DESC) Pageable pageable) throws Exception{
		return commuService.getAllCommunity(pageable);
	}
	/* 전체 게시글 조회 */
//	@GetMapping("/allCommunity")
//	public List<CommunitiesDTO> allCommunity() throws Exception{
//		return commuService.getAllCommunity();
//	}
	
	
	/* 하나의 게시글 조회수 1씩 증가하며 조회 */
	@GetMapping("/community")
	public CommunitiesDTO community(Long communityId) throws Exception {
		commuService.modifyHit(communityId);
		return commuService.getCommunity(communityId);
	}
	
	
	/* 하나의 게시글 수정 */
	@PostMapping("/modify")
	public boolean modifyCommunity(@RequestBody CommunitiesDTO commuDTO) throws Exception {
		return	commuService.modifyCommunity(commuDTO.getCommunityId(), 
											commuDTO.getHeader(), 
											commuDTO.getTitle(), 
											commuDTO.getContent(),
											commuDTO.getMemberId());
		
	}
	
	
	/* 하나의 게시글 삭제 */
	@PostMapping("/delete")
	public boolean deleteCommunity(@RequestBody CommunitiesDTO commuDTO) throws Exception {
		return commuService.deleteCommunity(commuDTO.getCommunityId());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* 하나의 첨부파일 등록 */
//	@PostMapping("/addComunity")
//	public boolean addCommunity(@RequestBody CommunitiesDTO commuDTO, MultipartFile attchment) {
//
//		try {
//			String originName = attchment.getOriginalFilename();
//			String serverName = new MD5Generator(originName).toString();
//
//			// 실행되는 위치의 'steammend' 폴더에 파일 저장
//			String savePath = System.getProperty("user.dir") + "\\steammend";
//
//			// 폴더 미존재 시 폴더 생성
//			if (!new File(savePath).exists()) {
//				try {
//					new File(savePath).mkdir();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			String localPath = savePath + "\\" + serverName;
//			attchment.transferTo(new File(localPath));
//			
//			AttachmentsDTO atchDTO = new AttachmentsDTO();
//			atchDTO.setOriginName(originName);
//			atchDTO.setServerName(serverName);
//			atchDTO.setPath(localPath);
//			
//			Long attachmentId = commuService.addAttchment(atchDTO);
//			commuDTO.setAttachmentId(attachmentId);
//			commuService.addCommunity(commuDTO, atchDTO);
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return true;
//
//	}
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8

}
