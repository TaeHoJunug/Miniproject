package com.hk.calboard.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

//일정추가 페이지에서 입력내용 : ID, 일정날짜, 제목, 내용
//			<select>2023 11 07 06 10 </select> 선탣해서 입력
					// DB: seq, id, title, content, mdate, regdate
//@Data
public class InsertCalCommand {

	
	public int seq;
	
	@NotBlank(message="아이디를 입력하세여")// 문자열만가능
	private String id;
	@NotBlank(message="가격을 입력하세여")// 문자열만가능
	private String title;
	@NotBlank(message="내용을 입력하세여")// 문자열만가능
	private String content;
	@NotBlank(message = "지불방식")
	private String money;
	
	//mdate
	@NotNull(message="년도를 입력하세여")
	private int year;
	@NotNull(message="월을 입력하세여")
	private int month;
	@NotNull(message="일을 입력하세여")
	private int date;
	@NotNull(message="시간을 입력하세여")
	private int hour;
	@NotNull(message="분을 입력하세여")
	private int min;
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	
	
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public InsertCalCommand() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "InsertCalCommand [seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + content + ", money="
				+ money + ", year=" + year + ", month=" + month + ", date=" + date + ", hour=" + hour + ", min=" + min
				+ "]";
	}
	public InsertCalCommand(int seq, @NotBlank(message = "아이디를 입력하세여") String id,
			@NotBlank(message = "가격을 입력하세여") String title, @NotBlank(message = "내용을 입력하세여") String content,
			@NotBlank(message = "지불방식") String money, @NotNull(message = "년도를 입력하세여") int year,
			@NotNull(message = "월을 입력하세여") int month, @NotNull(message = "일을 입력하세여") int date,
			@NotNull(message = "시간을 입력하세여") int hour, @NotNull(message = "분을 입력하세여") int min) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.money = money;
		this.year = year;
		this.month = month;
		this.date = date;
		this.hour = hour;
		this.min = min;
	}
	
	
	
	
	
}
