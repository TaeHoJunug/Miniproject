package com.hk.calboard.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.hk.calboard.command.DeleteUserCommand;
import com.hk.calboard.command.UpdatePasswordCommand;
import com.hk.calboard.command.UpdateUserCommand;
import com.hk.calboard.dtos.MemberDto;
import com.hk.calboard.dtos.UserDto;

@Mapper
public interface MemberMapper {
	
	public boolean addUser(MemberDto dto);
	
	public String idChk(String id);
	
	public MemberDto loginUser(String id);
	
	public MemberDto getUser(MemberDto dto);
<<<<<<< HEAD

	public boolean pwChk(MemberDto mdto);

	public boolean delUser(String id);

=======
>>>>>>> branch 'main' of https://github.com/TaeHoJunug/Miniproject.git
	
	public String deletUser(MemberDto dto);//회원탈퇴
}






