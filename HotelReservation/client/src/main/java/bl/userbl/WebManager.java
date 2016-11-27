package bl.userbl;

import java.util.ArrayList;

import data.userdata.UserManagementDataServiceImpl;
import po.UserInfoPO;
import vo.HotelInfoVO;
import vo.UserInfoVO;

public class WebManager extends User {
	private UserManagementDataServiceImpl user=new UserManagementDataServiceImpl();
	
	/**
	 * 查看个人信息	
	 * @param 用户IDVO
	 * @return 用户个人信息VO
	 */
	public UserInfoVO IndividualBaseInfolnquiry(String userid){
		UserInfoPO po= user.GetUserBaseInfo(userid);
		UserInfoVO vo=new UserInfoVO(po.getUserid(),po.getUsername(),po.getContact());
		return vo;
	}
			
	/**
	 * 修改个人信息	
	 * @param 用户IDVO
	 * @param 用户信息VO
	 * @return 修改结果
	 */
	public boolean IndividualBaseInfoModification(String userid,UserInfoVO vo2){
		UserInfoPO po= new UserInfoPO(vo2.getUserid(),vo2.getUsername(),vo2.getContact());
		return user.SetUserBaseInfo(userid, po);
	}
		
	/**
	 * 添加酒店	
	 * @param 酒店信息VO
	 */
	public void HotelAdd(HotelInfoVO vo){
		
	}
			
	/**
	 * 添加酒店工作人员
	 * @param 酒店IDVO
	 * @param 用户IDVO
	 */
	public boolean StuffAdd(String hotelid,String userid){
		return user.addHotelStuff(hotelid,userid);
	}


	/**
	 * 查看酒店列表
	 * @return 酒店信息列表
	 */
	public ArrayList<HotelInfoVO> HotelScan() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 查看用户个人信息
	 * @param 用户IDVO
	 * @return 用户个人信息VO
	 */
	public UserInfoVO UserInformationInquiry(String userid){
		UserInfoPO po=user.GetUserBaseInfo(userid);
		UserInfoVO vo=new UserInfoVO(po.getUserid(),po.getUsername(),po.getContact());
		return vo;
	}
			
	
	/**
	 * 修改用户信息
	 * @param 用户IDVO
	 * @param 用户个人信息VO
	 * @return 修改结果
	 */
	public boolean UserInformationModification(String userid,UserInfoVO vo2){
		UserInfoPO po1=new UserInfoPO(vo2.getUserid(),vo2.getUsername(),vo2.getContact());
		return user.SetUserBaseInfo(userid,po1);
	}
			
	/**
	 * 添加网站营销人员
	 * @param 用户IDVO
	 */
	public boolean WebsiteStuffAdd(String userid){
		return user.addWebStuff(userid);
	}

	/**
	 * 查看网站营销人员列表
	 * @return 网站营销人员列表
	 */
	public ArrayList<UserInfoVO> WebStuffScan() {
		// TODO Auto-generated method stub
		return null;
	}

}
