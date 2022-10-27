package steammend.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
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

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Communities {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long communityId;
	
	@NonNull
	private String memberId;
	
	@NonNull
	private String header;
	
	@NonNull
	private String title;
	
	@NonNull
	private String content;
	
	@CreatedDate
	private LocalDateTime writeDate;
	
	private int hit;
	
	private boolean isState;
	
//	private List<Attachments> attachments = new 
	
	
}