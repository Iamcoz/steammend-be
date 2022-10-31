package steammend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import steammend.model.dto.MembersDTO;
import steammend.model.dto.SessionDTO;
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
     */
    @RequestMapping(value="/userjoin.do")
    public String insert() {
		return "userjoin";
	}
	
	/*
	 * @parameter : id, pw
	 * 
	 * @logic : login 가능한지 판단
	 * 
	 * @return : 존재하는 회원 있는 경우 해당 회원 sessionDTO 객체(dto)
	 * 				없는 경우 null
	 */
	@RequestMapping(value="/userlogin.do")
	@ResponseBody
	public SessionDTO userLogin(HttpServletRequest request) {
    	
		HttpSession session = request.getSession();
		
		String id = request.getParameter("bm_id");
		String pw = request.getParameter("bm_pw");
		
		if(MemberServiceImpl.checkLogin(id, pw) != null) {
			MembersDTO res = MemberService.login(MemberServiceImpl.checkLogin(id, pw));
			SessionDTO dto = new SessionDTO(res.getId(), res.getSteamId());
			session.setAttribute(dto.getMemberId(), dto.getSteamId());
//			System.out.println("출력 ============="+session.getAttribute(dto.getId()));
			return dto;
		}
		else {
			return null;
		}
    }
	
	/*
	 * 	@logic : logout, session 초기화
	 * 	
	 * 	@return : logout 확인 page
	 */
    @RequestMapping(value="/userlogout.do")
    @ResponseBody
    public String userLogout(HttpSession session) {
    	
    	session.invalidate();
  
    	return "logout success";
    }
    
    /*
     * 	@parameter : id, pw
     * 	
     * 	@logic : id 중복 확인
     * 
     * 	@return : sql insert 성공하면 sessionDTO 객체(dto), 실패 null
     */
    @RequestMapping(value="/join.do")
    @ResponseBody
	public SessionDTO userJoin(HttpServletRequest request) {
		
    	HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String nickName = request.getParameter("nickname");
		String birth = request.getParameter("birth");
		String steamId = request.getParameter("steam_id");
		MembersDTO res = new MembersDTO(id, pw, name, nickName, birth, steamId);
		
		try {
			MemberService.insert(res);
			SessionDTO dto = new SessionDTO(res.getId(), res.getSteamId());
			session.setAttribute(dto.getMemberId(), dto.getSteamId());
			return dto;
		}catch(Exception e){
			return null;
		}
    }
}
