
package bl.hotelbl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessController;
import blservice.hotelblservice.HotelInfoMaintainBLService;
import dataservice.hoteldataservice.HotelInfoDataService;
import net.RMIManage;
import util.DataServiceType;
import util.ResultMsg;
import vo.HotelInfoVO;

/**
 * 
 * @author �ܳ�
 *
 */
public class HotelInfoMaintainController extends BusinessController implements HotelInfoMaintainBLService{
	
	public ArrayList<HotelInfoVO> hotelList;
	private HotelInfoMaintain hotelInfoMaintain;
	private HotelInfoDataService hotelInfoData;
	
	public HotelInfoMaintainController() {
		hotelList = new ArrayList<HotelInfoVO>();
		hotelInfoData = (HotelInfoDataService) RMIManage
				.getDataService(DataServiceType.HotelInfoDataService);
		hotelInfoMaintain = new HotelInfoMaintain(hotelInfoData);
	}
	
	
	/**
	 * ����Ƶ������Ϣ
	 * @param hotelInfoVO
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ResultMsg inputHotelInfo(HotelInfoVO hotelInfoVO){
		try {
			return hotelInfoMaintain.inputHotelInfo(hotelInfoVO);
		} catch (RemoteException  e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * �����Ϣ�Ƿ���ϱ�׼
	 * @param hotelInfoVO
	 * @return
	 * @throws RemoteException
	 */
	@Override
    public ResultMsg checkInfo(HotelInfoVO hotelInfoVO){
		try {
			return hotelInfoMaintain.checkInfo(hotelInfoVO);
		} catch (RemoteException  e) {
			e.printStackTrace();
		}
		return null;
    }


	/**
     * ��ӾƵ�
     * @param hotelInfoVO
     * @return
     */
	@Override
	public String addHotel(HotelInfoVO hotelInfoVO) {
		try {
			return hotelInfoMaintain.addHotel(hotelInfoVO);
		} catch (RemoteException e) {
			return null;
		}
	}


	@Override
	public void reinitDataService(Remote dataService) {
		hotelInfoData = (HotelInfoDataService)dataService;
		hotelInfoMaintain = new HotelInfoMaintain(hotelInfoData);
	}

}