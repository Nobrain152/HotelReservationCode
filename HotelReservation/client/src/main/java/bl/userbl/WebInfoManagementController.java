package bl.userbl;

import blservice.userblservice.WebIndividualInformationManagementBLService;
import vo.UserInfoVO;


/**
 * ��վӪ����Ա����վ������Ա�ĸ�����Ϣ����
 * @author Administrator
 *
 */
public class WebInfoManagementController implements WebIndividualInformationManagementBLService {

	private WebManager manager=new WebManager();
	
	
	/**
	 * �鿴������Ϣ	
	 * @param �û�IDVO
	 * @return �û�������ϢVO
	 */
	public UserInfoVO IndividualBaseInfolnquiry(String userid){
		return  manager.IndividualBaseInfolnquiry(userid);
	}
			
	/**
	 * �޸ĸ�����Ϣ	
	 * @param �û�IDVO
	 * @param �û���ϢVO
	 * @return �޸Ľ��
	 */
	public boolean IndividualBaseInfoModification(String userid,UserInfoVO vo2){
		return manager.IndividualBaseInfoModification(userid, vo2);
	}
			
}
