package bl.userbl;

import java.util.ArrayList;

import blservice.userblservice.WebManagerWebsiteManagementBLService;
import vo.UserInfoVO;



/**
 * ��վ������Ա����վ�Ĳ���
 * @author �ܳ�
 *
 */
public class WebManagerWebsiteManagementController implements WebManagerWebsiteManagementBLService {

	private WebManager manager=new WebManager();
	
	/**
	 * �鿴�û�������Ϣ
	 * @param �û�IDVO
	 * @return �û�������ϢVO
	 */
	public UserInfoVO UserInformationInquiry(String userid){
		return manager.UserInformationInquiry(userid);
	}
			
	
	/**
	 * �޸��û���Ϣ
	 * @param �û�IDVO
	 * @param �û�������ϢVO
	 * @return �޸Ľ��
	 */
	public boolean UserInformationModification(String userid,UserInfoVO vo2){
		return manager.UserInformationModification(userid, vo2);
	}
			
	/**
	 * �����վӪ����Ա
	 * @param �û�IDVO
	 */
	public boolean WebsiteStuffAdd(String userid){
		return manager.WebsiteStuffAdd(userid);
	}

	/**
	 * �鿴��վӪ����Ա�б�
	 * @return ��վӪ����Ա�б�
	 */
	public ArrayList<UserInfoVO> WebStuffScan() {
		return manager.WebStuffScan();
	}
}
