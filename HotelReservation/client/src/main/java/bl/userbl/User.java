package bl.userbl;

import java.rmi.RemoteException;

import bl.VOPOchange;
import dataservice.userdataservice.UserManagementDataService;
import po.CustomerInfoPO;
import util.UserType;
import vo.CustomerInfoVO;


/**
 * 用户类的父类
 * @author 曹畅
 *
 */
public class User {
	
	private UserManagementDataService data;
	private MD5Util md;
	
	public User(UserManagementDataService data){
		this.data=data;
		md=new MD5Util();
	}
	
	/**
	 * 登录
	 * @param 登录输入信息VO
	 * @return 登录结果
	 */
    public boolean  LogIn(String id,String password)throws RemoteException{
    	String real=data.GetLoginInfo(id);
    	System.out.println("password"+real);
    	password=md.md5Encode(password);
    	return real.equals(password);
    	
    }
	
	
    /**
	 * 登出	
	 * @param 登录输入信息VO
	 * @return 登出结果
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
	 * 注册	
	 * @param 登录输入信息VO
	 * @return 注册结果
	 */
	public String Register(CustomerInfoVO vo)throws RemoteException{
		CustomerInfoPO po=(CustomerInfoPO)VOPOchange.VOtoPO(vo);
		po.setPassword(md.md5Encode(po.getPassword()));
		return data.AddCustomer(po);
	}
	
	/**
	 * 得到用户类型
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
