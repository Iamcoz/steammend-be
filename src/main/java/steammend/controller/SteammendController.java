package steammend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import steammend.service.MemberService;

@RestController
public class SteammendController {
	
	@Autowired
	private MemberService memberService;
}
