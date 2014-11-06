package entity;

import java.io.Serializable;

/**
 * @author Administrator
 *用户基本信息
 */
public class EquipUserInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2202907228208960516L;
	
	/**
	 * 主键  
	 */
	private int id;
	
	private String name;
	
	/**
	 * 性别 female女性 male男性 
	 */
	private String sex;
	
	/**
	 * 是否本校 yes是；no不是
	 */
	private String thisSchool;
	
	private String group;
	
	private String series;
	
	private String cardNo;
	
	private String telNo;
	
	private String address;
	
	private String email;
	
	/**
	 *long长期用户；book预约用户 
	 */
	private String userProperty;
	
	/**
	 * 是否课题组长yes是；no不是
	 */
	private String isTleader;
	
	private int teamId;
	
	private String teamName;
	
	/**
	 * 是否是管理员 yes是；no不是
	 */
	private String isAdministrator;
	
	/**
	 * 管理员属性 super超级管理员;normal普通管理员 
	 */
	private String adminProperty;

	/**
	 * 登陆名
	 */
	private String userName;
	
	/**
	 * 用户审核信息
	 */
	private EquipAuditInfo auditInfo;
	
	/**
	 * 审核状态todo/doing/done
	 */
	private String auditStatus;
	
	/**
	 * 待审核状态
	 */
	private String toCheckStatus;
	
	/**
	 * 登录密码
	 */
	private String password;
	
	/**
	 * 审核者
	 */
	private int checkUser;
	
	/**
	 * 注册日期
	 */
	private String registerDate;
	
	/**
	 * 拥有的仪器管理权限
	 */
	private int[] equipOwns;
	
	
	/**
	 * 审核日期
	 */
	private String auditDate;
	
	/**
	 * 显示数量
	 */
	private int pageSize=5;
	
	/**
	 * 当前页
	 */
	private int currentPage = 1;
	
	/**
	 * 起始条数
	 */
	private int begin = 0;
	
	/**
	 * 总记录数
	 */
	private int sum;
	
	/**
	 * 总页数
	 */
	private int pageNum = 1;
	
	public int getPageNum() {
		if(sum == pageSize){
			return pageNum = 1;
		}else{
			return pageNum = (sum/pageSize)==0?1:((sum/pageSize)+1);
		}
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getBegin() {
		begin = currentPage>1?pageSize*(currentPage-1):0;
		return begin;
	}
	public void setBegin(int begin) {
//		return begin = 
		this.begin = begin;
	}

	public int[] getEquipOwns() {
		return equipOwns;
	}
	public void setEquipOwns(int[] equipOwns) {
		this.equipOwns = equipOwns;
	}
	public String getToCheckStatus() {
		return toCheckStatus;
	}
	public void setToCheckStatus(String toCheckStatus) {
		this.toCheckStatus = toCheckStatus;
	}
	public int getCheckUser() {
		return checkUser;
	}
	public void setCheckUser(int checkUser) {
		this.checkUser = checkUser;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public EquipAuditInfo getAuditInfo() {
		return auditInfo;
	}

	public void setAuditInfo(EquipAuditInfo auditInfo) {
		this.auditInfo = auditInfo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getAuditDate() {
		return auditDate;
	}
	public void setAuditDate(String auditDate) {
		this.auditDate = auditDate;
	}
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getThisSchool() {
		return thisSchool;
	}

	public void setThisSchool(String thisSchool) {
		this.thisSchool = thisSchool;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserProperty() {
		return userProperty;
	}

	public void setUserProperty(String userProperty) {
		this.userProperty = userProperty;
	}

	public String getIsTleader() {
		return isTleader;
	}

	public void setIsTleader(String isTleader) {
		this.isTleader = isTleader;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getIsAdministrator() {
		return isAdministrator;
	}

	public void setIsAdministrator(String isAdministrator) {
		this.isAdministrator = isAdministrator;
	}

	public String getAdminProperty() {
		return adminProperty;
	}

	public void setAdminProperty(String adminProperty) {
		this.adminProperty = adminProperty;
	}

	
	public String getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}
	@Override
	public String toString() {
		return "EquipUserInfo [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", thisSchool=" + thisSchool + ", group=" + group
				+ ", series=" + series + ", cardNo=" + cardNo + ", telNo="
				+ telNo + ", address=" + address + ", email=" + email
				+ ", userProperty=" + userProperty + ", isTleader=" + isTleader
				+ ", teamId=" + teamId + ", isAdministrator=" + isAdministrator
				+ ", adminProperty=" + adminProperty + "]";
	}

	
}
