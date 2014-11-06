package entity;

import java.io.Serializable;

public class EquipPlatformInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8488433633050918521L;

	private int id;
	
	private String platformInfo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlatformInfo() {
		return platformInfo;
	}

	public void setPlatformInfo(String platformInfo) {
		this.platformInfo = platformInfo;
	}

	@Override
	public String toString() {
		return "EquipPlatformInfo [id=" + id + ", platformInfo=" + platformInfo
				+ "]";
	}
	
	
}
