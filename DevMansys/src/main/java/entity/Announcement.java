package entity;

import java.io.Serializable;


/**
 * @author Administrator
 *平台公告实体
 */
public class Announcement implements Serializable{
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 926281320149110759L;
	
	/**
	 *主键 
	 */
	private int  id;
	
	/**
	 * 公告标题
	 */
	private String announce_title;
	
	/**
	 * 公告内容
	 */
	private String announce_content;
	
	/**
	 * 创建者
	 */
	private String created_by;
	
	/**
	 * 创建日期
	 */
	private String created_date;
	
	/**
	 * 状态
	 */
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnnounce_title() {
		return announce_title;
	}

	public void setAnnounce_title(String announce_title) {
		this.announce_title = announce_title;
	}

	public String getAnnounce_content() {
		return announce_content;
	}

	public void setAnnounce_content(String announce_content) {
		this.announce_content = announce_content;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Announcement [id=" + id + ", announce_title=" + announce_title
				+ ", announce_content=" + announce_content + ", created_by="
				+ created_by + ", created_date=" + created_date + ", status="
				+ status + "]";
	}
	
	
}
