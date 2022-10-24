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
	private long communityId;
	private String memberId;
	private String header;
	private String title;
	private String content;
	private String writeDate;
	private int hit;
	private boolean isState;
	
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
