package steammend.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import steammend.model.entity.Members;

@Repository
public interface MembersDAO extends JpaRepository<Members, String>{

}
