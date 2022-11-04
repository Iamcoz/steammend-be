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
<<<<<<< HEAD
	
=======
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
	private String id;
	private String password;
	private String name;
	private String nickname;
<<<<<<< HEAD
	private String birth;
=======
	private String birthday;
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
	private String steamId;
	private String createdAt;
	private String updatedAt;
	private boolean isDeleted;
<<<<<<< HEAD
	
	
	public MembersDTO(String id, String password, String name, String nickname, String birth, String steamId, boolean isDeleted) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.birth = birth;
		this.steamId = steamId;
		this.isDeleted = isDeleted;
	}
=======
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8

	public Members toEntity() {
		return	Members.builder().
				id(id).
				password(password).
				name(name).
				nickname(nickname).
<<<<<<< HEAD
				birth(birth).
=======
				birthday(birthday).
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
				steamId(steamId).
				isDeleted(isDeleted).
				build();
	}
<<<<<<< HEAD
=======
	
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
	
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
}
