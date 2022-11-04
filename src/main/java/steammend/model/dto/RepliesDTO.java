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
<<<<<<< HEAD
	
	private Long id;
	private Long communityId;
	private String memberId;
	private String content;
	private String createdAt;
	private String updatedAt;
	private boolean isDeleted;
=======
	private Long replyId;
	private Long communityId;
	private String memberId;
	private String content;
	private String writeDate;
	private boolean isState;
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
	
	
	public RepliesDTO(Long communityId, String memberId, String content) {
		this.communityId = communityId;
		this.memberId = memberId;
		this.content = content;
	}
	
	
	public Replies toEntity() {
		return	Replies.builder().
<<<<<<< HEAD
				communityId(communityId).
				memberId(memberId).
				content(content).
				isDeleted(isDeleted).
=======
//				replyId(replyId).
				communityId(communityId).
				memberId(memberId).
				content(content).
//				writeDate(writeDate).
				isState(isState).
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
				build();
	}
}
