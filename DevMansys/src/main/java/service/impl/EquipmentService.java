package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import service.EquipmentServiceI;
import dao.EquipmentDaoI;
import entity.Announcement;
import entity.EquipBookInfo;
import entity.EquipFileDownload;
import entity.EquipPlatformInfo;
import entity.EquipUserInfo;
import entity.EquipmentBasicInfo;
import entity.EquipmentCategory;
import entity.UserLoginInfo;
@Service
@ComponentScan("dao")
@EnableAutoConfiguration
public class EquipmentService implements EquipmentServiceI {
	@Autowired
	public EquipmentDaoI equipmentDao;
	@Override
	public List<Announcement> queryAnnouncement() throws Exception {
		// TODO Auto-generated method stub
		return equipmentDao.queryAnnouncement();
	}
	@Override
	public EquipPlatformInfo queryPlatformInfo() {
		// TODO Auto-generated method stub
		return (EquipPlatformInfo)equipmentDao.queryPlatformInfo();
	}
	@Override
	public List<EquipmentCategory> queryEquipmentCategory() {
		// TODO Auto-generated method stub
		return equipmentDao.queryEquipmentCategory();
	}
	
	public List<EquipmentBasicInfo> queryEquipmentBasicInfo(EquipmentBasicInfo info) {
		int count = equipmentDao.queryEquipmentBasicCount(info);
		info.setSum(count);
		return equipmentDao.queryEquipmentBasicInfo(info);
	}
	
	/* (non-Javadoc)
	 * 查询预约信息列表
	 * @see service.EquipmentServiceI#queryEquipBookInfoList(entity.EquipBookInfo)
	 */
	public List<EquipBookInfo> queryEquipBookInfoList(EquipBookInfo info){
		int count = equipmentDao.queryEquipBookInfoCount(info);
		info.setSum(count);
		return equipmentDao.queryEquipBookInfoList(info);
	}
	
	/* (non-Javadoc)
	 * @see service.EquipmentServiceI#queryEquipmentBasicInfoLoginU(entity.EquipmentBasicInfo)
	 */
	public List<EquipmentBasicInfo> queryEquipmentBasicInfoLoginU(EquipmentBasicInfo info) {
		int count = equipmentDao.queryEquipmentBasicCountLoginU(info);
		info.setSum(count);
		return equipmentDao.queryEquipmentBasicInfoLoginU(info);
	}
	
	
	/* (non-Javadoc)
	 * @see service.EquipmentServiceI#queryEquipmentBasicInfoLoginS(entity.EquipmentBasicInfo)
	 */
	public List<EquipmentBasicInfo> queryEquipmentBasicInfoLoginS(EquipmentBasicInfo info) {
		int count = equipmentDao.queryEquipmentBasicCountLoginS(info);
		info.setSum(count);
		return equipmentDao.queryEquipmentBasicInfoLoginS(info);
	}
	
	/* (non-Javadoc)
	 * @see service.EquipmentServiceI#queryEquipUserInfoList(entity.EquipUserInfo)
	 */
	public List<EquipUserInfo> queryEquipUserInfoList(EquipUserInfo info){
		int count = equipmentDao.queryEquipUserInfoCount(info);
		info.setSum(count);
		return equipmentDao.queryEquipUserInfoList(info);
	}
	
	/* (non-Javadoc)
	 * @see service.EquipmentServiceI#queryEquipUserInfoList(entity.EquipUserInfo)
	 */
	public List<EquipUserInfo> queryEquipUserInfoPermissionList(EquipUserInfo info){
		int count = equipmentDao.queryEquipUserInfoPermissionCount(info);
		info.setSum(count);
		return equipmentDao.queryEquipUserInfoPermissionList(info);
	}
	
