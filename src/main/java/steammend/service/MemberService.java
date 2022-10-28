package steammend.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import steammend.model.MembersDAO;

@Service
public class MemberService {

	@Autowired
	private MembersDAO memberDAO;
	
	private ModelMapper mapper = new ModelMapper();
}
