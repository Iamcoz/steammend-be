package steammend.model;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import steammend.model.dto.MembersDTO;


@Repository
@Mapper
public interface MemberMapper {
	
	public MembersDTO login(MembersDTO dto);
	
	public MembersDTO insert(MembersDTO dto);
	
	public MembersDTO findById(String id);
	

}
