package entity;

import java.io.Serializable;

public class EquipFileDownload implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -489610995865042939L;
	
	private int id;
	
	private String path;
	
	private String name;
	
	private String cdate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	
	
}
