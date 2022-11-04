package steammend.service;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import steammend.exception.MessageException;
import steammend.model.AttachmentsDAO;
import steammend.model.dto.AttachmentsDTO;
import steammend.model.entity.Attachments;

@Service
public class AttachmentsService {

	@Autowired
	private AttachmentsDAO atchDAO;

	private ModelMapper mapper = new ModelMapper();

	/** 하나의 첨부파일 등록
	 * 
	 * @param atchDTO
	 * @return
	 * @throws Exception
	 */
	public Long addAttachment(AttachmentsDTO atchDTO) throws Exception {
		Attachments atchEntity = mapper.map(atchDTO, Attachments.class);

		try {
			atchEntity = atchDAO.save(atchEntity);

			if (atchEntity != null) {
				return atchDTO.getId();
			}
		} catch (Exception e) {
			throw new MessageException("첨부파일 등록 실패");
		}
		return atchDTO.getId(); // null;
	}

	/** 동일한 communityId를 가진 모든 첨부파일 조회
	 * 
	 * @param communityId
	 * @return
	 * @throws Exception
	 */
	public List<AttachmentsDTO> getAllAttachment(Long communityId) throws Exception {
		List<Attachments> atchAllEntity = atchDAO.findByCommunityId(communityId);

		if (atchAllEntity == null) {
			throw new MessageException("존재하는 첨부파일이 없습니다");
		}

		List<AttachmentsDTO> atchAllDTO = Arrays.asList(mapper.map(atchAllEntity, AttachmentsDTO[].class));

		return atchAllDTO;
	}
}
