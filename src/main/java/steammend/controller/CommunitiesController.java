package steammend.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import steammend.model.dto.AttachmentsDTO;
import steammend.model.dto.CommunitiesDTO;
import steammend.service.AttachmentsService;
import steammend.service.CommunitiesService;
import steammend.util.MD5Generator;

@RestController
@RequestMapping("community")
public class CommunitiesController {

	@Autowired
	private CommunitiesService commuService;
	
	@Autowired
	private AttachmentsService atchService;

	
	/* 하나의 게시글 작성 */
//	@PostMapping("/add")
//	public boolean addCommunity(@RequestBody CommunitiesDTO commuDTO) throws Exception {
//		return commuService.addCommunity(commuDTO);
//	}
	/* 하나의 게시글 작성 + 첨부파일*/
//	@PostMapping(value = "/add", consumes = {"multipart/form-data"})
	@PostMapping("/add")
	public boolean addCommunity(@RequestPart CommunitiesDTO commuDTO, @RequestPart(value = "attachment", required = false) MultipartFile attachment) throws Exception {//List<MultipartFile> attachments) {// throws Exception {
		
//		try {
////			
////			String originalName = attachment.getOriginalFilename();
////			String uploadName = new MD5Generator(originalName).toString();
////			
////			// local 파일 저장 위치
////			String saveDir = File.separator + "Steammend" + File.separator + "download" + File.separator;
////			
////			// savePath dir 미 존재시 경로 생성
////			if(!new File(saveDir).exists()) {
////				try {
////					new File(saveDir).mkdir();
////				} catch (Exception e) {
////					e.getStackTrace();
////				}
////			}
////			
////			String uploadPath = saveDir + File.separator + uploadName;
////			attachment.transferTo(new File(uploadPath));
////			
////			AttachmentsDTO atchDTO = new AttachmentsDTO(commuDTO.getId(), originalName, uploadName, uploadPath);
////
////			Long attachmentId = atchService.addAttachment(atchDTO);
////			System.out.println(attachmentId);
////			commuDTO.setAttachmentId(attachmentId);
////
////			commuService.addCommunity(commuDTO);
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
		
		
		
//		try {
//			String originalName;
//			String uploadName;
//			String saveDir;
//			String uploadPath;
//			AttachmentsDTO createAtchDTO;
//			AttachmentsDTO saveAtchDTO;
//			List<AttachmentsDTO> atchDTOList = new ArrayList<AttachmentsDTO>();
//			
//			
//			for(MultipartFile attachment : attachments) {
//				originalName = attachment.getOriginalFilename();
//				uploadName = new MD5Generator(originalName).toString();
//				
//				// local 파일 저장 위치
//				saveDir = File.separator + "Steammend" + File.separator + "download" + File.separator;
//				
//				// savePath dir 미 존재시 경로 생성
//				if(!new File(saveDir).exists()) {
//					try {
//						new File(saveDir).mkdir();
//					} catch (Exception e) {
//						e.getStackTrace();
//					}
//				}
//				
//				uploadPath = saveDir + File.separator + uploadName;
//				
//				attachment.transferTo(new File(uploadPath));
//				
//				createAtchDTO = new AttachmentsDTO(commuDTO.getId(), originalName, uploadName, uploadPath);
//				
//				saveAtchDTO = atchService.addAttachment(createAtchDTO);
//				atchDTOList.add(saveAtchDTO); 
//			}
//			System.out.println("********" + atchDTOList);
//			commuDTO.setAttachments(atchDTOList);
//			commuService.addCommunity(commuDTO);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return commuService.addCommunity(commuDTO, attachment);
	}
	
	
	/* 전체 게시글을 10개씩 페이징 하여 조회 */
	@GetMapping("/allCommunity")
	public List<CommunitiesDTO> allCommunity(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) throws Exception{
		return commuService.getAllCommunity(pageable);
	}
	
	
	/* 하나의 게시글 조회수 1씩 증가하며 조회 */
//	@GetMapping("/community")
//	public CommunitiesDTO community(Long id) throws Exception {
//		commuService.modifyHit(id);
//		return commuService.getCommunity(id);
//	}
	/* 하나의 게시글 조회수 1씩 증가하며 조회 + 첨부파일*/
	@GetMapping("/community")
	public CommunitiesDTO community(Long id) throws Exception {
		commuService.modifyHit(id);
		return commuService.getCommunity(id);
	}
	
	
	/* 하나의 게시글 수정 */
	@PostMapping("/modify")
	public boolean modifyCommunity(@RequestBody CommunitiesDTO commuDTO) throws Exception {
		return	commuService.modifyCommunity(commuDTO.getId(), 
											commuDTO.getHeader(), 
											commuDTO.getTitle(), 
											commuDTO.getContent(),
											commuDTO.getMemberId());
		
	}
	
	
	/* 하나의 게시글 삭제 */
	@PostMapping("/delete")
	public boolean deleteCommunity(@RequestBody CommunitiesDTO commuDTO) throws Exception {
		return commuService.deleteCommunity(commuDTO.getId());
	}
	
	
	/* 검색된 게시글을 10개씩 페이징 하여 조회 */
	@GetMapping("/search")
	public List<CommunitiesDTO> searchCommunity(String keyword, @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) throws Exception{
		return commuService.searchCommunity(keyword, pageable);
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

}
