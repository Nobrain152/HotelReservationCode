package bl.userbl;

import java.rmi.RemoteException;

import bl.VOPOchange;
import dataservice.userdataservice.UserManagementDataService;
import po.CustomerInfoPO;
import po.StuffInfoPO;
import po.UserInfoPO;
import util.UserType;
import vo.UserInfoVO;

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
	public String Register(UserInfoVO vo)throws RemoteException{
		UserInfoPO po=(UserInfoPO)VOPOchange.VOtoPO(vo);
		if(po.getType()==UserType.Customer){
			return data.AddCustomer((CustomerInfoPO)po);
		}
		if(po.getType()==UserType.HotelStuff){
			return data.AddHotelStuff((StuffInfoPO)po);
		}
		if(po.getType()==UserType.WebStuff){
			return data.AddWebStuff(po);
		}
		if(po.getType()==UserType.WebManager){
			return data.AddWebManager(po);
		}
		return null;
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
