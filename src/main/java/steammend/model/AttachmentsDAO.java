package steammend.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import steammend.model.entity.Attachments;

@Repository
public interface AttachmentsDAO extends JpaRepository<Attachments, Long>{

	@Query("SELECT a FROM Attachments a WHERE a.communityId = :communityId AND a.isDeleted = 0")
	List<Attachments> findByCommunityId(Long communityId);

}
