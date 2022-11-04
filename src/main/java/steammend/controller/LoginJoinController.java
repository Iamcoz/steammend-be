package steammend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import steammend.model.dto.MembersDTO;
import steammend.service.MemberService;
import steammend.service.MemberServiceImpl;

@RequiredArgsConstructor
@Controller
public class LoginJoinController {
	
	private final MemberService MemberService;
	private final MemberServiceImpl MemberServiceImpl;
    
    /*
     * 	@parameter : 회원 가입하고자 하는 id
     * 
     * 	@return : login 가능 유무
     */
    @RequestMapping(value="/idcheck.do")
    @ResponseBody
    public String idCheck(HttpServletRequest request) {
    	
    	String id = request.getParameter("check_id");
    	MembersDTO res = MemberService.findById(id);
    	
    	if(res != null) {
    		return "가입 불가";
    	}
    	else {
    		return "가입 가능";
    	}
	}
    
    
	/*
	 * @parameter : id, pw
	 * 
	 * @logic : login 가능한지 판단
	 * 
	 * @return : 회원인 경우 회원  string 배열(member id, nickname), 아닌 경우 null
	 */
	@RequestMapping(value="/userlogin.do")
	@ResponseBody
	public String[] userLogin(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
	
		if(MemberServiceImpl.checkLogin(id, pw) != null) {
			MembersDTO res = MemberService.login(MemberServiceImpl.checkLogin(id, pw));
			
			HttpSession session = request.getSession();
			session.setAttribute(res.getId(), res.getSteamId());
			String[] ist = {res.getId(), res.getNickname()};
			return ist;
		}
		else {
			return null;
		}
    }
	
	/*
	 * 	@parameter : member id	
	 * 
	 * 	@logic : 해당 id logout(해당 key의 value 초기화), session 자체 삭제 X
	 * 	
	 * 	@return : 실행하면 true
	 */
    @RequestMapping(value="/userlogout.do")
    @ResponseBody
    public String userLogout(@RequestParam("id") String id, HttpSession session) {
    	
    	session.removeAttribute(id);
    	return "logout";
    	
    }
    
    /*
     * 	@parameter : id, pw
     * 	
     * 	@logic : id 중복 확인
     * 
     * 	@return : sql insert 성공하면회원 string 배열(member id, nickname), 실패하면 fail
     */
    @RequestMapping(value="/join.do")
    @ResponseBody
	public String[] userJoin(HttpServletRequest request) {
    	
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String nickName = request.getParameter("nickname");
		String birthday = request.getParameter("birthday");
		String steamId = request.getParameter("steam_id");
		MembersDTO res = new MembersDTO(id, pw, name, nickName, birthday, steamId);
		
		try {
			MemberService.insert(res);
			HttpSession session = request.getSession();
			session.setAttribute(res.getId(), res.getSteamId());
			String[] ist = {res.getId(), res.getNickname()};
			return ist;
		}catch(Exception e){
			return null;
		}
    }
}