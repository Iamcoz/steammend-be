package steammend.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import steammend.model.entity.CommunityKind;

@Repository
public interface CommunityKindDAO extends JpaRepository<CommunityKind, Integer>{

}
