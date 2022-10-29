package steammend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import steammend.model.entity.Replies;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class RepliesDTO {
	private Long replyId;
	private Long communityId;
	private String memberId;
	private String content;
	private String writeDate;
	private boolean isState;
	
	
	public RepliesDTO(Long communityId, String memberId, String content) {
		this.communityId = communityId;
		this.memberId = memberId;
		this.content = content;
	}
	
	
	public Replies toEntity() {
		return	Replies.builder().
//				replyId(replyId).
				communityId(communityId).
				memberId(memberId).
				content(content).
//				writeDate(writeDate).
				isState(isState).
				build();
	}
}
