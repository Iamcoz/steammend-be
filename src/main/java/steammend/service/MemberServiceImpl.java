package steammend.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import steammend.model.MemberMapper;
import steammend.model.dto.MembersDTO;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
    PasswordEncoder passwordEncoder;
	

	@Override
	public MembersDTO login(MembersDTO dto) {
		
		return memberMapper.login(dto);
	}
	
	@Override
	public MembersDTO insert(MembersDTO dto) {
		
		dto = encryptPassword(dto);
		return memberMapper.insert(dto);
	}
	
	@Override
	public MembersDTO findById(String id) {
		
		return memberMapper.findById(id);
	}
	
	
	@Transactional
    public MembersDTO encryptPassword(MembersDTO join){
		String enPw = passwordEncoder.encode(join.getPassword());
		join.setPassword(enPw);
        return join; 
    }
	
	
	/*
	 * 	@logic  row 비밀번호, 암호화 비밀번호 비교
	 * 	
	 */
	public MembersDTO checkLogin(String id, String rawPw){
		MembersDTO dto = memberMapper.findById(id);
		if(dto == null) {
			return null;
		}
	    if(passwordEncoder.matches(rawPw, dto.getPassword())){
	    	return dto;
	    } else{
	    	return null;
	    }
	}

	
}