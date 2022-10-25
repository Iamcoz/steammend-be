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
public class Members {
	
	@Id
	private String id;
	
	@NonNull
	private String password;
	
	@NonNull
	private String name;
	
	@NonNull
	private String nickname;
	
	@NonNull
	private String birth;
	
	@NonNull
	private String steamId;
	
	private boolean isState;
}