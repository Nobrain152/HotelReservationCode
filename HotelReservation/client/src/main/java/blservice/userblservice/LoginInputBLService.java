package blservice.userblservice;

import util.UserType;
import vo.UserInfoVO;


/**
 * �û���¼
 * @author �ܳ�
 *
 */
public interface LoginInputBLService{
        
	
	/**
	 * ��¼
	 * @param ��¼������ϢVO
	 * @return ��¼���
	 */
    public boolean  LogIn(String id,String password);
		
	/**
	 * �ǳ�	
	 * @param ��¼������ϢVO
	 * @return �ǳ����
	 */
	public boolean LogOut(boolean ok);
		
	/**
	 * ע��	
	 * @param ��¼������ϢVO
	 * @return ע����
	 */
	public String Register(UserInfoVO vo);
	
	/**
	 * �õ��û�����
	 * @param userid
	 * @return
	 */
	public UserType getType(String userid);
}