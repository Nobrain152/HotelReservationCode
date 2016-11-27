package bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.hotelblservice.HotelReservedCheckBLService;
import dataservice.hoteldataservice.HotelInfoDataService;
import net.RMIManage;
import util.DataServiceType;
import vo.HotelInfoVO;

/**
 * 
 * @author gyf
 *
 */
public class HotelReservedCheckController implements HotelReservedCheckBLService{
	public ArrayList<HotelInfoVO> hotelList;
	private HotelReservedCheck hotelReservedCheck;
	private HotelInfoDataService hotelInfoData;
	
	
	public HotelReservedCheckController() {
		hotelList = new ArrayList<HotelInfoVO>();
		hotelInfoData = (HotelInfoDataService) RMIManage
				.getDataService(DataServiceType.HotelInfoDataService);
		hotelReservedCheck = new HotelReservedCheck(hotelInfoData);
	}
	
	
	@Override
    public ArrayList<HotelInfoVO> showReservedList(HotelInfoVO reservedHotelListVO){
		try {
			return hotelReservedCheck.checkReserved(reservedHotelListVO);
		} catch (RemoteException  e) {
			e.printStackTrace();
		}
		return null;
    }
      
}