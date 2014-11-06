package entity;

import java.io.Serializable;

public class UserLoginInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7547020148761096261L;

	private String userName;
	
	private String password;
	
	private String status;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
