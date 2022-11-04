package steammend.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import steammend.model.dto.AttachmentsDTO;
import steammend.service.AttachmentsService;

@RestController
@RequestMapping("attachment")
public class AttachmentsController {

	@Autowired
	private AttachmentsService atchService;

	@GetMapping("/download")
	public boolean downloadAttachment(Long id, HttpServletResponse response) throws IOException, Exception {
		AttachmentsDTO atchDTO = atchService.getAttachment(id);

		String path = atchDTO.getUploadPath();
		
		byte[] atchByte = FileUtils.readFileToByteArray(new File(path));
		
		response.setContentType("application/octet-stream");
	    response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(atchDTO.getOriginalName(), "UTF-8")+"\";");
	    response.setHeader("Content-Transfer-Encoding", "binary");

	    response.getOutputStream().write(atchByte);
	    response.getOutputStream().flush();
	    response.getOutputStream().close();

		return true;
	}
}
