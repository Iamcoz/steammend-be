package steammend.model;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import steammend.model.entity.Replies;

@Repository
public interface RepliesDAO extends JpaRepository<Replies, Long>{

	@Modifying(clearAutomatically = true)
	@Query("UPDATE Replies r SET r.content = :content, r.updatedAt = :updatedAt WHERE r.id = :id AND r.memberId = :memberId")
	int updateReplyContentByReplyId(Long id, String content, LocalDateTime updatedAt, String memberId);

	@Modifying(clearAutomatically = true)
	@Query("UPDATE Replies r SET r.isDeleted = 1, r.updatedAt = :updatedAt WHERE r.id = :id")
	int deleteReplyByReplyId(Long id, LocalDateTime updatedAt);

}
