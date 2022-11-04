package steammend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import steammend.model.entity.Communities;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CommunitiesDTO {
	
	private Long id;
	private String memberId;
	private String header;
	private String title;
	private String content;
	private int hit;
	private String createdAt;
	private String updatedAt;
	private boolean isDeleted;
	
	
	public CommunitiesDTO(String memberId, String header, String title, String content) {
		this.memberId = memberId;
		this.header = header;
		this.title = title;
		this.content = content;
	}
	
	public Communities toEntity() {
		return 	Communities.builder().
				memberId(memberId).
				header(header).
				title(title).
				content(content).
				build();
	}

}

