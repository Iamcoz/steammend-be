package steammend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import steammend.model.entity.Member;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class MemberDTO {
	private String memId;
	private String memPass;
	private String memName;
	private String memNickname;
	private char memState;
	
	public Member toEntity() {
		return	Member.builder().
				memId(memId).
				memPass(memPass).
				memName(memName).
				memNickname(memNickname).
				memState(memState).
				build();
	}
}
