package steammend.model;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import steammend.model.entity.Attachments;

@Repository
public interface AttachmentsDAO extends JpaRepository<Attachments, Long>{

<<<<<<< HEAD
	List<Attachments> findByCommunityId(Long communityId);

=======
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
}
