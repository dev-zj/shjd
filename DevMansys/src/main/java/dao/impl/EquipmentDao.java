package dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Service;

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
@ComponentScan
@EnableAutoConfiguration
public class EquipmentDao extends SqlMapClientDaoSupport implements EquipmentDaoI {

	@SuppressWarnings("unchecked")
	@Override
	public List<Announcement> queryAnnouncement() throws Exception {
		// TODO Auto-generated method stub
		List<Announcement> result = null;
		 result = getSqlMapClientTemplate().queryForList("selectEquipAnnouncement");
		 return result;
		
	}

	@Override
	public EquipPlatformInfo queryPlatformInfo() {
		// TODO Auto-generated method stub
		EquipPlatformInfo platformInfo = (EquipPlatformInfo) getSqlMapClientTemplate().queryForObject("selectEquipPlatformInfo");
		return platformInfo;
	}

	@Override
	public List<EquipmentCategory> queryEquipmentCategory() {
		// TODO Auto-generated method stub
		List<EquipmentCategory> equipmentCategoryList = (List<EquipmentCategory>) getSqlMapClientTemplate().queryForList("selectEquipmentCategory");
		return equipmentCategoryList;
	}

	@Override
	public List<EquipmentBasicInfo> queryEquipmentBasicInfo(EquipmentBasicInfo info) {
		// TODO Auto-generated method stub
		List<EquipmentBasicInfo> result = getSqlMapClientTemplate().queryForList("selectEquipBasicInfo", info);
		return result;
	}

	@Override
	public int queryEquipmentBasicCount(EquipmentBasicInfo info) {
		// TODO Auto-generated method stub
		return (int) getSqlMapClientTemplate().queryForObject("selectEquipmentCount", info);
	}

	@Override
	public int login(UserLoginInfo login) {
		// TODO Auto-generated method stub
		Integer userId = (Integer) getSqlMapClientTemplate().queryForObject("selectUserIdFromLogin", login);
		if(userId == null){
			userId =0;
		}
		return userId;
	}

	@Override
	public EquipUserInfo queryUserInfo(int id) {
		// TODO Auto-generated method stub
		return (EquipUserInfo) getSqlMapClientTemplate().queryForObject("selectUserInfoFromLogin", id);
	}

	@Override
	public List<EquipmentBasicInfo> queryEquipmentBasicInfoLoginU(
			EquipmentBasicInfo info) {
		// TODO Auto-generated method stub
		List<EquipmentBasicInfo> result =  getSqlMapClientTemplate().queryForList("selectEquipBasicInfo_login_u", info);
		return result;
	}
	
	@Override
	public List<EquipmentBasicInfo> queryEquipmentBasicInfoLoginS(
			EquipmentBasicInfo info) {
		// TODO Auto-generated method stub
		List<EquipmentBasicInfo> result =  getSqlMapClientTemplate().queryForList("selectEquipBasicInfo_login_s", info);
		return result;
	}

	@Override
	public int queryEquipmentBasicCountLoginU(EquipmentBasicInfo info) {
		// TODO Auto-generated method stub
		return (int) getSqlMapClientTemplate().queryForObject("selectEquipmentCount_login_u", info);
	}
	@Override
	public int queryEquipmentBasicCountLoginS(EquipmentBasicInfo info) {
		// TODO Auto-generated method stub
		return (int) getSqlMapClientTemplate().queryForObject("selectEquipmentCount_login_s", info);
	}

	@Override
	public EquipmentBasicInfo queryEquipmentBasicInfo(int id) {
		// TODO Auto-generated method stub
		List<EquipmentBasicInfo> result = getSqlMapClientTemplate().queryForList("selectEquipBasicInfoBook", id);
		if(null != result && result.size()>0)
			return result.get(0);
		return null;
	}
	@Override
	public EquipmentBasicInfo queryEquipmentBasicInfoForAdmin(int id) {
		// TODO Auto-generated method stub
		List<EquipmentBasicInfo> result = getSqlMapClientTemplate().queryForList("selectEquipBasicInfoBook_admin", id);
		if(null != result && result.size()>0)
			return result.get(0);
		return null;
	}

	@Override
	public int queryEquipBookInfoCount(EquipBookInfo info) {
		// TODO Auto-generated method stub
		return (int)getSqlMapClientTemplate().queryForObject("selectEquipBookInfo_cou",info);
	}

