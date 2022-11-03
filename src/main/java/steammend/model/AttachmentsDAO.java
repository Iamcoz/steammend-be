package steammend.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import steammend.model.entity.Attachments;

@Repository
public interface AttachmentsDAO extends JpaRepository<Attachments, Long>{

	List<Attachments> findByCommunityId(Long communityId);

}
