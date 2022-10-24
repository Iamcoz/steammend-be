package steammend.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import steammend.model.entity.Community;

@Repository
public interface CommunityDAO extends JpaRepository<Community, Integer>{

	@Modifying(clearAutomatically = true)
	@Query(	"UPDATE Community c SET c.commu_header:=commuHeader commuTitle    where c.commu_no=:commuNo")
	int updateCommunity(int commuNo, String commuHeader, String commuTitle, String commuContent);

}
