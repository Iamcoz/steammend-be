package steammend.model;

<<<<<<< HEAD
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
=======
import org.springframework.data.jpa.repository.JpaRepository;
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
import org.springframework.stereotype.Repository;

import steammend.model.entity.Replies;

@Repository
public interface RepliesDAO extends JpaRepository<Replies, Long>{

<<<<<<< HEAD
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Replies r SET r.content = :content, r.updatedAt = :updatedAt WHERE r.id = :id AND r.memberId = :memberId")
	int updateReplyContentByReplyId(Long id, String content, LocalDateTime updatedAt, String memberId);

	@Modifying(clearAutomatically = true)
	@Query("UPDATE Replies r SET r.isDeleted = 1, r.updatedAt = :updatedAt WHERE r.id = :id")
	int deleteReplyByReplyId(Long id, LocalDateTime updatedAt);

	@Query("SELECT r FROM Replies r WHERE r.communityId = :communityId")
	List<Replies> getAllReplyByCommunityId(Long communityId);

=======
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
}
