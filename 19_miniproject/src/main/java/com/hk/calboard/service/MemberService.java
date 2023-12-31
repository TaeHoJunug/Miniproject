package com.hk.calboard.service;

import java.io.PrintWriter;
import java.util.Map;

import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.data.convert.DtoInstantiatingConverter;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.data.domain.Window;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.hk.calboard.command.AddUserCommand;
import com.hk.calboard.command.DeleteUserCommand;
import com.hk.calboard.command.LoginCommand;
import com.hk.calboard.command.UpdatePasswordCommand;
import com.hk.calboard.command.UpdateUserCommand;
import com.hk.calboard.dtos.MemberDto;
import com.hk.calboard.dtos.UserDto;
import com.hk.calboard.mapper.MemberMapper;
import com.hk.board.status.RoleStatus;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor ;lombok 기능: final 필드를 초기화 - Autowired 생략가능
@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	public boolean addUser(AddUserCommand addUserCommand) {
		
		MemberDto mdto=new MemberDto();
		mdto.setId(addUserCommand.getId());
		mdto.setName(addUserCommand.getName());
		
		//password암호화하여 저장하자
		mdto.setPassword(addUserCommand.getPassword());
//		mdto.setPassword(addUserCommand.equals(mdto.getPassword()));
		
		
		mdto.setEmail(addUserCommand.getEmail());
		mdto.setAddress(addUserCommand.getAddress());
		mdto.setRole(RoleStatus.USER+"");//등급추가
		return memberMapper.addUser(mdto);
	}
	
	public String idChk(String id) {
		return memberMapper.idChk(id);
	}
	
	public String login(LoginCommand loginCommand
			           ,HttpServletRequest request
			           ,Model model) {
		MemberDto dto = memberMapper.loginUser(loginCommand.getId());
		String path="redirect:/schedule/calendar";
		if(dto!=null) {
			//로그인 폼에서 입력받은 패스워드값과 DB에 암호화된 패스워드 비교22
//			if(passwordEncoder.matches(loginCommand.getPassword()
//					                  , dto.getPassword())) {
			if(loginCommand.getPassword().equals(dto.getPassword())) {
				
				System.out.println("패스워드 같음: 회원이 맞음");
				//session객체에 로그인 정보 저장
				request.getSession().setAttribute("mdto", dto);
				return path;
				
			}else {
				System.out.println("패스워드 틀림");
				model.addAttribute("msg", "패스워드를 확인하세요");
				path="member/login";
			}
		}else {
			System.out.println("회원이 아닙니다. ");
			model.addAttribute("msg", "아이디를 확인하세요");
			path="member/login";
		}
		
		return path;
	}
	
	public MemberDto getUser(MemberDto dto) {
		
		return memberMapper.getUser(dto);
	}	
	
<<<<<<< HEAD
	public boolean pwChk(UpdatePasswordCommand updatePasswordCommand) {
		
		MemberDto mdto=new MemberDto();
		mdto.setId(updatePasswordCommand.getId());
		mdto.setPassword(updatePasswordCommand.getPassword());
		return memberMapper.pwChk(mdto);	
	}

	public boolean delUser(DeleteUserCommand deleteUserCommand, HttpServletRequest request, Model model) {
		return memberMapper.delUser(deleteUserCommand.getId());
	}

	public boolean delUser(String id, HttpServletRequest request, Model model) {
		return memberMapper.delUser(id);
	}
=======
	//wdasddadsadadadasdasds회원탈

	
>>>>>>> branch 'main' of https://github.com/TaeHoJunug/Miniproject.git
}













