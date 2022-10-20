package steammend.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import steammend.model.entity.Reply;

@Repository
public interface ReplyDAO extends JpaRepository<Reply, Integer>{

}
