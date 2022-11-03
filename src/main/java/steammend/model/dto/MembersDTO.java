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
	private String birthday;
	private String steamId;
	private String createdAt;
	private String updatedAt;
	private boolean isDeleted;

	public Members toEntity() {
		return	Members.builder().
				id(id).
				password(password).
				name(name).
				nickname(nickname).
				birthday(birthday).
				steamId(steamId).
				isDeleted(isDeleted).
				build();
	}
	
	public MembersDTO(String id, String steamId) {
		super();
		this.id = id;
		this.steamId = steamId;
	}

	public MembersDTO(String id, String password, String name, String nickname, String birth, String steamId) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.birthday = birth;
		this.steamId = steamId;
	}
	
}
