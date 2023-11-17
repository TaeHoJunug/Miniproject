package com.hk.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hk.board.dtos.FileBoardDto;

@Mapper
public interface FileMapper {

	//파일정보추가
	public boolean insertFileBoard(FileBoardDto dto);
	//파일정보조회
	public FileBoardDto getFileInfo(int file_seq);
}
