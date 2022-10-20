package steammend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import steammend.model.entity.Community;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CommunityDTO {
	private int commuNo;
	private String memId;
	private int commuKindNo;
	private String commuHeader;
	private String commuTitle;
	private String commuContent;
	private int commuHit;
	private char commuState;
	
	public Community toEntity() {
		return 	Community.builder().
				memId(memId).
				commuKindNo(commuKindNo).
				commuHeader(commuHeader).
				commuTitle(commuTitle).
				commuContent(commuContent).
				commuHit(commuHit).
				commuState(commuState).
				build();
	}
}
