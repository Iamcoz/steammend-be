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
	
	private Long communityId;
	private String memberId;
	private String header;
	private String title;
	private String content;
	private String writeDate;
	private int hit;
	private boolean isState;
	private Long attachmentId;
	
	
	public CommunitiesDTO(String memberId, String header, String title, String content, boolean isState) {
		this.memberId = memberId;
		this.header = header;
		this.title = title;
		this.content = content;
//		this.writeDate = writeDate;
//		this.hit = hit;
		this.isState = isState;
	}
	
	public CommunitiesDTO(String memberId, String header, String title, String content, boolean isState, Long attachmentId) {//, int hit, boolean isState) {
		this.memberId = memberId;
		this.header = header;
		this.title = title;
		this.content = content;
		this.isState = isState;
		this.attachmentId = attachmentId;
	}
	
	public Communities toEntity() {
		return 	Communities.builder().
//				communityId(communityId).
				memberId(memberId).
				header(header).
				title(title).
				content(content).
//				writeDate(writeDate).
//				hit(hit).
				isState(isState).
				build();
	}

}
