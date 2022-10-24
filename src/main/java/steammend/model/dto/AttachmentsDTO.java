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
	private long attachmentId;
	private long communityId;
	private String originName;
	private String serverName;
	private String path;
	
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
