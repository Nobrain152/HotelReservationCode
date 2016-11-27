package bl.userbl;

import blservice.userblservice.StuffIndividualInformationManagementBLService;
import vo.StuffInfoVO;


/**
 * �Ƶ������Ա���������Ϣ
 * @author Administrator
 *
 */
public class StuffInfoManagementController implements StuffIndividualInformationManagementBLService {

	private HotelStuff stuff;
	public StuffInfoManagementController(String userid){
		stuff=new HotelStuff(userid);
	}
	
	/**
	 * �鿴���˻�����Ϣ
	 * @param �û�IDVO
	 * @return �Ƶ������Ա��ϢVO
	 */
	public StuffInfoVO IndividualBaseInfolnquiry(String userid){
		return stuff.IndividualBaseInfolnquiry(userid);
	}
			
	
	/**
	 * �޸ĸ�����Ϣ
	 * @param �û�IDVO
	 * @param �Ƶ������Ա��ϢVO
	 * @return �޸Ľ��
	 */
	public boolean IndividualBaseInfoModification(String userid,StuffInfoVO vo2){
		return stuff.IndividualBaseInfoModification(userid, vo2);
	}
			
}
