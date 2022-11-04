package steammend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import steammend.model.entity.Attachments;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString

<<<<<<< HEAD
public class AttachmentsDTO {
	
	private Long id;
	private Long communityId;
	private String originalName; 
	private String uploadName;
	private String uploadPath;
	private String createdAt;
	private String updatedAt;
	private boolean isDeleted;
	
	
	public AttachmentsDTO(Long communityId, String originalName, String uploadName, String uploadPath) {
		this.communityId = communityId;
		this.originalName = originalName;
		this.uploadName = uploadName;
		this.uploadPath = uploadPath;
=======
//@ConfigurationProperties(prefix="file")
public class AttachmentsDTO {
	private Long attachmentId;
	private Long communityId;
	private String originName;
	private String serverName;
	private String path;
	
	public AttachmentsDTO(Long communityId, String originName, String serverName, String path) {
		this.communityId = communityId;
		this.originName = originName;
		this.serverName = serverName;
		this.path = path;
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
	}
	
	public Attachments toEntity() {
		return 	Attachments.builder().
<<<<<<< HEAD
				communityId(communityId).
				originalName(originalName).
				uploadName(uploadName).
				uploadPath(uploadPath).
=======
//				attachmentId(attachmentId).
				communityId(communityId).
				originName(originName).
				serverName(serverName).
				path(path).
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
				build();
	}
}
