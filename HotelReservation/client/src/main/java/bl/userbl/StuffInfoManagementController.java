package bl.userbl;

import blservice.userblservice.StuffIndividualInformationManagementBLService;
import data.userdata.UserManagementDataServiceImpl;
import po.StuffInfoPO;
import po.UserIDPO;
import po.UserInfoPO;
import vo.StuffInfoVO;
import vo.UserIDVO;
import vo.UserInfoVO;


/**
 * 酒店管理人员管理个人信息
 * @author Administrator
 *
 */
public class StuffInfoManagementController implements StuffIndividualInformationManagementBLService {

	UserInfoVO voi;
	UserManagementDataServiceImpl user;
	UserIDPO po;
	
	public StuffInfoManagementController(UserIDVO vo){
		user=new UserManagementDataServiceImpl();
		po=new UserIDPO(vo.getUserID());
		UserInfoPO po2=user.GetUserBaseInfo(po);
		voi=new UserInfoVO(po2.getUserid(),po2.getUsername(),po2.getContact());
	}
	
	/**
	 * 查看个人基本信息
	 * @param 用户IDVO
	 * @return 酒店管理人员信息VO
	 */
	public StuffInfoVO IndividualBaseInfolnquiry(UserIDVO vo){
		return (StuffInfoVO)voi;
	}
			
	
	/**
	 * 修改个人信息
	 * @param 用户IDVO
	 * @param 酒店管理人员信息VO
	 * @return 修改结果
	 */
	public boolean IndividualBaseInfoModification(UserIDVO vo1,StuffInfoVO vo2){
		po=new UserIDPO(vo1.getUserID());
		StuffInfoPO po2=new StuffInfoPO(vo2.getUserid(),vo2.getUsername(),vo2.getContact(),vo2.getHotel().getHotelID());
		return user.SetUserBaseInfo(po,po2);
	}
			
}
