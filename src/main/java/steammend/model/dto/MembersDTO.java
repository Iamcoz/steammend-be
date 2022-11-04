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
	private String createdAt;
	private String updatedAt;
	private boolean isDeleted;
	
	
	public MembersDTO(String id, String password, String name, String nickname, String birth, String steamId, boolean isDeleted) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.birth = birth;
		this.steamId = steamId;
		this.isDeleted = isDeleted;
	}

	public Members toEntity() {
		return	Members.builder().
				id(id).
				password(password).
				name(name).
				nickname(nickname).
				birth(birth).
				steamId(steamId).
				isDeleted(isDeleted).
				build();
	}
}
