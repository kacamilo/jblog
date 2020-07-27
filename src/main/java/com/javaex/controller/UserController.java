package com.javaex.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	// 회원가입 폼
	@RequestMapping("/joinForm")
	public String joinForm() {
		System.out.println("userController/joinForm");

		return "user/joinForm";
	}

	// 회원가입
	@RequestMapping("/join")
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("userController/join");
		// 서비스를 통해 회원정보 저장
		userService.join(userVo);
		return "user/joinSuccess";
	}

	// 로그인 폼
	@RequestMapping("/loginForm")
	public String loginForm() {
		System.out.println("userController/loginForm");

		return "user/loginForm";
	}

	// 로그인
	@RequestMapping("/login")
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {

		UserVo authUser = userService.login(userVo);

		if (authUser != null) { // 로그인 성공
			session.setAttribute("session", authUser);
			return "redirect:/";
		} else { // 로그인 실패
			return "redirect:/user/loginForm?result=fail";
		}
	}

	// 로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("session");
		session.invalidate();
		return "redirect:/";
	}
	
	//아이디 체크(ajax용)
	@ResponseBody
	@RequestMapping("/idcheck")
	public boolean idcheck(@RequestParam("userId")String id) {
		System.out.println("userController/idcheck(ajax)");
		System.out.println(id);
		
		boolean result = userService.checkId(id);
		
		return result;
	}
	

}
