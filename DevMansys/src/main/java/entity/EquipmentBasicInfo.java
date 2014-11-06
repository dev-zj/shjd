package entity;

import java.io.Serializable;

import common.EncodingTool;

/**
 * @author Administrator
 *仪器基本信息
 *
 */
public class EquipmentBasicInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4139900629070998896L;

	/**
	 * 主键
	 */
	private int id;
	/**
	 * 类别
	 */
	private int cateId;
	/**
	 * 设备名称
	 */
	private String equipName;
	/**
	 * 设备型号
	 */
	private String equipModel;
	/**
	 * 生产厂家
	 */
	private String equipMerchant;
	/**
	 * 设备规格
	 */
	private String equipStandard;
	/**
	 * 设备价格
	 */
	private String equipValue;
	/**
	 * 使用年限 
	 */
	private String equipAge;
	/**
	 * 使用介绍
	 */
	private String equipIntroduce;
	/**
	 * 规格说明
	 */
	private String equipStandardIntroduce;
	/**
	 * 操作流程
	 */
	private String equipOprProcess;
	/**
	 * 所属管理员
	 */
	private int equipOwnerId;
	/**
	 * 是否可以预约（是否可以预约yes;no）
	 */
	private String canBook;
	/**
	 * 预约属性（仪器所属预约属性(un-sch校外/sch-dep校内本院/sch-undep校内非本院)）
	 */
	private String equipBookProperty;
	/**
	 * 仪器图片地址
	 */
	private String equipPic;

	private String userName;
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCateId() {
		return cateId;
	}
	public void setCateId(int cateId) {
		this.cateId = cateId;
	}
	public String getEquipName() {
		return equipName;
	}
	public void setEquipName(String equipName) {
		this.equipName =equipName ;
	}
	public String getEquipModel() {
		return equipModel;
	}
	public void setEquipModel(String equipModel) {
		this.equipModel = equipModel;
	}
	public String getEquipMerchant() {
		return equipMerchant;
	}
	public void setEquipMerchant(String equipMerchant) {
		this.equipMerchant = equipMerchant;
	}
	public String getEquipStandard() {
		return equipStandard;
	}
	public void setEquipStandard(String equipStandard) {
		this.equipStandard = equipStandard;
	}
	public String getEquipValue() {
		return equipValue;
	}
	public void setEquipValue(String equipValue) {
		this.equipValue = equipValue;
	}
	public String getEquipAge() {
		return equipAge;
	}
	public void setEquipAge(String equipAge) {
		this.equipAge = equipAge;
	}
	public String getEquipIntroduce() {
		return equipIntroduce;
	}
	public void setEquipIntroduce(String equipIntroduce) {
		this.equipIntroduce = equipIntroduce;
	}
	public String getEquipStandardIntroduce() {
		return equipStandardIntroduce;
	}
	public void setEquipStandardIntroduce(String equipStandardIntroduce) {
		this.equipStandardIntroduce = equipStandardIntroduce;
	}
	public String getEquipOprProcess() {
		return equipOprProcess;
	}
	public void setEquipOprProcess(String equipOprProcess) {
		this.equipOprProcess = equipOprProcess;
	}
	public int getEquipOwnerId() {
		return equipOwnerId;
	}
	public void setEquipOwnerId(int equipOwnerId) {
		this.equipOwnerId = equipOwnerId;
	}
	public String getCanBook() {
		return canBook;
	}
	public void setCanBook(String canBook) {
		this.canBook = canBook;
	}
	public String getEquipBookProperty() {
		return equipBookProperty;
	}
	public void setEquipBookProperty(String equipBookProperty) {
		this.equipBookProperty = equipBookProperty;
	}
	public String getEquipPic() {
		return equipPic;
	}
	public void setEquipPic(String equipPic) {
		this.equipPic = equipPic;
	}
	@Override
	public String toString() {
		return "EquipmentBasiInfo [id=" + id + ", cateId=" + cateId
				+ ", equipName=" + equipName + ", equipModel=" + equipModel
				+ ", equipMerchant=" + equipMerchant + ", equipStandard="
				+ equipStandard + ", equipValue=" + equipValue + ", equipAge="
				+ equipAge + ", equipIntroduce=" + equipIntroduce
				+ ", equipStandardIntroduce=" + equipStandardIntroduce
				+ ", equipOprProcess=" + equipOprProcess + ", equipOwnerId="
				+ equipOwnerId + ", canBook=" + canBook
				+ ", equipBookProperty=" + equipBookProperty + ", equipPic="
				+ equipPic + "]";
	}
	
	
	
}
