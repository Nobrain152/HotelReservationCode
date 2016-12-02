package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.userblservice.WebManagerHotelOperationBlService;
import dataservice.userdataservice.UserManagementDataService;
import net.RMIManage;
import util.DataServiceType;
import util.ResultMsg;
import vo.HotelInfoVO;


/**
 * 网站管理人员对酒店的操作
 * @author 曹畅
 *
 */
public class WebManagerHotelOperationController implements WebManagerHotelOperationBlService {

	private WebManager manager;
	private UserManagementDataService data;
	
	
	public WebManagerHotelOperationController(){
		data= (UserManagementDataService)RMIManage.
				getDataService(DataServiceType.UserManagementDataService);
		manager=new WebManager(data);
	}
	
	/**
	 * 添加酒店	
	 * @param 酒店信息VO
	 */
	public ResultMsg HotelAdd(HotelInfoVO vo){
		try {
			return manager.HotelAdd(vo);
		} catch (RemoteException e) {
			return ResultMsg.FAIL;
		}
	}
			
	/**
	 * 添加酒店工作人员
	 * @param 酒店IDVO
	 * @param 用户IDVO
	 */
	public boolean StuffAdd(String hotelid,String userid){
		try {
			return manager.StuffAdd(hotelid, userid);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}


	/**
	 * 查看酒店列表
	 * @return 酒店信息列表
	 */
	public ArrayList<HotelInfoVO> HotelScan() {
		try {
			return manager.HotelScan();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

}
