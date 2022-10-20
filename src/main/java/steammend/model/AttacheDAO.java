package steammend.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import steammend.model.entity.Attache;

@Repository
public interface AttacheDAO extends JpaRepository<Attache, Integer>{

}
