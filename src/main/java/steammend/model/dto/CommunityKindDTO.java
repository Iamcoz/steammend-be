package steammend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import steammend.model.entity.CommunityKind;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CommunityKindDTO {
	private int commuKindNo;
	private String commuKindName;
	
	public CommunityKind toEntity() {
		return 	CommunityKind.builder().
				commuKindName(commuKindName).
				build();
	}
}
