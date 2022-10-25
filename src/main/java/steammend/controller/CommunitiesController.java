package steammend.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	@PostMapping("/addCommunity")
	public boolean addCommunity(@RequestBody CommunitiesDTO commuDTO) throws Exception {
		boolean result = false;

		if (commuDTO != null) {
			result = commuService.addCommunity(commuDTO);

			if (result) {
				return result;
			} else {
				result = false;
			}
		}
		return result;
	}

	
	/* 하나의 게시글 조회 */
	@GetMapping("/community")
	public CommunitiesDTO community(long communityId) throws Exception {
		return commuService.getCommunity(communityId);
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
