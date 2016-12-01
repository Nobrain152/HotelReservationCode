package bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.hotelblservice.HotelInfoCheckBLService;
import dataservice.hoteldataservice.HotelInfoDataService;
import net.RMIManage;
import util.DataServiceType;
import vo.HotelInfoVO;

/**
 * 
 * @author ²Ü³©
 *
 */
public class HotelInfoCheckController implements HotelInfoCheckBLService{
	public ArrayList<HotelInfoVO> hotelList;
	private HotelInfoCheck hotelInfoCheck;
	private HotelInfoDataService hotelInfoData;
	
	public HotelInfoCheckController() {
		hotelList = new ArrayList<HotelInfoVO>();
		hotelInfoData = (HotelInfoDataService) RMIManage
				.getDataService(DataServiceType.HotelInfoDataService);
		hotelInfoCheck = new HotelInfoCheck(hotelInfoData);
	}

	
	@Override
    public HotelInfoVO checkHotelInfo(String hotelid){
    	try {
			return hotelInfoCheck.checkHotelInfo(hotelid);
		} catch (RemoteException  e) {
			e.printStackTrace();
		}
		return null;
    }


	@Override
	public ArrayList<HotelInfoVO> hotelScan() {
		try {
			return hotelInfoCheck.hotelScan();
		} catch (RemoteException e) {
			return null;
		}
	}
      
}