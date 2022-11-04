package steammend.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import steammend.exception.MessageException;
import steammend.model.AttachmentsDAO;
import steammend.model.CommunitiesDAO;
import steammend.model.dto.AttachmentsDTO;
import steammend.model.entity.Attachments;

@Service
public class AttachmentsService {

	@Autowired
	private AttachmentsDAO atchDAO;
	
	@Autowired
	private CommunitiesDAO commuDAO;

	private ModelMapper mapper = new ModelMapper();

	/** 하나의 첨부파일 등록
	 * 
	 * @param atchDTO
	 * @return
	 * @throws Exception
	 */
	public boolean addAttachment(AttachmentsDTO atchDTO) throws Exception {
		atchDTO.setCommunityId(commuDAO.findIdByMaxId());
		Attachments atchEntity = mapper.map(atchDTO, Attachments.class);

		try {
			atchEntity = atchDAO.save(atchEntity);

			if (atchEntity != null) {
				return true;
			}
		} catch (Exception e) {
			throw new MessageException("첨부파일 등록 실패");
		}
		return false;
	}

	/** 하나의 첨부파일 조회
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public AttachmentsDTO getAttachment(Long id) throws Exception {
		Optional<Attachments> atchEntity = atchDAO.findById(id);

		if (atchEntity.get() == null) {
			throw new MessageException("존재하지 않는 첨부파일입니다.");
		}

		AttachmentsDTO atchDTO = mapper.map(atchEntity.get(), AttachmentsDTO.class);

		return atchDTO;
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
