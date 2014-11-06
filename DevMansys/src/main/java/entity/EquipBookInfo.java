package entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Administrator
 *预定信息
 */
public class EquipBookInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3648341870826523416L;
	
	private int id;
	
	private int equipId;
	
	private String equipName;
	
	private String beginTime;
	
	private String endTime;
	
	private float useTime;
	
	private BigDecimal unitPrice;
	
	private BigDecimal usePrice;
	
	private int userId;
	
	private String userName;
	
	private String orderTime;
	
	private String orderStatus;
	
	private int auditUser;
	
	private String auditTime;

	/**
	 * 计划预约开始时间
	 */
	private String planBeginTime;
	
	/**
	 * 计划预约结束时间
	 */
	private String planEndTime;
	
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
	 * 备注
	 */
	private String orderRemark;
	
	
	
	

	public String getOrderRemark() {
		return orderRemark;
	}
	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}

	/**
	 * 总页数
	 */
	private int pageNum = 1;
	
	public int getPageNum() {
		if(sum == pageSize){
			return pageNum = 1;
		}else{
			return pageNum = (sum/pageSize)==0?1:((sum%pageSize)==0?(sum/pageSize):((sum/pageSize)+1));
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
	
	
	
	public String getPlanBeginTime() {
		return planBeginTime;
	}
	public void setPlanBeginTime(String planBeginTime) {
		this.planBeginTime = planBeginTime;
	}
	public String getPlanEndTime() {
		return planEndTime;
	}
	public void setPlanEndTime(String planEndTime) {
		this.planEndTime = planEndTime;
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

	public int getEquipId() {
		return equipId;
	}

	public void setEquipId(int equipId) {
		this.equipId = equipId;
	}

	public String getEquipName() {
		return equipName;
	}

	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public float getUseTime() {
		return useTime;
	}

	public void setUseTime(float useTime) {
		this.useTime = useTime;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getUsePrice() {
		return usePrice;
	}

	public void setUsePrice(BigDecimal usePrice) {
		this.usePrice = usePrice;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getAuditUser() {
		return auditUser;
	}

	public void setAuditUser(int auditUser) {
		this.auditUser = auditUser;
	}

	public String getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(String auditTime) {
		this.auditTime = auditTime;
	}
	
	
	
}
