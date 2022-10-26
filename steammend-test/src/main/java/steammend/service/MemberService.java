package steammend.service;

import steammend.model.dto.MembersDTO;

public interface MemberService {
	public MembersDTO login(MembersDTO dto);
	
	public MembersDTO insert(MembersDTO dto);
	
	public MembersDTO findById(String id);
	
}
