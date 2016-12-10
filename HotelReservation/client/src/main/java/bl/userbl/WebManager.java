package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessLogicDataFactory;
import bl.VOPOchange;
import blservice.hotelblservice.HotelInfoCheckBLService;
import blservice.hotelblservice.HotelInfoMaintainBLService;
import dataservice.userdataservice.UserManagementDataService;
import po.StuffInfoPO;
import po.UserInfoPO;
import util.ResultMsg;
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
	private HotelInfoCheckBLService check;
	private HotelInfoMaintainBLService main;
	private BusinessLogicDataFactory factory;
	
	public WebManager(UserManagementDataService data){
		super(data);
		factory=BusinessLogicDataFactory.getFactory();
		this.data=data;
		check=factory.getHotelInfoCheckBLService();
		main=factory.getHotelInfoMaintainBLService();
	}
	/**
	 * 查看个人信息	
	 * @param 用户IDVO
	 * @return 用户个人信息VO
	 */
	public UserInfoVO IndividualBaseInfolnquiry(String userid)throws RemoteException{
		UserInfoPO po= data.GetUserBaseInfo(userid);
		UserInfoVO vo=(UserInfoVO)VOPOchange.POtoVO(po);
		return vo;
	}
			
	/**
	 * 修改个人信息	
	 * @param 用户IDVO
	 * @param 用户信息VO
	 * @return 修改结果
	 */
	public ResultMsg IndividualBaseInfoModification(String userid,UserInfoVO vo2)throws RemoteException{
		UserInfoPO po= (UserInfoPO)VOPOchange.VOtoPO(vo2);
		return data.SetUserBaseInfo(userid, po);
	}
		
	/**
	 * 添加酒店	
	 * @param 酒店信息VO
	 */
	public String HotelAdd(HotelInfoVO vo)throws RemoteException{
		return main.addHotel(vo);
	}
			
	/**
	 * 添加酒店工作人员
	 * @param 酒店IDVO
	 * @param 用户IDVO
	 */
	public boolean StuffAdd(String hotelid,String userid)throws RemoteException{
		ArrayList<StuffInfoPO> already=data.HotelStuffScan();
		for(StuffInfoPO p:already){
			if(p.getHotel().equals(hotelid))
				return false;
		}
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
		UserInfoVO vo=(UserInfoVO)VOPOchange.POtoVO(po);
		return vo;
	}
			
	
	/**
	 * 修改用户信息
	 * @param 用户IDVO
	 * @param 用户个人信息VO
	 * @return 修改结果
	 */
	public ResultMsg UserInformationModification(String userid,UserInfoVO vo2)throws RemoteException{
		UserInfoPO po1=(UserInfoPO)VOPOchange.POtoVO(vo2);
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
			vos.add((UserInfoVO)VOPOchange.POtoVO(pos.get(i)));
		}
		return vos;
	}

}
