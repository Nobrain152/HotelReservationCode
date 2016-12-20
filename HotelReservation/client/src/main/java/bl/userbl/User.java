package bl.userbl;

import java.rmi.RemoteException;

import bl.VOPOchange;
import dataservice.userdataservice.UserManagementDataService;
import po.CustomerInfoPO;
import util.UserType;
import vo.CustomerInfoVO;


/**
 * �û���ĸ���
 * @author �ܳ�
 *
 */
public class User {
	
	private UserManagementDataService data;
	
	
	public User(UserManagementDataService data){
		this.data=data;
	}
	
	/**
	 * ��¼
	 * @param ��¼������ϢVO
	 * @return ��¼���
	 */
    public boolean  LogIn(String id,String password)throws RemoteException{
    	String real=data.GetLoginInfo(id);
    	System.out.println("password"+real);
    	password=MD5Util.md5Encode(password);
    	return real.equals(password);
    	
    }
	
	
    /**
	 * �ǳ�	
	 * @param ��¼������ϢVO
	 * @return �ǳ����
	 */
	public boolean LogOut(boolean ok)throws RemoteException{
		if(ok){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	/**
	 * ע��	
	 * @param ��¼������ϢVO
	 * @return ע����
	 */
	public String Register(CustomerInfoVO vo)throws RemoteException{
		CustomerInfoPO po=(CustomerInfoPO)VOPOchange.VOtoPO(vo);
		po.setPassword(MD5Util.md5Encode(po.getPassword()));
		return data.AddCustomer(po);
	}
	
	/**
	 * �õ��û�����
	 * @param userid
	 * @return
	 */
	public UserType getType(String userid)throws RemoteException{
		char charge=userid.charAt(0);
		switch(charge){
		case'1':return UserType.Customer;
		case'2':return UserType.HotelStuff;
		case'3':return UserType.WebStuff;
		case'4':return UserType.WebManager;
		default:return null;
		}
	}
}
