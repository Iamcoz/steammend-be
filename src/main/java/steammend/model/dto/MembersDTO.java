package steammend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import steammend.model.entity.Members;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class MembersDTO {
	private String id;
	private String password;
	private String name;
	private String nickname;
	private String birth;
	private String steamId;
	private boolean isState;

	public Members toEntity() {
		return	Members.builder().
				id(id).
				password(password).
				name(name).
				nickname(nickname).
				birth(birth).
				steamId(steamId).
				isState(isState).
				build();
	}
}
