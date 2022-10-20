package steammend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import steammend.model.entity.Reply;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ReplyDTO {
	private int replyNo;
	private int commuNo;
	private String memId;
	private String replyContent;
	private String replyDate;
	private char replyState;
	
	public Reply toEntity() {
		return	Reply.builder().
				commuNo(commuNo).
				memId(memId).
				replyContent(replyContent).
				replyDate(replyDate).
				replyState(replyState).
				build();
	}
}
