package steammend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
@RequestMapping("community")
public class CommunitiesController {

	@Autowired
	private CommunitiesService commuService;

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
	public CommunitiesDTO community(long communityId) throws Exception {
		commuService.modifyHit(communityId);
		return commuService.getCommunity(communityId);
	}
	
	
	/* 하나의 게시글 수정 */
	@PostMapping("/modify")
	public boolean modifyCommunity(long communityId, String header, String title, String content, String memberId/*session*/) throws Exception {
		return commuService.modifyCommunity(communityId, header, title, content, memberId/*session*/);
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
//			long attachmentId = commuService.addAttchment(atchDTO);
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
