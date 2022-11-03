package steammend.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
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

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Attachments {// extends Base {
	
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

}

