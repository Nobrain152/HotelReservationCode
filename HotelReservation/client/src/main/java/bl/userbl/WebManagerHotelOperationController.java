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
 * ��վ������Ա�ԾƵ�Ĳ���
 * @author �ܳ�
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
	 * ��ӾƵ�	
	 * @param �Ƶ���ϢVO
	 */
	public ResultMsg HotelAdd(HotelInfoVO vo){
		try {
			return manager.HotelAdd(vo);
		} catch (RemoteException e) {
			return ResultMsg.FAIL;
		}
	}
			
	/**
	 * ��ӾƵ깤����Ա
	 * @param �Ƶ�IDVO
	 * @param �û�IDVO
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
	 * �鿴�Ƶ��б�
	 * @return �Ƶ���Ϣ�б�
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
