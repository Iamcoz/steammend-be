package steammend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import steammend.model.dto.MembersDTO;
import steammend.service.MemberService;
import steammend.service.MemberServiceImpl;

@RequiredArgsConstructor
@Controller
public class LoginJoinController {
	
	private final MemberService MemberService;
	private final MemberServiceImpl MemberServiceImpl;
	
	
	
	@GetMapping("/")
	public String index() {
		return "redirect:/login.html";
	}
	
	
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
		
		String id = request.getParameter("bm_id");
		String pw = request.getParameter("bm_pw");
		MembersDTO dto = new MembersDTO(id,pw);
		
		
		
		if(MemberServiceImpl.checkLogin(id, pw) != null) {
			MembersDTO res = MemberService.login(MemberServiceImpl.checkLogin(id, pw));
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
		boolean isDeleted = false;
		MembersDTO dto = new MembersDTO(id, pw, name, nickName, birth, steamId);
		
		try {
			MemberService.insert(dto);
			session.setAttribute("res", dto);
			return "succ";
		}catch(Exception e){
			return "fail";
		}
    }
}
