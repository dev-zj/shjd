package entity;

import java.io.Serializable;

/**
 * @author Administrator
 *用户审核信息
 */
public class EquipAuditInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8229296921837206078L;
	
	private int userId;
	
	private String status;
	
	private String checkDate;
	
	private int checkUserId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	public int getCheckUserId() {
		return checkUserId;
	}

	public void setCheckUserId(int checkUserId) {
		this.checkUserId = checkUserId;
	}
	
	
	
	
}
