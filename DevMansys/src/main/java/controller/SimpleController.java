package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import service.EquipmentServiceI;
import service.TestServiceI;

import common.CommonSession;
import common.LoginAction;

import entity.Announcement;
import entity.EquipBookInfo;
import entity.EquipFileDownload;
import entity.EquipPlatformInfo;
import entity.EquipUserInfo;
import entity.EquipmentBasicInfo;
import entity.EquipmentCategory;
import entity.Student;
import entity.UserLoginInfo;

@Controller
@EnableAutoConfiguration
@ComponentScan("service")
@ImportResource("classpath*:/beans.xml")

public class SimpleController {
	@Autowired
	public LoginAction loginAction;

	@Autowired(required = true)
	public TestServiceI testServiceI;
	
	@Autowired(required=true)
	public EquipmentServiceI equipmentServiceI;
	
	public EquipmentBasicInfo searchDto;
	
	@RequestMapping(value = "/showstu", method = RequestMethod.GET)
	@ResponseBody
	public Student view() {
		Student stu = null;
		stu.setEmail(testServiceI.test());
		return stu;
	}

	//从主界面跳转到注册界面
	@RequestMapping(value="/register_p")
	public ModelAndView register_jump(){
		ModelAndView mv = new ModelAndView("register_p");
		return mv;
	}
	//加载注册详情界面,用户填写注册信息
	@RequestMapping(value="/register_s")
	public ModelAndView register_content(){
		ModelAndView mv = new ModelAndView("register_s");
		return mv;
	}
	
