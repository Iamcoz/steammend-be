package steammend.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

<<<<<<< HEAD
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
=======
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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

<<<<<<< HEAD
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Replies {
	
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
=======
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Replies {
	
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long replyId;
	
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
	private Long communityId;

	@NonNull
	private String memberId;
	
	@NonNull
	private String content;
	
	@CreatedDate
<<<<<<< HEAD
	private LocalDateTime createdAt;
	
	@LastModifiedDate
	private LocalDateTime updatedAt;

	private boolean isDeleted;
	
=======
	private LocalDateTime writeDate;
	
	private boolean isState;
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
}