	@Override
	public EquipUserInfo login(UserLoginInfo info) {
		// TODO Auto-generated method stub
		//初始化用户信息
		EquipUserInfo userLogin = new EquipUserInfo();
		int userId = equipmentDao.login(info);
		userLogin.setId(userId);
		//在登录表中查询到用户信息
		if(userId !=0){
			//判断是否是超级管理员，如果是超级管理员，不用进行其他操作，直接登陆
			if("super_admin".equals(info.getUserName())){
				userLogin.setId(userId);
				userLogin.setUserName(info.getUserName());
				userLogin.setAdminProperty("super");//超级管理员
			}else{
				//普通管理员或者普通用户，需要判断是否已经审批完毕，同时需要获取其用户属性
				//在dao查询的时候已经查询了审批表，关联了状态是done的用户
				EquipUserInfo up = equipmentDao.queryUserInfo(userId);
				//查询到了审批结束的用户
				if(up != null){
					userLogin.setId(userId);
					userLogin.setUserName(info.getUserName());
					userLogin.setAdminProperty(up.getAdminProperty());//super、normal、user、tleader
					userLogin.setName(up.getName());
					userLogin.setThisSchool(up.getThisSchool());
					userLogin.setSex(up.getSex());
					userLogin.setAddress(up.getAddress());
					userLogin.setIsAdministrator(up.getIsAdministrator());
					userLogin.setIsTleader(up.getIsTleader());
					userLogin.setTeamId(up.getTeamId());
					userLogin.setGroup(up.getGroup());
					userLogin.setSeries(up.getSeries());
					userLogin.setTeamName(up.getTeamName());
					userLogin.setTelNo(up.getTelNo());
					userLogin.setEmail(up.getEmail());
				}else{//用户关联审批表没有审批通过记录
					userLogin.setId(0);
				}
			}
		}
		return userLogin;
	}
	@Override
	public EquipmentBasicInfo queryEquipmentBasicInfo(int id) {
		// TODO Auto-generated method stub
		return equipmentDao.queryEquipmentBasicInfo(id);
	}
	@Override
	public EquipmentBasicInfo queryEquipmentBasicInfoForAdmin(int id) {
		// TODO Auto-generated method stub
		return equipmentDao.queryEquipmentBasicInfoForAdmin(id);
	}
	@Override
	public boolean generateOrder(EquipBookInfo info) {
		// TODO Auto-generated method stub
		//判断开始时间和结束时间是否有重叠
		int unAval = equipmentDao.countBookOrderByTime(info);
		if(unAval>0){
			return false;
		}
		equipmentDao.generateOrder(info);
		return true;
	}
	@Override
	public List<EquipBookInfo> queryMyEquipBookInfoList(EquipBookInfo info) {
		// TODO Auto-generated method stub
		int count = equipmentDao.queryMyEquipBookInfoCount(info);
		info.setSum(count);
		return equipmentDao.queryMyEquipBookInfoList(info);
	}
	@Override
	public List<EquipBookInfo> queryMyEquipAuditInfoList(EquipBookInfo info) {
		// TODO Auto-generated method stub
		int count = equipmentDao.queryMyEquipAuditInfoCount(info);
		info.setSum(count);
		return equipmentDao.queryMyEquipAuditInfoList(info);
	}
	@Override
	public void cancleOrder(int orderId) {
		// TODO Auto-generated method stub
		equipmentDao.cancleOrder(orderId);
	}
	@Override
	public int register(EquipUserInfo info) {
		// TODO Auto-generated method stub
		int userId = equipmentDao.registerUserInfo(info);
		equipmentDao.registerLoginInfo(info);
		equipmentDao.registerUserAudit(userId);
		return 0;
	}
	@Override
	public int checkUserRegisterInfo(EquipUserInfo info) {
		// TODO Auto-generated method stub
		equipmentDao.checkUserAuditInfo(info);
		return 0;
	}
	@Override
	public EquipUserInfo queryEquipUserInfoById(int id) {
		// TODO Auto-generated method stub
		return equipmentDao.queryEquipUserInfoById(id);
	}
	@Override
	public List<EquipFileDownload> queryFileDownload() {
		// TODO Auto-generated method stub
		return equipmentDao.queryFileDownLoad();
	}
	@Override
	public void modifyEquipBasicInfo(EquipmentBasicInfo equipment) {
		// TODO Auto-generated method stub
		try {
			equipmentDao.modifyEquipBasicInfo(equipment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void addEquipBasicInfo(EquipmentBasicInfo equipment) {
		// TODO Auto-generated method stub
		try {
			equipmentDao.addEquipBasicInfo(equipment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public EquipBookInfo queryAuditDetailOrder(int orderId) {
		// TODO Auto-generated method stub
		return equipmentDao.queryAuditDetailOrder(orderId);
	}
	@Override
	public void auditBookOrder(EquipBookInfo bookInfo) {
		// TODO Auto-generated method stub
		equipmentDao.auditBookOrder(bookInfo);
	}
	@Override
	public void processUserPermission(EquipUserInfo userInfo) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			//更新用户的角色
			result = equipmentDao.updateUserInfoPer(userInfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result = 0;
			e.printStackTrace();
		}
		//更新产品类别信息,更新owner_id
		int[] equipOwns = userInfo.getEquipOwns();
		Map map = new HashMap();
		map.put("ownerId", userInfo.getId());
		if(equipOwns != null && equipOwns.length>0){
			for(int i : equipOwns){
				map.put("cateId", i);
				try {
					equipmentDao.updateCategoryInfo(map);
					map.put("cateId", 0);
					result = 1;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					result = 0;
					e.printStackTrace();
				}
			}
			
		}
	}

}
