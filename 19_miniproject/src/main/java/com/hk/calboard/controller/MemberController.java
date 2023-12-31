package com.hk.calboard.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.hk.calboard.command.AddUserCommand;
import com.hk.calboard.command.DeleteUserCommand;
import com.hk.calboard.command.LoginCommand;
import com.hk.calboard.command.UpdatePasswordCommand;
import com.hk.calboard.command.UpdateUserCommand;
import com.hk.calboard.dtos.MemberDto;
import com.hk.calboard.dtos.UserDto;
import com.hk.calboard.mapper.MemberMapper;
import com.hk.calboard.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/")
public class MemberController {
	Logger logger=LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MemberService memberService;
	private HttpServletRequest request;
	
	@GetMapping(value = "/addUser")
	public String addUserForm(Model model) {
		System.out.println("회원가입폼 이동");
		
		//회원가입폼에서 addUserCommand객체를 사용하는 코드가 작성되어 있어서 
		//null일경우 오류가 발생하기때문에 보내줘야 함
		model.addAttribute("addUserCommand", new AddUserCommand());
		
		return "member/addUserForm";
	}
	
	@PostMapping(value = "/addUser")
	public String addUser(@Validated AddUserCommand addUserCommand
			             ,BindingResult result,Model model) {
		System.out.println("회원가입하기");
		
		if(result.hasErrors()) {
			System.out.println("회원가입 유효값 오류");
			return "member/addUserForm";
		}
		
		try {
			memberService.addUser(addUserCommand);
			System.out.println("회원가입 성공");
			return "redirect:/";
		} catch (Exception e) {
			System.out.println("회원가입실패");
			e.printStackTrace();
			return "redirect:addUser";
		}

	}
	
	@ResponseBody
	   @GetMapping(value = "/idChk")
	   public Map<String, String> idChk(String id){
	      System.out.println("ID중복체크");
	      
	      String resultId = memberService.idChk(id);
	      
	      // json 객체로 보내기 위해 Map에 담아서 응답
	      // text라면 그냥 String 으로 보내도 됨
	      Map<String, String> map = new HashMap<>();
	      map.put("id", resultId);
	      
	      return map;
	   }
	
	//로그인 폼 이동
	@GetMapping(value = "/")
	public String loginForm(Model model) {
		model.addAttribute("loginCommand", new LoginCommand());
		System.out.println("로그인폼 이동");
		return "member/login";
	}
	
	//로그인 실행
	@PostMapping(value = "/")
	public String login(@Validated LoginCommand loginCommand
			           ,BindingResult result
			           ,Model model
			           ,HttpServletRequest request) {
		if(result.hasErrors()) {
			System.out.println("로그인 유효값 오류");
			return "member/login";
		}
		String path=memberService.login(loginCommand, request, model);
		
		return path;
	}
	
	@GetMapping(value="/logout")
	public String logout(HttpServletRequest request) {
		System.out.println("로그아웃");
		request.getSession().invalidate();
		return "redirect:/";
	}
	
	//나의 정보 조회
	@GetMapping(value="/mypage")
	public String mypage() {
		System.out.println("마이페이지 접속");
		return "member/userInfo";
	}
	//나의 정보 수정
	@GetMapping(value="/updateUser")
	public String updateUser(Model model,HttpServletRequest request) {
		HttpSession session=(HttpSession) request.getSession();
		MemberDto mdto=(MemberDto)session.getAttribute("mdto");
		MemberDto dto=memberService.getUser(mdto);
		model.addAttribute("dto",dto);
		System.out.println("회원수정 접속");
		return "member/updateUser";
	}
		
		//회원 탈퇴페이지 접속
		@GetMapping("/deleteUser")
		public String deleteUser(){

			return "member/deleteUser"; //secession.jsp가 return되게

		}
<<<<<<< HEAD
	//비밀번호 변경
		@PostMapping(value = "/pwChk")
		public String pwChk(@Validated UpdatePasswordCommand updatePasswordCommand
				             ,BindingResult result,Model model) {
			System.out.println("비밀번호변경하기");
			
			if(result.hasErrors()) {
				System.out.println("회원가입 유효값 오류");
				return "member/updateUser";
			}
			
			try {
				memberService.pwChk(updatePasswordCommand);
				System.out.println("수정완료");
				return "redirect:/";
			} catch (Exception e) {
				System.out.println("회원가입실패");
				e.printStackTrace();
				return "redirect:pwChk";
			}

		}
		//로그인 폼 이동
		@GetMapping(value = "/delUser")
		public String delUserForm(Model model) {
			model.addAttribute("deleteUserCommand", new DeleteUserCommand());
			System.out.println("로그인폼 이동");
			return "member/delUserForm";
		}
		
	//회원탈퇴
		@PostMapping(value = "/delUser")
		public String delUser(@Validated DeleteUserCommand deleteUserCommand
				           ,BindingResult result
				           ,Model model
				           ,HttpServletRequest request) {
			if(result.hasErrors()) {
				System.out.println("로그인 유효값 오류");
				return "member/delUserForm";
			}
			HttpSession session=(HttpSession) request.getSession();
			MemberDto mdto=(MemberDto)session.getAttribute("mdto");
			MemberDto dto=memberService.getUser(mdto);
			boolean path=memberService.delUser(mdto.getId(), request, model);
			if(path) {
				request.getSession().invalidate();
			}
			model.addAttribute("loginCommand", new LoginCommand());
			return "member/login";
		}
=======
		//회원탈퇴 진행

>>>>>>> branch 'main' of https://github.com/TaeHoJunug/Miniproject.git
}









