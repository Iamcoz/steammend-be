package steammend.service;

<<<<<<< HEAD
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import steammend.model.MembersDAO;

@Service
public class MemberService {

	@Autowired
	private MembersDAO memberDAO;
	
	private ModelMapper mapper = new ModelMapper();
=======
import steammend.model.dto.MembersDTO;

public interface MemberService {
	public MembersDTO login(MembersDTO dto);
	
	public MembersDTO insert(MembersDTO dto);
	
	public MembersDTO findById(String id);
	
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
}
