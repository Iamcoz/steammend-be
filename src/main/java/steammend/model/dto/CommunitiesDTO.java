package steammend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import steammend.model.entity.Communities;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CommunitiesDTO {
	
	private Long id;
	private String memberId;
	private String header;
	private String title;
	private String content;
	private int hit;
	private String createdAt;
	private String updatedAt;
	private boolean isDeleted;
	
//	private Long attachmentId;
	
	
	public CommunitiesDTO(String memberId, String header, String title, String content) {
		this.memberId = memberId;
		this.header = header;
		this.title = title;
		this.content = content;
	}
	
//	public CommunitiesDTO(String memberId, String header, String title, String content, boolean isDeleted) {
//		this.memberId = memberId;
//		this.header = header;
//		this.title = title;
//		this.content = content;
////		this.writeDate = writeDate;
////		this.hit = hit;
//		this.isDeleted = isDeleted;
//	}
	
//	public CommunitiesDTO(String memberId, String header, String title, String content, boolean isDeleted, Long attachmentId) {//, int hit, boolean isState) {
//		this.memberId = memberId;
//		this.header = header;
//		this.title = title;
//		this.content = content;
//		this.isDeleted = isDeleted;
//		this.attachmentId = attachmentId;
//	}
	
	public Communities toEntity() {
		return 	Communities.builder().
//				communityId(communityId).
				memberId(memberId).
				header(header).
				title(title).
				content(content).
//				writeDate(writeDate).
//				hit(hit).
//				isDeleted(isDeleted).
				build();
	}

}
