package steammend.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import steammend.model.entity.Communities;

@Repository
public interface CommunitiesDAO extends JpaRepository<Communities, Long>{

	@Modifying
	@Query("UPDATE Communities c SET c.header=:header, c.title=:title, c.content=:content WHERE c.communityId=:communityId")
	int updateCommunityByCommunityId(long communityId, String header, String title, String content);
}
