package common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;

import service.EquipmentServiceI;
import entity.Announcement;
import entity.EquipFileDownload;
import entity.EquipPlatformInfo;
import entity.EquipUserInfo;
import entity.EquipmentCategory;


public class CommonSession implements Observer {
	private static Map<Object, Object> globalSession = new ConcurrentHashMap<Object, Object>();

	public static Map<Integer, Announcement> announcementMap = new ConcurrentHashMap<Integer, Announcement>();

	private EquipmentServiceI equipmentServiceI;

	public CommonSession() {
		
	}
	public class Refresh extends java.util.TimerTask{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			init();
		}
	}
	public void init(){
		System.out.println("refresh the buffer!");
		List<Announcement> announcementList = new ArrayList<Announcement>();
		try {
			announcementList = equipmentServiceI.queryAnnouncement();
			if (null != announcementList && announcementList.size() > 0) {
				for (Announcement elem : announcementList) {
					announcementMap.put(elem.getId(), elem);
				}
			}
			//获取平台介绍，初始化
			EquipPlatformInfo platformInfo = equipmentServiceI.queryPlatformInfo();
			if(null != platformInfo){
				globalSession.put("platformInfo",platformInfo);
			}
			
			List<EquipmentCategory> equipmentCategoryList = equipmentServiceI.queryEquipmentCategory();
			if(null != equipmentCategoryList && equipmentCategoryList.size()>0){
				globalSession.put("categoryList", equipmentCategoryList);
			}
			
			List<EquipFileDownload> equipFileDownloadList = equipmentServiceI.queryFileDownload();
			if(null != equipFileDownloadList && equipFileDownloadList.size()>0){
				globalSession.put("filedownload", equipFileDownloadList);
			}
			
			Timer timer = new Timer();
//			timer.schedule(new Refresh(), 60000, 60000);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// @Autowired
	// public LoginAction loginAction;

	public void putinfo(Object key, Object value) {
		globalSession.put(key, value);
	}

	public static Object getinfo(Object key) {
		return globalSession.get(key);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		LoginAction loginAction = (LoginAction) o;
		EquipUserInfo equipUserInfo = loginAction.getEquipUserInfo();
		// TODO 观察者获取被观察者的变化，放入到session缓存变量中
		globalSession.put(equipUserInfo.getUserName(), equipUserInfo);
		globalSession.put("loginSession", equipUserInfo);
		System.out.println(equipUserInfo.getUserName());

	}
	public static void clear(String obj){
		Iterator iter = globalSession.entrySet().iterator();
		while(iter.hasNext()){
			Entry entry = (Entry) iter.next();
			if(entry.getKey() != null && entry.getKey() instanceof String && entry.getKey().equals(obj))
				iter.remove();
		}
	}
	
	public EquipmentServiceI getEquipmentServiceI() {
		return equipmentServiceI;
	}

	public void setEquipmentServiceI(EquipmentServiceI equipmentServiceI) {
		this.equipmentServiceI = equipmentServiceI;
	}

}
