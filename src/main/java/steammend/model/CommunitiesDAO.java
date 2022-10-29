package steammend.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import steammend.model.entity.Communities;

@Repository
public interface CommunitiesDAO extends JpaRepository<Communities, Long>{

	@Modifying(clearAutomatically = true)
	@Query("UPDATE Communities c SET c.hit = c.hit+1 WHERE c.id = :id ")
	int updateHitByCommunityId(Long id);
	
//	@Modifying(clearAutomatically = true)
//	@Query("UPDATE Communities c SET c.header = :header, c.title = :title, c.content = :content WHERE c.communityId = :communityId AND c.memberId = :memberId")
//	int updateCommunityByCommunityId(Long communityId, String header, String title, String content, String memberId);
//
//	@Modifying(clearAutomatically = true)
//	@Query("UPDATE Communities c SET c.isState = 0 WHERE c.communityId = :communityId")
//	int deleteCommunityByCommunityId(Long communityId);
}
