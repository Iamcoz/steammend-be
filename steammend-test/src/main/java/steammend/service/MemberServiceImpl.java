package steammend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import steammend.model.MemberMapper;
import steammend.model.dto.MembersDTO;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberMapper MemberMapper;

	@Override
	public MembersDTO login(MembersDTO dto) {
		
		System.out.println("serviceIMPL에서의 dto : " +MemberMapper.login(dto));
		
		return MemberMapper.login(dto);
	}
	
	@Override
	public MembersDTO insert(MembersDTO dto) {
		return MemberMapper.insert(dto);
	}
}
