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
	}
	
	public Attachments toEntity() {
		return 	Attachments.builder().
				communityId(communityId).
				originalName(originalName).
				uploadName(uploadName).
				uploadPath(uploadPath).
				build();
	}
}
