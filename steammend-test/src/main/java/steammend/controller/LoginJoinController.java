package steammend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import steammend.model.dto.MembersDTO;
import steammend.service.MemberService;

@RequiredArgsConstructor
@Controller
public class LoginJoinController {
	
	private final MemberService MemberService;
	
	
	/*
	 * 초기화면에서 로그인 선택
	 */
	  
	@RequestMapping("/login.do")
	public String login() {
		return "login";
	}
	
	/*
     * 초기화면에서 회원가입 선택
     * 
     */
    @RequestMapping(value="/userjoin.do")
    public String insert() {
		return "userjoin";
	}
	
	/*
	 * @logic : login 가능한지 판단
	 * 
	 * @parameter : id, pw
	 * 
	 * @return : 존재하는 회원인 경우 succ
	 * 				아닌 경우 fail 
	 *
	 *		succ : 성공 화면
	 *		fail : 실패 화면
	 */
	@RequestMapping(value="/userlogin.do")
	public String userLogin(HttpServletRequest request) {
    	
		HttpSession session = request.getSession();
		System.out.println("세션 아이디 : "+session.getId());
		
		
		String id = request.getParameter("bm_id");
		String pw = request.getParameter("bm_pw");
		MembersDTO dto = new MembersDTO(id,pw);
		System.out.println("dto : "+ dto.getId()+"     "+dto.getPassword());
		
		
		MembersDTO res = MemberService.login(dto);
		System.out.println("res : " + res);
		System.out.println("=======================================");
		
		if(res != null) {
			session.setAttribute("res", res);
			return "succ";
		}
		else {
			return "fail";
		}
    }
    
	
	/*
	 * 	@logic : logout, session 초기화
	 * 	
	 * 	@return : logout 확인 page
	 * 				session 초기화되어 님 앞에 id 안뜸
	 */
    @RequestMapping(value="/userlogout.do")
    public String userLogout(HttpSession session) {
    	
    	session.invalidate();
  
    	return "logout";
    }
    
    
    
    /*
     * 	@parameter : id, pw
     * 	
     * 	@logic : id 중복 확인
     * 
     * 	@return : sql insert 성공하면 succ
     * 				실패하면 fail
     * 
     * 
     */
    @RequestMapping(value="/join.do")
	public String userJoin(HttpServletRequest request) {
		
    	HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String nickName = request.getParameter("nickname");
		String birth = request.getParameter("birth");
		String steamId = request.getParameter("steam_id");
		boolean isState = true;
		MembersDTO dto = new MembersDTO(id, pw, name, nickName, birth, steamId, isState);
		System.out.println("dto : "+ dto);
		
		try {
			MemberService.insert(dto);
			session.setAttribute("res", dto);
			System.out.println("가입 성공");
			return "succ";
		}catch(Exception e){
			System.out.println("가입 실패");
			return "fail";
		}
		
    }
}
