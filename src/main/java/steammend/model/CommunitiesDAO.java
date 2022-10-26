package steammend.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import steammend.model.entity.Communities;

@Repository
public interface CommunitiesDAO extends JpaRepository<Communities, Long>{

//	@Modifying
//	@Query("UPDATE Communities c SET c.header =: header, c.title =: title, c.content =: content WHERE c.communityId =: communityId ")
//	int updateCommunityByCommunityId(long communityId, String header, String title, String content);

	
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Communities c SET c.hit = c.hit+1 WHERE c.communityId = :communityId")
	int updateHitByCommunityId(long communityId);
	
//	@Query("SELECT * FROM Communities. c")
//	Page<Communities> allCommunityWithPaging(Pageable pageable);
}
