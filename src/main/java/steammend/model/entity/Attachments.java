package steammend.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

}

