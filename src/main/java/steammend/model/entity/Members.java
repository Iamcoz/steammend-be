package steammend.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
<<<<<<< HEAD
import javax.persistence.EntityListeners;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
=======
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
<<<<<<< HEAD
import lombok.Setter;
=======
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
<<<<<<< HEAD
@Setter
=======
//@Setter
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
@Builder
@ToString

@Entity
<<<<<<< HEAD
@EntityListeners(AuditingEntityListener.class)
=======
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
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
<<<<<<< HEAD
	private String birth;
=======
	private String birthday;
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
	
	@NonNull
	private String steamId;
	
	@CreatedDate
	private LocalDateTime createdAt;
	
<<<<<<< HEAD
	@LastModifiedDate
	private LocalDateTime updatedAt;

	private boolean isDeleted;

=======
	@CreatedDate
	private LocalDateTime updatedAt;

	private boolean isDeleted;
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
}