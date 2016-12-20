package blservice.userblservice;

import util.UserType;
import vo.CustomerInfoVO;



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
	public String Register(CustomerInfoVO vo);
	
	/**
	 * �õ��û�����
	 * @param userid
	 * @return
	 */
	public UserType getType(String userid);
}