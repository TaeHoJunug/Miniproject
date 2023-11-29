package com.hk.calboard.command;

public class DeleteUserCommand {

	private String id;
	private String password;
	public DeleteUserCommand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeleteUserCommand(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "DeleteUserCommand [id=" + id + ", password=" + password + "]";
	}
	
	
}
