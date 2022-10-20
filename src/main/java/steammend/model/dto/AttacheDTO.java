package steammend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import steammend.model.entity.Attache;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class AttacheDTO {
	private int atchNo;
	private int commuNo;
	private String atchOriginName;
	private String atchServerName;
	private String atchPath;
	
	public Attache toEntity() {
		return 	Attache.builder().
				commuNo(commuNo).
				atchOriginName(atchOriginName).
				atchServerName(atchServerName).
				atchPath(atchPath).
				build();
	}
}
