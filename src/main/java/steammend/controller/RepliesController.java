package steammend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import steammend.model.dto.RepliesDTO;
import steammend.service.RepliesService;

@RestController
@RequestMapping("reply")
public class RepliesController {

	@Autowired
	private RepliesService replyService;
	
	
	/* 하나의 댓글 작성 */
	@PostMapping("/add")
	public boolean addReply(@RequestBody RepliesDTO replyDTO) throws Exception {
		return replyService.addReply(replyDTO);
	}
	
	
	/* 하나의 댓글 조회 */
	@GetMapping("/reply")
	public RepliesDTO reply(Long replyId) throws Exception {
		return replyService.getReply(replyId);
	}
	
	
	/* 하나의 게시글 수정 */
	@PostMapping("/modify")
	public boolean modifyReply(@RequestBody RepliesDTO replyDTO) throws Exception {
		return replyService.modifyReply(replyDTO.getReplyId(),
										replyDTO.getContent(),
										replyDTO.getMemberId());
	}
	
}
