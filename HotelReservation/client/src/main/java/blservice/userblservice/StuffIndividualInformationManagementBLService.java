package blservice.userblservice;

import vo.StuffInfoVO;


/**
 * �Ƶ������Ա���������Ϣ
 * @author Administrator
 *
 */
public interface StuffIndividualInformationManagementBLService{
        
	/**
	 * �鿴���˻�����Ϣ
	 * @param �û�IDVO
	 * @return �Ƶ������Ա��ϢVO
	 */
	public StuffInfoVO IndividualBaseInfolnquiry(String userid);
		
	/**
	 * �޸ĸ�����Ϣ
	 * @param �û�IDVO
	 * @param �Ƶ������Ա��ϢVO
	 * @return �޸Ľ��
	 */
	public boolean IndividualBaseInfoModification(String userid,StuffInfoVO vo2);
		
}