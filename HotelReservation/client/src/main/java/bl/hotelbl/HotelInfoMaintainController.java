package bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.hotelblservice.HotelInfoMaintainBLService;
import dataservice.hoteldataservice.HotelInfoDataService;
import net.RMIManage;
import util.DataServiceType;
import util.HotelMsg;
import util.ResultMsg;
import vo.HotelInfoVO;

/**
 * 
 * @author gyf
 *
 */
public class HotelInfoMaintainController implements HotelInfoMaintainBLService{
	
	public ArrayList<HotelInfoVO> hotelList;
	private HotelInfoMaintain hotelInfoMaintain;
	private HotelInfoDataService hotelInfoData;
	
	public HotelInfoMaintainController() {
		hotelList = new ArrayList<HotelInfoVO>();
		hotelInfoData = (HotelInfoDataService) RMIManage
				.getDataService(DataServiceType.HotelInfoDataService);
		hotelInfoMaintain = new HotelInfoMaintain(hotelInfoData);
	}
	
	
	@Override
	public HotelMsg inputHotelInfo(HotelInfoVO hotelInfoVO){
		try {
			return hotelInfoMaintain.inputHotelInfo(hotelInfoVO);
		} catch (RemoteException  e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
    public ResultMsg checkInfo(HotelInfoVO hotelInfoVO){
		try {
			return hotelInfoMaintain.checkInfo(hotelInfoVO);
		} catch (RemoteException  e) {
			e.printStackTrace();
		}
		return null;
    }

}