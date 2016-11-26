package bl.userbl;

import java.util.ArrayList;

import blservice.userblservice.WebManagerWebsiteManagementBLService;
import data.userdata.UserManagementDataServiceImpl;
import po.UserIDPO;
import po.UserInfoPO;
import util.ResultMsg;
import vo.UserIDVO;
import vo.UserInfoVO;



/**
 * ��վ������Ա����վ�Ĳ���
 * @author �ܳ�
 *
 */
public class WebManagerWebsiteManagement implements WebManagerWebsiteManagementBLService {

	UserManagementDataServiceImpl check;
	UserIDPO po;
	
	public WebManagerWebsiteManagement(){
		check=new 	UserManagementDataServiceImpl();
	}
	
	/**
	 * �鿴�û�������Ϣ
	 * @param �û�IDVO
	 * @return �û�������ϢVO
	 */
	public UserInfoVO UserInformationInquiry(UserIDVO vo){
		po=new UserIDPO(vo.getUserID());
		UserInfoPO p=check.GetUserBaseInfo(po);
		return new UserInfoVO(p.getUserid(),p.getUsername(),p.getContact());
	}
			
	
	/**
	 * �޸��û���Ϣ
	 * @param �û�IDVO
	 * @param �û�������ϢVO
	 * @return �޸Ľ��
	 */
	public ResultMsg UserInformationModification(UserIDVO vo1,UserInfoVO vo2){
		po=new UserIDPO(vo1.getUserID());
		UserInfoPO po1=new UserInfoPO(vo2.getUserid(),vo2.getUsername(),vo2.getContact());
		return check.SetUserBaseInfo(po,po1);
	}
			
	/**
	 * �����վӪ����Ա
	 * @param �û�IDVO
	 */
	public boolean WebsiteStuffAdd(UserIDVO vo){
		po=new UserIDPO(vo.getUserID());
		return check.addWebStuff(po);
	}

	/**
	 * �鿴��վӪ����Ա�б�
	 * @return ��վӪ����Ա�б�
	 */
	public ArrayList<UserInfoVO> WebStuffScan() {
		// TODO Auto-generated method stub
		return null;
	}
}
