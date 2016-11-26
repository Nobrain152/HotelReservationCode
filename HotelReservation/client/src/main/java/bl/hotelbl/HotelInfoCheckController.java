package bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.hotelblservice.HotelInfoCheckBLService;
import dataservice.hoteldataservice.HotelInfoDataService;
import net.RMIManage;
import util.DataServiceType;
import util.HotelMsg;
import vo.HotelInfoVO;

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

	/**
	 * ��ʾ�Ƶ���Ϣ
	 * 
	 */
	@Override
    public HotelMsg checkHotelInfo(HotelInfoVO hotelInfoVO){
    	try {
			return hotelInfoCheck.checkHotelInfo(hotelInfoVO);
		} catch (RemoteException  e) {
			e.printStackTrace();
		}
		return null;
    }
      
}