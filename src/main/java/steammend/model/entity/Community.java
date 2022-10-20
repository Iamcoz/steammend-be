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
public class Community {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commuNo;
	
	@NonNull
	private String memId;
	
	private int commuKindNo;
	
	@NonNull
	private String commuHeader;
	
	@NonNull
	private String commuTitle;
	
	@NonNull
	private String commuContent;
	
	private int commuHit;
	
	private char commuState;
}
