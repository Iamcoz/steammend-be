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
	}
	
	public Attachments toEntity() {
		return 	Attachments.builder().
//				attachmentId(attachmentId).
				communityId(communityId).
				originName(originName).
				serverName(serverName).
				path(path).
				build();
	}
}
