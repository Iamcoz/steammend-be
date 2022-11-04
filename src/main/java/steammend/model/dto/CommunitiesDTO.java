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
	
<<<<<<< HEAD
	private Long id;
=======
	private Long communityId;
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
	private String memberId;
	private String header;
	private String title;
	private String content;
<<<<<<< HEAD
	private int hit;
	private String createdAt;
	private String updatedAt;
	private boolean isDeleted;
	
	
	public CommunitiesDTO(String memberId, String header, String title, String content) {
=======
	private String writeDate;
	private int hit;
	private boolean isState;
	private Long attachmentId;
	
	
	public CommunitiesDTO(String memberId, String header, String title, String content, boolean isState) {
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
		this.memberId = memberId;
		this.header = header;
		this.title = title;
		this.content = content;
<<<<<<< HEAD
=======
//		this.writeDate = writeDate;
//		this.hit = hit;
		this.isState = isState;
	}
	
	public CommunitiesDTO(String memberId, String header, String title, String content, boolean isState, Long attachmentId) {//, int hit, boolean isState) {
		this.memberId = memberId;
		this.header = header;
		this.title = title;
		this.content = content;
		this.isState = isState;
		this.attachmentId = attachmentId;
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
	}
	
	public Communities toEntity() {
		return 	Communities.builder().
<<<<<<< HEAD
=======
//				communityId(communityId).
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
				memberId(memberId).
				header(header).
				title(title).
				content(content).
<<<<<<< HEAD
=======
//				writeDate(writeDate).
//				hit(hit).
				isState(isState).
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
				build();
	}

}
<<<<<<< HEAD

=======
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
