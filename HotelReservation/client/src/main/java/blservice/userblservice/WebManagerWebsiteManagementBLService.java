package blservice.userblservice;

import java.util.ArrayList;

import util.ResultMsg;
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
	public UserInfoVO userInfoInq(String userid);
		
	/**
	 * �޸��û���Ϣ
	 * @param �û�IDVO
	 * @param �û�������ϢVO
	 * @return �޸Ľ��
	 */
	public ResultMsg userInfoMod(String userid,UserInfoVO vo2);
	
	/**
	 * �鿴��վӪ����Ա�б�
	 * @return ��վӪ����Ա�б�
	 */
	public ArrayList<UserInfoVO> webStuffScan();
	
	/**
	 * �����վӪ����Ա
	 * @param vo
	 * @return
	 */
	public String addWebStuff(UserInfoVO vo);
	
	
	
		
}