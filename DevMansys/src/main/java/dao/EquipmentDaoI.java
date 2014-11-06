package dao;

import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import entity.Announcement;
import entity.EquipBookInfo;
import entity.EquipFileDownload;
import entity.EquipPlatformInfo;
import entity.EquipUserInfo;
import entity.EquipmentBasicInfo;
import entity.EquipmentCategory;
import entity.UserLoginInfo;

@Service
@ComponentScan
@EnableAutoConfiguration
public interface EquipmentDaoI {
	/**
	 * 查询平台公告信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Announcement> queryAnnouncement() throws Exception;

	/**
	 * 查询平台介绍信息
	 * 
	 * @return
	 */
	public EquipPlatformInfo queryPlatformInfo();

	public List<EquipmentCategory> queryEquipmentCategory();

	public List<EquipmentBasicInfo> queryEquipmentBasicInfo(
			EquipmentBasicInfo info);

	public int queryEquipmentBasicCount(EquipmentBasicInfo info);

	public int login(UserLoginInfo login);

	public EquipUserInfo queryUserInfo(int id);

	public List<EquipmentBasicInfo> queryEquipmentBasicInfoLoginU(
			EquipmentBasicInfo info);

	public List<EquipmentBasicInfo> queryEquipmentBasicInfoLoginS(
			EquipmentBasicInfo info);

	public int queryEquipmentBasicCountLoginU(EquipmentBasicInfo info);

	public int queryEquipmentBasicCountLoginS(EquipmentBasicInfo info);

	public EquipmentBasicInfo queryEquipmentBasicInfo(int id);
	public EquipmentBasicInfo queryEquipmentBasicInfoForAdmin(int id);

	public int queryEquipBookInfoCount(EquipBookInfo info);

	public List<EquipBookInfo> queryEquipBookInfoList(EquipBookInfo info);

	public int queryMyEquipBookInfoCount(EquipBookInfo info);

	public List<EquipBookInfo> queryMyEquipBookInfoList(EquipBookInfo info);

	public int queryMyEquipAuditInfoCount(EquipBookInfo info);

	public List<EquipBookInfo> queryMyEquipAuditInfoList(EquipBookInfo info);

	public int queryEquipUserInfoCount(EquipUserInfo info);
	public int queryEquipUserInfoPermissionCount(EquipUserInfo info);

	public List<EquipUserInfo> queryEquipUserInfoList(EquipUserInfo info);
	public List<EquipUserInfo> queryEquipUserInfoPermissionList(EquipUserInfo info);

	
	/**
	 * 更新用户的角色
	 * @param userInfo
	 * @return
	 */
	public int updateUserInfoPer(EquipUserInfo userInfo)throws Exception;
	
	
	/**
	 * 更新产品类别信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int updateCategoryInfo(Map map)throws Exception;
	
	
	/**
	 * 审核注册用户:审核和注册
	 * 
	 * @param info
	 * @return
	 */
	public int checkUserAuditInfo(EquipUserInfo info);

	/**
	 * 根据用户id 查询用户信息，管理员观察用户信息，进行审核
	 * 
	 * @param id
	 * @return
	 */
	public EquipUserInfo queryEquipUserInfoById(int id);

	/**
	 * 根据时间判断是否有重叠
	 * 
	 * @param info
	 * @return
	 */
	public int countBookOrderByTime(EquipBookInfo info);

	public void generateOrder(EquipBookInfo info);

	public void cancleOrder(int orderId);

	public int registerUserInfo(EquipUserInfo info);

	public void registerLoginInfo(EquipUserInfo info);

	public void registerUserAudit(int id);

	/**
	 * 显示文件下载
	 * 
	 * @return
	 */
	public List<EquipFileDownload> queryFileDownLoad();
	
	/**
	 * 更新仪器信息
	 * @param equipment
	 * @return
	 * @throws Exception 
	 */
	public int modifyEquipBasicInfo(EquipmentBasicInfo equipment) throws Exception;
	
	
	/**
	 * 新增仪器信息
	 * @param equipment
	 * @return
	 * @throws Exception 
	 */
	public int addEquipBasicInfo(EquipmentBasicInfo equipment) throws Exception;
	
	/**
	 * 根据订单号查询订单待审批的订单信息
	 * @param orderId
	 * @return
	 */
	public EquipBookInfo queryAuditDetailOrder(Integer orderId);
	
	/**
	 * 审核预约信息
	 * @param bookInfo
	 */
	public void  auditBookOrder(EquipBookInfo bookInfo);
	
}
