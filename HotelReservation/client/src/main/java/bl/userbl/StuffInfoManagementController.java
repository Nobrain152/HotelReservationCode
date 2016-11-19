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
 * �Ƶ������Ա���������Ϣ
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
	 * �鿴���˻�����Ϣ
	 * @param �û�IDVO
	 * @return �Ƶ������Ա��ϢVO
	 */
	public StuffInfoVO IndividualBaseInfolnquiry(UserIDVO vo){
		return (StuffInfoVO)voi;
	}
			
	
	/**
	 * �޸ĸ�����Ϣ
	 * @param �û�IDVO
	 * @param �Ƶ������Ա��ϢVO
	 * @return �޸Ľ��
	 */
	public boolean IndividualBaseInfoModification(UserIDVO vo1,StuffInfoVO vo2){
		po=new UserIDPO(vo1.getUserID());
		StuffInfoPO po2=new StuffInfoPO(vo2.getUserid(),vo2.getUsername(),vo2.getContact(),vo2.getHotel().getHotelID());
		return user.SetUserBaseInfo(po,po2);
	}
			
}
