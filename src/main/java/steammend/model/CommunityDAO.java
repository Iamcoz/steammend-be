package steammend.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import steammend.model.entity.Community;

@Repository
public interface CommunityDAO extends JpaRepository<Community, Integer>{

}
