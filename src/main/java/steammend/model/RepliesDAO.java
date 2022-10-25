package steammend.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import steammend.model.entity.Replies;

@Repository
public interface RepliesDAO extends JpaRepository<Replies, Long>{

}
