package blservice.userblservice;

import java.util.ArrayList;

import vo.UserInfoVO;



/**
 * ��վ������Ա����վ�Ĳ���
 * @author �ܳ�
 *
 */
public interface WebManagerWebsiteManagementBLService{
        
	
		
		
	/**
	 * �鿴�û�������Ϣ
	 * @param �û�IDVO
	 * @return �û�������ϢVO
	 */
	public UserInfoVO UserInformationInquiry(String userid);
		
	/**
	 * �޸��û���Ϣ
	 * @param �û�IDVO
	 * @param �û�������ϢVO
	 * @return �޸Ľ��
	 */
	public boolean UserInformationModification(String userid,UserInfoVO vo2);
	
	/**
	 * �鿴��վӪ����Ա�б�
	 * @return ��վӪ����Ա�б�
	 */
	public ArrayList<UserInfoVO> WebStuffScan();
	
	
	/**
	 * �����վӪ����Ա
	 * @param �û�IDVO
	 */
	public boolean WebsiteStuffAdd(String userid);
		
}