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
    public boolean  logIn(String id,String password);
		
	/**
	 * �ǳ�	
	 * @param ��¼������ϢVO
	 * @return �ǳ����
	 */
	public boolean logOut(boolean ok);
		
	/**
	 * ע��	
	 * @param ��¼������ϢVO
	 * @return ע����
	 */
	public String register(CustomerInfoVO vo);
	
	/**
	 * �õ��û�����
	 * @param userid
	 * @return
	 */
	public UserType getType(String userid);
}