package service;

import java.util.List;

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

/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
@Service
@ComponentScan
@EnableAutoConfiguration
public interface EquipmentServiceI {
	public List<Announcement> queryAnnouncement() throws Exception;
	
	public EquipPlatformInfo queryPlatformInfo();
	
	public List<EquipmentCategory> queryEquipmentCategory();
	public List<EquipmentBasicInfo> queryEquipmentBasicInfo(EquipmentBasicInfo info) ;
	
	public EquipUserInfo login(UserLoginInfo info);
	
	/**
	 * 普通用户查询仪器信息
	 * @param info
	 * @return
	 */
	public List<EquipmentBasicInfo> queryEquipmentBasicInfoLoginU(EquipmentBasicInfo info); 
	/**
	 * 管理员查询仪器信息
	 * @param info
	 * @return
	 */
	public List<EquipmentBasicInfo> queryEquipmentBasicInfoLoginS(EquipmentBasicInfo info); 

	public EquipmentBasicInfo queryEquipmentBasicInfo(int id) ;
	public EquipmentBasicInfo queryEquipmentBasicInfoForAdmin(int id) ;
	
	public List<EquipBookInfo> queryEquipBookInfoList(EquipBookInfo info);
	public List<EquipBookInfo> queryMyEquipBookInfoList(EquipBookInfo info);
	public List<EquipBookInfo> queryMyEquipAuditInfoList(EquipBookInfo info);
	/**
	 * 超级管理员查询注册用户
	 * @param info
	 * @return
	 */
	public List<EquipUserInfo> queryEquipUserInfoList(EquipUserInfo info);
	/**
	 * 用户权限管理
	 * @param info
	 * @return
	 */
	public List<EquipUserInfo> queryEquipUserInfoPermissionList(EquipUserInfo info);
	
	/**
	 * 更新用户权限
	 * @param userInfo
	 */
	public void processUserPermission(EquipUserInfo userInfo);
	
	/**
	 * 审核用户注册信息,包括审核、注册
	 * @param info
	 * @return
	 */
	public int checkUserRegisterInfo(EquipUserInfo info);
	
	/**
	 * 根据Id查询出用户相信信息，便于审核
	 * @param id
	 * @return
	 */
	public EquipUserInfo queryEquipUserInfoById(int id);
	
	/**
	 * 生成预约订单
	 * @param info
	 * @return
	 */
	public boolean generateOrder(EquipBookInfo info);
	
	public void cancleOrder(int orderId);
	
	public int register(EquipUserInfo info);
	
	/**
	 * 查询下载文件
	 * @return
	 */
	public List<EquipFileDownload> queryFileDownload();
	
	public void modifyEquipBasicInfo(EquipmentBasicInfo equipment);
	public void addEquipBasicInfo(EquipmentBasicInfo equipment);
	
	/**
	 * 根据订单号查询待审核的预约信息
	 * @param orderId
	 * @return
	 */
	public EquipBookInfo queryAuditDetailOrder(int orderId);
	
	/**
	 * 审核预约信息
	 * @param bookInfo
	 */
	public void auditBookOrder(EquipBookInfo bookInfo);
}
