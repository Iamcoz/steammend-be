package steammend.model;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import steammend.model.entity.Communities;

@Repository
public interface CommunitiesDAO extends JpaRepository<Communities, Long>{

	Page<Communities> findByIsDeletedFalse(Pageable pageable);
	
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Communities c SET c.hit = c.hit+1 WHERE c.id = :id ")
	int updateHitByCommunityId(Long id);
	
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Communities c SET c.header = :header, c.title = :title, c.content = :content, c.updatedAt = :updatedAt WHERE c.id = :id AND c.memberId = :memberId")
	int updateCommunityByCommunityId(Long id, String header, String title, String content, LocalDateTime updatedAt, String memberId);

	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE Communities c SET c.is_deleted = 1, c.updated_at = :updatedAt WHERE c.id = :id", nativeQuery = true)
	int deleteCommunityByCommunityId(Long id, LocalDateTime updatedAt);
 
	@Query("SELECT c FROM Communities c WHERE c.isDeleted = 0 AND (c.title LIKE CONCAT('%',:keyword,'%') OR c.content LIKE CONCAT('%',:keyword,'%'))")
	Page<Communities> findByKeywordContaining(String keyword, Pageable pageable);
	
	@Query("SELECT MAX(c.id) FROM Communities c")
	Long findIdByMaxId();
}
