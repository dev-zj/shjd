package common;

import java.util.Observable;

import entity.EquipUserInfo;

public class LoginAction extends Observable{

	public	CommonSession commonSession;
	
	public EquipUserInfo equipUserInfo;
	
	public void init(){
		this.addObserver(commonSession);
	}
	
	public void login(EquipUserInfo equipUserInfo){
		//登陆后，通知观察者，将用户信息放入到公共的缓存中
		this.equipUserInfo = equipUserInfo;
//		equipUserInfo.setAddress("上海市浦东新区华夏东路1152弄");
		setChanged();
		notifyObservers();
	}

	public EquipUserInfo getEquipUserInfo() {
		return equipUserInfo;
	}

	public void setEquipUserInfo(EquipUserInfo equipUserInfo) {
		this.equipUserInfo = equipUserInfo;
	}

	public CommonSession getCommonSession() {
		return commonSession;
	}

	public void setCommonSession(CommonSession commonSession) {
		this.commonSession = commonSession;
	}
	
	
}
