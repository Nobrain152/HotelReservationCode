package blservice.userblservice;


import util.ResultMsg;
import vo.UserInfoVO;

/**
 * ��վӪ����Ա����վ������Ա�ĸ�����Ϣ����
 * @author Administrator
 *
 */
public interface WebIndividualInformationManagementBLService{
		
	
	/**
	 * �鿴������Ϣ	
	 * @param �û�IDVO
	 * @return �û�������ϢVO
	 */
	public UserInfoVO IndividualBaseInfolnquiry(String userid);
		
	/**
	 * �޸ĸ�����Ϣ	
	 * @param �û�IDVO
	 * @param �û���ϢVO
	 * @return �޸Ľ��
	 */
	public ResultMsg IndividualBaseInfoModification(String userid,UserInfoVO vo2);
		
}