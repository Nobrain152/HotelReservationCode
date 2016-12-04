package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import bl.hotelbl.HotelInfoCheckController;
import bl.hotelbl.HotelInfoMaintainController;
import dataservice.userdataservice.UserManagementDataService;
import po.ContactPO;
import po.UserInfoPO;
import util.ResultMsg;
import vo.ContactVO;
import vo.HotelInfoVO;
import vo.UserInfoVO;

/**
 * 网站管理人员类
 * @author 曹畅
 * 
 *
 */
public class WebManager extends User {
	private UserManagementDataService data;
	private HotelInfoCheckController check;
	private HotelInfoMaintainController main;
	
	public WebManager(UserManagementDataService data){
		super(data);
		this.data=data;
		check=new HotelInfoCheckController();
		main=new HotelInfoMaintainController();
	}
	/**
	 * 查看个人信息	
	 * @param 用户IDVO
	 * @return 用户个人信息VO
	 */
	public UserInfoVO IndividualBaseInfolnquiry(String userid)throws RemoteException{
		UserInfoPO po= data.GetUserBaseInfo(userid);
		UserInfoVO vo=new UserInfoVO(po.getUserID(),po.getUsername(),(ContactVO)VOPOchange.POtoVO(po.getContact()));
		return vo;
	}
			
	/**
	 * 修改个人信息	
	 * @param 用户IDVO
	 * @param 用户信息VO
	 * @return 修改结果
	 */
	public ResultMsg IndividualBaseInfoModification(String userid,UserInfoVO vo2)throws RemoteException{
		UserInfoPO po= new UserInfoPO(vo2.getUserID(),vo2.getUsername(),(ContactPO)VOPOchange.VOtoPO(vo2.getContact()));
		return data.SetUserBaseInfo(userid, po);
	}
		
	/**
	 * 添加酒店	
	 * @param 酒店信息VO
	 */
	public ResultMsg HotelAdd(HotelInfoVO vo)throws RemoteException{
		return main.addHotel(vo);
	}
			
	/**
	 * 添加酒店工作人员
	 * @param 酒店IDVO
	 * @param 用户IDVO
	 */
	public boolean StuffAdd(String hotelid,String userid)throws RemoteException{
		return data.addHotelStuff(hotelid,userid);
	}


	/**
	 * 查看酒店列表
	 * @return 酒店信息列表
	 */
	public ArrayList<HotelInfoVO> HotelScan()throws RemoteException {
		return check.hotelScan();
	}
	
	/**
	 * 查看用户个人信息
	 * @param 用户IDVO
	 * @return 用户个人信息VO
	 */
	public UserInfoVO UserInformationInquiry(String userid)throws RemoteException{
		UserInfoPO po=data.GetUserBaseInfo(userid);
		UserInfoVO vo=new UserInfoVO(po.getUserID(),po.getUsername(),(ContactVO)VOPOchange.POtoVO(po.getContact()));
		return vo;
	}
			
	
	/**
	 * 修改用户信息
	 * @param 用户IDVO
	 * @param 用户个人信息VO
	 * @return 修改结果
	 */
	public ResultMsg UserInformationModification(String userid,UserInfoVO vo2)throws RemoteException{
		UserInfoPO po1=new UserInfoPO(vo2.getUserID(),vo2.getUsername(),(ContactPO)VOPOchange.VOtoPO(vo2.getContact()));
		return data.SetUserBaseInfo(userid,po1);
	}
			
	/**
	 * 添加网站营销人员
	 * @param 用户IDVO
	 */
	public boolean WebsiteStuffAdd(String userid)throws RemoteException{
		return data.addWebStuff(userid);
	}

	/**
	 * 查看网站营销人员列表
	 * @return 网站营销人员列表
	 */
	public ArrayList<UserInfoVO> WebStuffScan() throws RemoteException{
		ArrayList<UserInfoPO> pos=data.WebStuffScan();
		ArrayList<UserInfoVO> vos=new ArrayList<UserInfoVO>();
		for(int i=0;i<pos.size();i++){
			vos.add(new UserInfoVO(pos.get(i).getUserID(),pos.get(i).getUsername(),new ContactVO(pos.get(i).getContact().phoneNumber,pos.get(i).getContact().emailAddress)));
		}
		return vos;
	}

}
