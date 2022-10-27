package steammend.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import steammend.model.entity.Replies;

@Repository
public interface RepliesDAO extends JpaRepository<Replies, Long>{

	@Modifying(clearAutomatically = true)
	@Query("UPDATE Replies r SET r.content = :content WHERE r.replyId = :replyId AND r.memberId = :memberId")
	int updateReplyContentByReplyId(Long replyId, String content, String memberId);

	@Modifying(clearAutomatically = true)
	@Query("UPDATE Replies r SET r.isState = 0 WHERE r.replyId = :replyId")
	int deleteReplyByReplyId(Long replyId);

}