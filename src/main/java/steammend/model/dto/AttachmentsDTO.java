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

//@ConfigurationProperties(prefix="file")
public class AttachmentsDTO {
	private Long id;
	private Long communityId;
	private String path;
	private String createdAt;
	private String updatedAt;
	private boolean isDeleted;
	
	public AttachmentsDTO(Long communityId, String path) {
		this.id = communityId;
		this.path = path;
	}
	
	public Attachments toEntity() {
		return 	Attachments.builder().
				communityId(communityId).
				path(path).
				build();
	}
}
