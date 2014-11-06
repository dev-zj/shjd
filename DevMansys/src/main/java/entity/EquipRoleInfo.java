package entity;

import java.io.Serializable;

public class EquipRoleInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5190614443297484229L;
	
	private int roleId;
	
	/**
	 * 角色属性
	 */
	private String roleProperty;
	
	/**
	 * 角色描述
	 */
	private String roleDesc;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleProperty() {
		return roleProperty;
	}

	public void setRoleProperty(String roleProperty) {
		this.roleProperty = roleProperty;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	@Override
	public String toString() {
		return "EquipRoleInfo [roleId=" + roleId + ", roleProperty="
				+ roleProperty + ", roleDesc=" + roleDesc + "]";
	}
	
	
	

}
