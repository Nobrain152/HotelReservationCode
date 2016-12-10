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
    	real=md.md5Encode(real);
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
	public String Register(UserInfoVO vo)throws RemoteException{
		UserInfoPO po=(UserInfoPO)VOPOchange.VOtoPO(vo);
		po.setPassword(md.md5Encode(po.getPassword()));
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
