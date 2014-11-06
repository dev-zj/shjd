package entity;

import java.io.Serializable;

public class EquipmentCategory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4606906192207397136L;

	private int id;
	
	private String cateCode;
	
	private String cateName;
	
	private String createdBy;
	
	private String createdDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCateCode() {
		return cateCode;
	}

	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "EquipmentCategory [id=" + id + ", cateCode=" + cateCode
				+ ", cateName=" + cateName + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + "]";
	}
	
	
}
