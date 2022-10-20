package steammend.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString

@Entity
public class Member {
	
	@Id
	private String memId;
	
	@NonNull
	private String memPass;
	
	@NonNull
	private String memName;
	
	@NonNull
	private String memNickname;
	
	private char memState;
}
