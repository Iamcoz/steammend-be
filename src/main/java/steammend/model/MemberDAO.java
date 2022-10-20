package steammend.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import steammend.model.entity.Member;

@Repository
public interface MemberDAO extends JpaRepository<Member, String>{

}
