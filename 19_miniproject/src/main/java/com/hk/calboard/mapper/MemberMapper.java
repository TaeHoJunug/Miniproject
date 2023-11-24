package com.hk.calboard.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hk.calboard.dtos.MemberDto;
import com.hk.calboard.dtos.UserDto;

@Mapper
public interface MemberMapper {
	
	public boolean addUser(MemberDto dto);
	
	public String idChk(String id);
	
	public MemberDto loginUser(String id);
	
	public MemberDto getUser(MemberDto dto);

	
}






