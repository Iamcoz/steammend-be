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
public class Communities {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long communityId;
	
	@NonNull
	private String memberId;
	
	@NonNull
	private String header;
	
	@NonNull
	private String title;
	
	@NonNull
	private String content;
	
	@NonNull
	private String writeDate;
	
	private int hit;
	
	private boolean isState;
}