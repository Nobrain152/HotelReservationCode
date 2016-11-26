package bl.userbl;

import blservice.userblservice.WebIndividualInformationManagementBLService;
import data.userdata.UserManagementDataServiceImpl;
import po.UserIDPO;
import po.UserInfoPO;
import util.ResultMsg;
import vo.UserIDVO;
import vo.UserInfoVO;


/**
 * ��վӪ����Ա����վ������Ա�ĸ�����Ϣ����
 * @author Administrator
 *
 */
public class WebInfoManagement implements WebIndividualInformationManagementBLService {

	UserManagementDataServiceImpl user=new UserManagementDataServiceImpl();
	UserIDVO v;
	UserIDPO po;
	
	public WebInfoManagement(UserIDVO vo){
		v=vo;
	}
	
	/**
	 * �鿴������Ϣ	
	 * @param �û�IDVO
	 * @return �û�������ϢVO
	 */
	public UserInfoVO IndividualBaseInfolnquiry(UserIDVO vo){
		po=new UserIDPO(vo.getUserID());
		UserInfoPO p=user.GetUserBaseInfo(po);
		return new UserInfoVO(p.getUserid(),p.getUsername(),p.getContact());
	}
			
	/**
	 * �޸ĸ�����Ϣ	
	 * @param �û�IDVO
	 * @param �û���ϢVO
	 * @return �޸Ľ��
	 */
	public ResultMsg IndividualBaseInfoModification(UserIDVO vo1,UserInfoVO vo2){
		po=new UserIDPO(vo1.getUserID());
		UserInfoPO p=new UserInfoPO(vo2.getUserid(),vo2.getUsername(),vo2.getContact());
		return user.SetUserBaseInfo(po,p);
	}
			
}