	// 注册操作
	@RequestMapping(value="/doregister")
	public ModelAndView doregister(@ModelAttribute("form") EquipUserInfo userInfo){
		ModelAndView mv = new ModelAndView("register_c");
		int result = equipmentServiceI.register(userInfo);
		return mv;
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView jspTest() {
		ModelAndView mv = new ModelAndView("default");
		mv.addObject("hello", "zhangjun");
//		if(null != flag && !flag.equals("")){
//			mv.addObject("flag",flag);
//		}
		CommonSession.clear("loginSession");
		return mv;
	}

	@RequestMapping(value = "/content", method = RequestMethod.GET)
	public ModelAndView content() {
		ModelAndView mv = new ModelAndView("idcon");
		List<Announcement> list = new ArrayList<Announcement>();
		try {
			// list = equipmentServiceI.queryAnnouncement();
			Iterator<Announcement> it = CommonSession.announcementMap.values()
					.iterator();
			while (it.hasNext()) {
				list.add(it.next());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<EquipFileDownload> fileList = null;
		fileList = (List<EquipFileDownload>) CommonSession.getinfo("filedownload");
		mv.addObject("fileList", fileList);
//		loginAction.login();
		mv.addObject("result", list);
		return mv;
	}

	/**
	 * 平台公告
	 * @return
	 */
	@RequestMapping(value = "/announcementList", method = RequestMethod.GET)
	public ModelAndView announcementList() {
		ModelAndView mv = new ModelAndView("default_menu");
		mv.addObject("flag","announcement");
		return mv;
	}
	
	@RequestMapping(value = "/announcementListDetail", method = RequestMethod.GET)
	public ModelAndView announcementListDetail() {
		ModelAndView mv = new ModelAndView("announcementListDetail");
		List<Announcement> list = new ArrayList<Announcement>();
		try {
			Iterator<Announcement> it = CommonSession.announcementMap.values().iterator();
			while (it.hasNext()) {
				list.add(it.next());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("result", list);
		return mv;
	}
	
	@RequestMapping(value="/downloadList",method = RequestMethod.GET)
	public ModelAndView downloadList(){
		ModelAndView mv = new ModelAndView("default_menu");
		mv.addObject("flag","download");
		return mv;
	}
	
	@RequestMapping(value="/downloadListInfo",method = RequestMethod.GET)
	public ModelAndView downloadListInfo(){
		ModelAndView mv = new ModelAndView("default_file_download");
		List<EquipFileDownload> fileList = null;
		fileList = (List<EquipFileDownload>) CommonSession.getinfo("filedownload");
		mv.addObject("result", fileList);
		return mv;
	}

	
	
	@RequestMapping(value="/announcementDetail",method=RequestMethod.GET)
	public ModelAndView announcementDetail(@RequestParam int announceId){
		ModelAndView mv = new ModelAndView("announcementDetail");
		Announcement announcement = null;
//		System.out.println(announceId);
		for(Entry<Integer, Announcement> map:  CommonSession.announcementMap.entrySet()){
			if(map.getKey() == announceId){
				announcement = map.getValue();
			}
		}
		mv.addObject("announcement", announcement);
		return mv;
	}
	
	@RequestMapping(value="/platforminfo",method=RequestMethod.GET)
	public ModelAndView platforminfo(){
		ModelAndView mv = new ModelAndView("default_menu_platform");
		
		mv.addObject("flag","platformInfo");
		
		return mv;
	}
	@RequestMapping(value="/platformInfo_sub",method = RequestMethod.GET)
	public ModelAndView platformInfo_sub(){
		ModelAndView mv = new ModelAndView("iabout");
		EquipPlatformInfo platformInfo = (EquipPlatformInfo)CommonSession.getinfo("platformInfo");
		mv.addObject("platformInfo", platformInfo);
		return mv;
	}
	
	@RequestMapping(value="/equipmentpre",method=RequestMethod.GET)
	public ModelAndView equipmentPre(){
		ModelAndView mv = new ModelAndView("product");
		return mv;
	}
	
	@RequestMapping(value="/equipmentpreCon")
	public ModelAndView equipmentpreCon(@ModelAttribute("form") EquipmentBasicInfo paramDto){
		ModelAndView mv = new ModelAndView("iproduct");
		System.out.println(paramDto.getEquipName());
		@SuppressWarnings("unchecked")
		List<EquipmentCategory> categoryList = (List<EquipmentCategory>) CommonSession.getinfo("categoryList");
		mv.addObject("categoryList", categoryList);
		if (null == paramDto){
			searchDto = new EquipmentBasicInfo();
		}
		searchDto = paramDto;
		List<EquipmentBasicInfo> result =  equipmentServiceI.queryEquipmentBasicInfo(searchDto);
		mv.addObject("equipmentList",result);
		mv.addObject("searchDto", searchDto);
		return mv;
	}
	
	@RequestMapping(value="/login")
	public ModelAndView login(@ModelAttribute("form") UserLoginInfo login){
		ModelAndView mv = null ;
		//可以登陆
		if(null != login && login.getUserName()!= null && !login.getUserName().equals("")){
			EquipUserInfo user = equipmentServiceI.login(login);
			//没有取到用户
			if(user.getId() == 0){
				mv = new ModelAndView("redirect:/welcome");
			}else{//取到用户
				loginAction.login(user);//讲用户信息放入到session变量中
				//判断用户权限(对应不同权限的角色，分开页面)
				if(user.getAdminProperty()!= null && user.getAdminProperty().equals("super") )
					mv = new ModelAndView("shome");
				//TODO 普通用户、普通管理员
				if(user.getAdminProperty() != null && (user.getAdminProperty().equals("user") || user.getAdminProperty().equals("normal")))
					mv = new ModelAndView("user");
			}
			mv.addObject("user",user.getUserName());
		}else{//不可以登陆
			mv = new ModelAndView("redirect:/welcome");
		}
		return mv;
	}
	//-----------------------------------------------------------------------------------
	//超级管理员子页面(包含审核用户功能)
	@RequestMapping(value="/login_s")
	public ModelAndView loginSub(@ModelAttribute("form") EquipUserInfo searchDto){
		ModelAndView mv = new ModelAndView("sihome");
		//判断是否是审核用户
		
		if(searchDto != null  && searchDto.getToCheckStatus() != null && !searchDto.getToCheckStatus().equals("")){
			EquipUserInfo info = new EquipUserInfo();
			info.setId(searchDto.getId());
			info.setToCheckStatus(searchDto.getToCheckStatus());
			EquipUserInfo loginUser = (EquipUserInfo) CommonSession.getinfo("loginSession");
			if(loginUser != null){
					info.setCheckUser(loginUser.getId());
			}
			if(info.getCheckUser() != 0){
				equipmentServiceI.checkUserRegisterInfo(info);
			}
		}
		
		//需要查询出非超级管理员用户
		List<EquipUserInfo> equipUserInfoList = null ;
		if(searchDto != null){
			equipUserInfoList= equipmentServiceI.queryEquipUserInfoList(searchDto);
		}
		//
		mv.addObject("searchDto",searchDto);
		mv.addObject("equipUserInfoList", equipUserInfoList);
		mv.addObject("menuflag", "usercheck");
		return mv;
	}
	
	@RequestMapping(value="/userinfoById")
	public ModelAndView userInfoDetailForCheck(@RequestParam int id){
		ModelAndView mv = new ModelAndView("sihome_userdetail");
		EquipUserInfo info = equipmentServiceI.queryEquipUserInfoById(id);
		mv.addObject("userInfo", info);
		mv.addObject("menuflag", "usercheck");
		
		return mv;
	}
	/**
	 * 修改用户权限
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/userinfoById_permission")
	public ModelAndView userInfoDetailForPermission(@RequestParam int id){
		ModelAndView mv = new ModelAndView("sihome_userdetail_p");
		EquipUserInfo info = equipmentServiceI.queryEquipUserInfoById(id);
		List<EquipmentCategory> categoryList = (List<EquipmentCategory>) CommonSession.getinfo("categoryList");
		mv.addObject("categoryList", categoryList);
		mv.addObject("userInfo", info);
		mv.addObject("menuflag", "auditMana");
		
		return mv;
	}
	
	/**
	 * 权限管理界面：首页
	 * @param searchDto
	 * @return
	 */
	@RequestMapping(value="/permiss_mana")
	public ModelAndView perm_ma(@ModelAttribute("form") EquipUserInfo searchDto){
		ModelAndView mv = new ModelAndView("sihome_p");
		//需要查询出非超级管理员用户
		List<EquipUserInfo> equipUserInfoList = null ;
		if(searchDto != null){
			searchDto.setAuditStatus("done");
			equipUserInfoList= equipmentServiceI.queryEquipUserInfoPermissionList(searchDto);
		}
		//
		mv.addObject("searchDto",searchDto);
		mv.addObject("equipUserInfoList", equipUserInfoList);
		mv.addObject("menuflag", "auditMana");
		return mv;
	}
	
	/**
	 * 用户权限管理
	 * @param userInfo
	 * @return
	 */
	@RequestMapping(value="/process_permission")
	public ModelAndView process_permission(@ModelAttribute("form") EquipUserInfo userInfo){
		ModelAndView mv = new ModelAndView("sihome_userdetail_r");
		if(userInfo != null ){
			if(userInfo.getAdminProperty() != null && userInfo.getAdminProperty().equals("normal")){
				userInfo.setIsAdministrator("yes");
			}else{
				userInfo.setIsAdministrator("no");
			}
		}
		equipmentServiceI.processUserPermission(userInfo);
		return mv;
	}
	
	
	//审核跳转到用户详细信息界面
	
	
	//用户审核，查询出所有用户
	
	//----------------------------------------------------------------------------------------
	//普通用户
	@RequestMapping(value="/login_u")
	public ModelAndView loginUser(@RequestParam String user){
		ModelAndView mv = new ModelAndView("iuser");
		EquipUserInfo userInfo = (EquipUserInfo) CommonSession.getinfo("loginSession");
		
		//查询出仪器信息
		List<EquipmentCategory> categoryList = (List<EquipmentCategory>) CommonSession.getinfo("categoryList");
		mv.addObject("categoryList", categoryList);
		searchDto = new EquipmentBasicInfo();
		if(userInfo.getThisSchool().equals("no")){
			searchDto.setEquipBookProperty("un-sch");
		}else{//TODO
			searchDto.setEquipBookProperty("sch-dep");
		}
		List<EquipmentBasicInfo> result =  equipmentServiceI.queryEquipmentBasicInfoLoginU(searchDto);
		mv.addObject("equipmentList",result);
		mv.addObject("searchDto", searchDto);
		
		mv.addObject("user",userInfo);
		return mv;
	}
	
	@RequestMapping(value="/loginUserView")
	public ModelAndView loginUserView(@ModelAttribute("form") EquipmentBasicInfo paramDto){
		ModelAndView mv = new ModelAndView("iuser");
		@SuppressWarnings("unchecked")
		List<EquipmentCategory> categoryList = (List<EquipmentCategory>) CommonSession.getinfo("categoryList");
		mv.addObject("categoryList", categoryList);
		if (null == paramDto){
			searchDto = new EquipmentBasicInfo();
		}
		searchDto = paramDto;
		EquipUserInfo userInfo = (EquipUserInfo) CommonSession.getinfo(searchDto.getUserName());
		if(userInfo.getThisSchool().equals("no")){
			searchDto.setEquipBookProperty("un-sch");
		}else{//TODO
			searchDto.setEquipBookProperty("sch-dep");
		}
		List<EquipmentBasicInfo> result =  equipmentServiceI.queryEquipmentBasicInfoLoginU(searchDto);
		mv.addObject("equipmentList",result);
		mv.addObject("searchDto", searchDto);
		mv.addObject("user",userInfo);
	return mv;
	}
	
	/**
	 * 修改仪器
	 * @param paramDto
	 * @return
	 */
	@RequestMapping(value="/equipMana")
	public ModelAndView equipMana(@ModelAttribute("form") EquipmentBasicInfo paramDto){
		ModelAndView mv = new ModelAndView("iequipModify");
		@SuppressWarnings("unchecked")
		List<EquipmentCategory> categoryList = (List<EquipmentCategory>) CommonSession.getinfo("categoryList");
		mv.addObject("categoryList", categoryList);
		if (null == paramDto){
			searchDto = new EquipmentBasicInfo();
		}
		searchDto = paramDto;
//		EquipUserInfo userInfo = (EquipUserInfo) CommonSession.getinfo(searchDto.getUserName());
//		if(userInfo.getThisSchool().equals("no")){
//			searchDto.setEquipBookProperty("un-sch");
//		}else{//TODO
//			searchDto.setEquipBookProperty("sch-dep");
//		}
//			searchDto.setEquipBookProperty("sch-dep");
		List<EquipmentBasicInfo> result =  equipmentServiceI.queryEquipmentBasicInfoLoginS(searchDto);
		mv.addObject("equipmentList",result);
		mv.addObject("searchDto", searchDto);
		mv.addObject("menuflag", "equipModify");
//		mv.addObject("user",userInfo);
	return mv;
	}
	
	/**
	 * 管理员添加仪器信息
	 * @param userName
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/equipAddDetail")
	public ModelAndView equipAddDetail(){
		ModelAndView mv = new ModelAndView("iequipModify_detail");
		//从缓存中取出用户登陆信息
//		EquipUserInfo userInfo = (EquipUserInfo) CommonSession.getinfo(userName);
//		mv.addObject("user",userInfo);
		List<EquipmentCategory> categoryList = (List<EquipmentCategory>) CommonSession.getinfo("categoryList");
		mv.addObject("categoryList", categoryList);
		
		//根据设备Id查询出设别的详细信息
		EquipmentBasicInfo equipment = new EquipmentBasicInfo();
		if(equipment != null){
			mv.addObject("equipment",equipment);
		}
		//控制菜单的样式
		mv.addObject("menuflag","equipAdd");
		
		
		return mv;
	}
	
	/**
	 * 管理员添加仪器信息
	 * @param userName
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/equipModifyDetail")
	public ModelAndView equipModifyDetail(@RequestParam String userName,@RequestParam int id){
		ModelAndView mv = new ModelAndView("iequipModify_detail");
		//从缓存中取出用户登陆信息
//		EquipUserInfo userInfo = (EquipUserInfo) CommonSession.getinfo(userName);
//		mv.addObject("user",userInfo);
		List<EquipmentCategory> categoryList = (List<EquipmentCategory>) CommonSession.getinfo("categoryList");
		mv.addObject("categoryList", categoryList);
		
		//根据设备Id查询出设别的详细信息
		EquipmentBasicInfo equipment = equipmentServiceI.queryEquipmentBasicInfoForAdmin(id);
		if(equipment != null){
			mv.addObject("equipment",equipment);
		}
		//控制菜单的样式
		mv.addObject("menuflag","equipModify");
		
		
		return mv;
	}
	
	
	/**
	 * 更新仪器信息
	 * @param paramDto
	 * @return
	 */
	@RequestMapping(value="/equipModifyProcess")
	public ModelAndView equipModifyProcess(@ModelAttribute("form") EquipmentBasicInfo paramDto){
		ModelAndView mv = new ModelAndView("modifyEquipResult");
		if(paramDto != null ){
			if(paramDto.getId()!=0){
				equipmentServiceI.modifyEquipBasicInfo(paramDto);
			}else{
				equipmentServiceI.addEquipBasicInfo(paramDto);
			}
		}
		return mv;
	}
	/**
	 * 普通用户预约，跳转到预约界面
	 * @param userName
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/userBook")
	public ModelAndView userBook(@RequestParam String userName,@RequestParam int id){
		ModelAndView mv = new ModelAndView("ihpro1");
		//从缓存中取出用户登陆信息
		EquipUserInfo userInfo = (EquipUserInfo) CommonSession.getinfo(userName);
		mv.addObject("user",userInfo);
		//根据设备Id查询出设别的详细信息
		EquipmentBasicInfo equipment = equipmentServiceI.queryEquipmentBasicInfo(id);
		if(equipment != null){
			mv.addObject("equipment",equipment);
		}
		//封装查询信息，第一次跳转到预约界面，需要显示该设备目前的预约列表
		//根据仪器ID查询预约信息
		EquipBookInfo bookInfo = new EquipBookInfo();
		bookInfo.setUserId(userInfo.getId());
		bookInfo.setEquipId(id);
		
		List<EquipBookInfo> bookList = equipmentServiceI.queryEquipBookInfoList(bookInfo);
		mv.addObject("bookList",bookList);
		mv.addObject("searchDto",bookInfo);
		//控制菜单的样式
		mv.addObject("pageFlag","bookchange");
		
		
		return mv;
	}
	
	/**
	 *我的预约界面
	 * @param userName
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/myBook")
	public ModelAndView myBook(@RequestParam String userName){
		ModelAndView mv = new ModelAndView("ihpro2");
		//从缓存中取出用户登陆信息
		EquipUserInfo userInfo = (EquipUserInfo) CommonSession.getinfo(userName);
		mv.addObject("user",userInfo);
		//根据设备Id查询出设别的详细信息
//		EquipmentBasicInfo equipment = equipmentServiceI.queryEquipmentBasicInfo(id);
//		if(equipment != null){
//			mv.addObject("equipment",equipment);
//		}
		//封装查询信息，第一次跳转到预约界面，需要显示该设备目前的预约列表
		//根据仪器ID查询预约信息
		EquipBookInfo bookInfo = new EquipBookInfo();
		bookInfo.setUserId(userInfo.getId());
//		bookInfo.setEquipId(id);
		
		List<EquipBookInfo> bookList = equipmentServiceI.queryMyEquipBookInfoList(bookInfo);
		mv.addObject("bookList",bookList);
		mv.addObject("searchDto",bookInfo);
		
		//控制菜单的样式
		mv.addObject("pageFlag","mybook");
		
		return mv;
	}
	
	/**
	 *我的审核界面
	 * @param userName
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/myAudit") 
	public ModelAndView myAudit(@RequestParam String userName){
		ModelAndView mv = new ModelAndView("ihpro3");
		//从缓存中取出用户登陆信息
		EquipUserInfo userInfo = new EquipUserInfo();
		if(userName != null && userName.equals("super_admin")){
			userInfo.setUserName("super_admin");
			userInfo.setName("super_admin");
			userInfo.setId(1);
		}else{
			userInfo = (EquipUserInfo) CommonSession.getinfo("loginSession");
		}
		mv.addObject("user",userInfo);
		//根据设备Id查询出设别的详细信息
//		EquipmentBasicInfo equipment = equipmentServiceI.queryEquipmentBasicInfo(id);
//		if(equipment != null){
//			mv.addObject("equipment",equipment);
//		}
		//封装查询信息，第一次跳转到预约界面，需要显示该设备目前的预约列表
		//根据仪器ID查询预约信息
		EquipBookInfo bookInfo = new EquipBookInfo();
		bookInfo.setAuditUser(userInfo.getId());
//		bookInfo.setEquipId(id);
		
		List<EquipBookInfo> bookList = equipmentServiceI.queryMyEquipAuditInfoList(bookInfo);
		mv.addObject("bookList",bookList);
		mv.addObject("searchDto",bookInfo);
		
		//控制菜单的样式
		mv.addObject("pageFlag","myAudit");
		
		return mv;
	}
	
	
	
	/**
	 *我的预约界面
	 * @param userName
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/myBookChange")
	public ModelAndView myBookChange(@ModelAttribute("form") EquipBookInfo searchDto){
		ModelAndView mv = new ModelAndView("ihpro2");
		//如果equipId不为0,即需要取消之前的预约操作。
		if(searchDto != null && searchDto.getId() != 0){
			equipmentServiceI.cancleOrder(searchDto.getId());
		}
		//从缓存中取出用户登陆信息
		EquipUserInfo userInfo = (EquipUserInfo) CommonSession.getinfo(searchDto.getUserName());
		mv.addObject("user",userInfo);
		//根据设备Id查询出设别的详细信息
//		EquipmentBasicInfo equipment = equipmentServiceI.queryEquipmentBasicInfo(searchDto.getEquipId());
//		if(equipment != null){
//			mv.addObject("equipment",equipment);
//		}
		//封装查询信息，第一次跳转到预约界面，需要显示该设备目前的预约列表
		//根据仪器ID查询预约信息
		EquipBookInfo bookInfo = searchDto;
		bookInfo.setUserId(userInfo.getId());
//		bookInfo.setEquipId(id);
		
		//查询完成后，需要将之前取消操作的equipId设置成0,下一轮查询操作不能进行取消操作
		bookInfo.setId(0);
		
		
		List<EquipBookInfo> bookList = equipmentServiceI.queryMyEquipBookInfoList(bookInfo);
		mv.addObject("bookList",bookList);
		mv.addObject("searchDto",bookInfo);
		

		//控制菜单的样式
		mv.addObject("pageFlag","mybook");
		
		return mv;
	}
	
	/**
	 *我的审核界面
	 * @param userName
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/myAuditChange")
	public ModelAndView myAuditChange(@ModelAttribute("form") EquipBookInfo searchDto){
		ModelAndView mv = new ModelAndView("ihpro3");
		//如果equipId不为0,即需要取消之前的预约操作。
//		if(searchDto != null && searchDto.getId() != 0){
//			equipmentServiceI.cancleOrder(searchDto.getId());
//		}
		//从缓存中取出用户登陆信息
		EquipUserInfo userInfo = (EquipUserInfo) CommonSession.getinfo("loginSession");
		mv.addObject("user",userInfo);
		//根据设备Id查询出设别的详细信息
//		EquipmentBasicInfo equipment = equipmentServiceI.queryEquipmentBasicInfo(searchDto.getEquipId());
//		if(equipment != null){
//			mv.addObject("equipment",equipment);
//		}
		//封装查询信息，第一次跳转到预约界面，需要显示该设备目前的预约列表
		//根据仪器ID查询预约信息
		EquipBookInfo bookInfo = searchDto;
		bookInfo.setAuditUser(userInfo.getId());
//		bookInfo.setEquipId(id);
		
		//查询完成后，需要将之前取消操作的equipId设置成0,下一轮查询操作不能进行取消操作
		bookInfo.setId(0);
		
		
		List<EquipBookInfo> bookList = equipmentServiceI.queryMyEquipAuditInfoList(bookInfo);
		mv.addObject("bookList",bookList);
		mv.addObject("searchDto",bookInfo);
		
		
		//控制菜单的样式
		mv.addObject("pageFlag","myAudit");
		
		return mv;
	}
	/**
	 * 查看详细的订单信息
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value="/detailOrder")
	public ModelAndView detailOrder(@RequestParam int orderId){
		ModelAndView mv = new ModelAndView("idetailOrder");
		//从缓存中取出用户登陆信息
		EquipUserInfo userInfo = (EquipUserInfo) CommonSession.getinfo("loginSession");
		mv.addObject("user",userInfo);
		//设置菜单背景
		mv.addObject("pageFlag","myAudit");
		//查询显示预约订单信息
		EquipBookInfo bookInfo = equipmentServiceI.queryAuditDetailOrder(orderId);
		mv.addObject("bookInfo", bookInfo);
		return mv;
	}
	/**
	 * 审核用户预约信息
	 * @param bookInfo
	 * @return
	 */
	@RequestMapping(value="/auditOrderS")
	public ModelAndView auditOrderS(@ModelAttribute("form") EquipBookInfo bookInfo){
		ModelAndView mv = new ModelAndView("idetailOrderS");
		//从缓存中取出用户登陆信息
		EquipUserInfo userInfo = (EquipUserInfo) CommonSession.getinfo("loginSession");
		mv.addObject("user",userInfo);
		//设置菜单背景
		mv.addObject("pageFlag","myAudit");

		bookInfo.setAuditUser(userInfo.getId());
		equipmentServiceI.auditBookOrder(bookInfo);
		
		return mv;
	}
	
	@RequestMapping(value="/bookChange")
	public ModelAndView bookChangePage(@ModelAttribute("form") EquipBookInfo bookInfo){
		ModelAndView mv = new ModelAndView("ihpro1");
		//从缓存中取出用户登陆信息
		EquipUserInfo userInfo = (EquipUserInfo) CommonSession.getinfo(bookInfo.getUserName());
		mv.addObject("user",userInfo);
		//根据设备Id查询出设别的详细信息
		EquipmentBasicInfo equipment = equipmentServiceI.queryEquipmentBasicInfo(bookInfo.getEquipId());
		if(equipment != null){
			mv.addObject("equipment",equipment);
		}
		//封装查询信息，第一次跳转到预约界面，需要显示该设备目前的预约列表
		//根据仪器ID查询预约信息
		EquipBookInfo searchDto = bookInfo;
//		searchDto.setUserId(userInfo.getId());
		
		List<EquipBookInfo> bookList = equipmentServiceI.queryEquipBookInfoList(searchDto);
		mv.addObject("bookList",bookList);
		mv.addObject("searchDto",searchDto);
		

		//控制菜单的样式
		mv.addObject("pageFlag","bookchange");
		
		return mv;
	}
	
	/**
	 * 预约仪器设备
	 * @param bookInfo
	 * @return
	 */
	@RequestMapping("/bookItem")
	public ModelAndView bookItem(@ModelAttribute("form") EquipBookInfo bookInfo){
		ModelAndView mv = new ModelAndView("ihpro1");
		//从缓存中取出用户登陆信息
		EquipUserInfo userInfo = (EquipUserInfo) CommonSession.getinfo(bookInfo.getUserName());
		mv.addObject("user",userInfo);
		//根据设备Id查询出设别的详细信息
		EquipmentBasicInfo equipment = equipmentServiceI.queryEquipmentBasicInfo(bookInfo.getEquipId());
		if(equipment != null){
			mv.addObject("equipment",equipment);
		}
		//封装查询信息，第一次跳转到预约界面，需要显示该设备目前的预约列表
		//根据仪器ID查询预约信息
		EquipBookInfo searchDto = bookInfo;
//		searchDto.setUserId(userInfo.getId());
				
		//以上和分页代码一致，因为查询完毕后需要继续返回原来 页面。但是本方法需要生成预定单。
		//在页面通过js判断--第一层判断。
		//如下通过业务层面判断，如果校验失效，那么直接返回，不生成订单。如果校验通过，则生成预订单。
		
		boolean genResu = equipmentServiceI.generateOrder(searchDto);
		List<EquipBookInfo> bookList = equipmentServiceI.queryEquipBookInfoList(searchDto);
		mv.addObject("bookList",bookList);
		mv.addObject("searchDto",searchDto);
		mv.addObject("genResu",genResu);
		

		//控制菜单的样式
		mv.addObject("pageFlag","bookchange");
		
		return mv;
	}
	
}
