package bl.userbl;

import blservice.userblservice.StuffIndividualInformationManagementBLService;
import data.userdata.UserManagementDataServiceImpl;
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
	
	public StuffInfoManagementController(UserIDVO vo){
		user=new UserManagementDataServiceImpl();
		voi=user.GetUserBaseInfo(vo);
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
		return user.SetUserBaseInfo(vo1,vo2);
	}
			
}
