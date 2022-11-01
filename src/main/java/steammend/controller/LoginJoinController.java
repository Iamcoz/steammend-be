package steammend.controller;

import java.util.ArrayList;
import java.util.List;

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
	 * @return : 존재하는 회원 있는 경우 list(회원 id, session id)
	 * 						없는 경우 null
	 */
	@RequestMapping(value="/userlogin.do")
	@ResponseBody
	public List userLogin(HttpServletRequest request) {
		
		String id = request.getParameter("bm_id");
		String pw = request.getParameter("bm_pw");
		
		if(MemberServiceImpl.checkLogin(id, pw) != null) {
			MembersDTO res = MemberService.login(MemberServiceImpl.checkLogin(id, pw));
			
			HttpSession session = request.getSession();
			session.setAttribute(res.getId(), res.getSteamId());
			System.out.println(session.getId());
			List<String> list = new ArrayList<>();
			list.add(res.getId());
			list.add(session.getId());
			System.out.println(list.toString());
			return list;
		}
		else {
			return null;
		}
    }
	
	/*
	 * 	@parameter : member id	
	 * 
	 * 	@logic : 해당 id logout(세션 삭제)
	 * 	
	 * 	@return : 실행하면 true
	 */
    @RequestMapping(value="/userlogout.do")
    @ResponseBody
    public boolean userLogout(@RequestParam("id") String id, HttpSession session) {
    	
    	session.removeAttribute(id);
    	
    	return true;
    }
    
    /*
     * 	@parameter : id, pw
     * 	
     * 	@logic : id 중복 확인
     * 
     * 	@return : sql insert 성공하면 list(회원 id, session id)  
     * 							실패 null 
     */
    @RequestMapping(value="/join.do")
    @ResponseBody
	public List userJoin(HttpServletRequest request) {
    	
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String nickName = request.getParameter("nickname");
		String birth = request.getParameter("birth");
		String steamId = request.getParameter("steam_id");
		MembersDTO res = new MembersDTO(id, pw, name, nickName, birth, steamId);
		
		try {
			MemberService.insert(res);
			HttpSession session = request.getSession();
			session.setAttribute(res.getId(), res.getSteamId());
			List<String> list = new ArrayList<>();
			list.add(res.getId());
			list.add(session.getId());
			System.out.println(list.toString());
			return list;
		}catch(Exception e){
			return null;
		}
    }
    
    
}
