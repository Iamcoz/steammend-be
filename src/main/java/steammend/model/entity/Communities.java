package steammend.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
<<<<<<< HEAD
import org.springframework.data.annotation.LastModifiedDate;
=======
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
public class Communities {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
=======
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Communities {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long communityId;
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
	
	@NonNull
	private String memberId;
	
	@NonNull
	private String header;
	
	@NonNull
	private String title;
	
	@NonNull
	private String content;
	
<<<<<<< HEAD
	private int hit;
	
	@CreatedDate
	private LocalDateTime createdAt;
	
	@LastModifiedDate
	private LocalDateTime updatedAt;

	private boolean isDeleted;
=======
	@CreatedDate
	private LocalDateTime writeDate;
	
	private int hit;
	
	private boolean isState;
	
//	private List<Attachments> attachments = new 
	
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
	
}