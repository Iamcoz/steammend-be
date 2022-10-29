package steammend.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
//@Setter
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
	
	@CreatedDate
	private LocalDateTime createdAt;
	
	@CreatedDate
	private LocalDateTime updatedAt;

	private boolean isDeleted;
}