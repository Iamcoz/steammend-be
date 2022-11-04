package steammend.model.entity;

<<<<<<< HEAD
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
=======
import javax.persistence.Entity;
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

<<<<<<< HEAD
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

=======
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
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
<<<<<<< HEAD
@EntityListeners(AuditingEntityListener.class)
public class Attachments {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	private Long communityId;
	
	@NonNull
	private String originalName;
	
	@NonNull
	private String uploadName;
	
	@NonNull
	private String uploadPath;
	
	@CreatedDate
	private LocalDateTime createdAt;
	
	@LastModifiedDate
	private LocalDateTime updatedAt;

	private boolean isDeleted;
=======
public class Attachments {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long attachmentId;
	
	private Long communityId;
	
	@NonNull
	private String originName;
	
	@NonNull
	private String serverName;
	
	@NonNull
	private String path;
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8

}