	@Override
	public List<EquipBookInfo> queryEquipBookInfoList(EquipBookInfo info) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("selectEquipBookInfo", info);
	}

	@Override
	public int countBookOrderByTime(EquipBookInfo info) {
		// TODO Auto-generated method stub
		return (int) getSqlMapClientTemplate().queryForObject("selectBookOrderCount",info);
	}

	@Override
	public void generateOrder(EquipBookInfo info) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().insert("insertIntoBookOrder", info);
	}

	@Override
	public int queryMyEquipBookInfoCount(EquipBookInfo info) {
		// TODO Auto-generated method stub
		return (int) getSqlMapClientTemplate().queryForObject("selectMyEquipBookInfo_cou", info);
	}

	@Override
	public List<EquipBookInfo> queryMyEquipBookInfoList(EquipBookInfo info) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("selectMyEquipBookInfo", info);
	}

	@Override
	public void cancleOrder(int orderId) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().update("updateOrderForCancle", orderId);
	}

	@Override
	public int registerUserInfo(EquipUserInfo info) {
		// TODO Auto-generated method stub
		int userId = (int) getSqlMapClientTemplate().insert("insertUserInfo", info);
		return userId;
	}

	@Override
	public void registerLoginInfo(EquipUserInfo info) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().insert("insertLoginInfo", info);
	}

	@Override
	public void registerUserAudit(int id) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().insert("insertUserAudit", id);
	}

	@Override
	public int queryEquipUserInfoCount(EquipUserInfo info) {
		// TODO Auto-generated method stub
		return (int) getSqlMapClientTemplate().queryForObject("selectEquipUserInfoCount", info);
	}
	@Override
	public int queryEquipUserInfoPermissionCount(EquipUserInfo info) {
		// TODO Auto-generated method stub
		return (int) getSqlMapClientTemplate().queryForObject("selectEquipUserInfoPermissionCount", info);
	}

	@Override
	public List<EquipUserInfo> queryEquipUserInfoList(EquipUserInfo info) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("selectEquipUserInfo", info);
	}
	@Override
	public List<EquipUserInfo> queryEquipUserInfoPermissionList(EquipUserInfo info) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("selectEquipUserPermissionInfo", info);
	}

	@Override
	public int checkUserAuditInfo(EquipUserInfo info) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().update("updateUserAuditStatus", info);
		return 0;
	}

	@Override
	public EquipUserInfo queryEquipUserInfoById(int id) {
		// TODO Auto-generated method stub
		return (EquipUserInfo) getSqlMapClientTemplate().queryForObject("selectEquipUserInfoById", id);
	}

	@Override
	public List<EquipFileDownload> queryFileDownLoad() {
		// TODO Auto-generated method stub
		List<EquipFileDownload> result = null;
		result = getSqlMapClientTemplate().queryForList("selectFileDownload",null);
		return result;
	}

	@Override
	public int queryMyEquipAuditInfoCount(EquipBookInfo info) {
		// TODO Auto-generated method stub
		return (int) getSqlMapClientTemplate().queryForObject("selectMyEquipAuditInfo_cou",info);
	}

	@Override
	public List<EquipBookInfo> queryMyEquipAuditInfoList(EquipBookInfo info) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("selectMyEquipAuditInfo", info);
	}

	@Override
	public int modifyEquipBasicInfo(EquipmentBasicInfo equipment) throws SQLException{
		// TODO Auto-generated method stub
		try{
			getSqlMapClientTemplate().update("updateEquipBasicInfo", equipment);
			return 1;
		}catch(Exception e){
			return 0;
		}
	}
	
	@Override
	public int addEquipBasicInfo(EquipmentBasicInfo equipment) throws SQLException{
		// TODO Auto-generated method stub
		try{
			getSqlMapClientTemplate().insert("insertEquipBasicInfo", equipment);
			return 1;
		}catch(Exception e){
			return 0;
		}
	}

	@Override
	public EquipBookInfo queryAuditDetailOrder(Integer orderId) {
		// TODO Auto-generated method stub
//		EquipBookInfo bookInfo = new EquipBookInfo();
		EquipBookInfo bi = new EquipBookInfo();
		bi.setId(orderId);
		EquipBookInfo bookInfo = (EquipBookInfo)getSqlMapClientTemplate().queryForObject("selectDetailAuditOrderInfo", bi);
		return bookInfo;
	}

	@Override
	public void auditBookOrder(EquipBookInfo bookInfo) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().update("updateAuditOrderStatus",bookInfo);
	}

	@Override
	public int updateUserInfoPer(EquipUserInfo userInfo)throws Exception {
		// TODO Auto-generated method stub
		try{
			getSqlMapClientTemplate().update("updateUserPermissionInfo", userInfo);
			return 1;
		}catch(Exception e){
			return 0;
		}
	}

	@Override
	public int updateCategoryInfo(Map map) throws Exception {
		// TODO Auto-generated method stub
		try{
			if((Integer)map.get("cateId") != 0){
				getSqlMapClientTemplate().update("updateEquipCategoryOwn",map);
				getSqlMapClientTemplate().update("updateEquipBasicOwn", map);
			}
			return 1;
		}catch(Exception e){
			return 0;
		}
	}
	
	
}
