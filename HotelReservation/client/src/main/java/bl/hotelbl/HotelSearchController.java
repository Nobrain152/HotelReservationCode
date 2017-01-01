package bl.hotelbl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessController;
import blservice.hotelblservice.HotelSearchBLService;
import dataservice.hoteldataservice.HotelInfoDataService;
import net.RMIManage;
import util.DataServiceType;
import vo.HotelInfoVO;
import vo.RoomInfoVO;

/**
 * 
 * @author �ܳ�
 * 
 */
public class HotelSearchController extends BusinessController implements HotelSearchBLService{
	public ArrayList<HotelInfoVO> hotelList;
	private HotelSearch hotelSearch;
	private HotelInfoDataService hotelInfoData;
	
	public HotelSearchController() {
		hotelList = new ArrayList<HotelInfoVO>();
		hotelInfoData = (HotelInfoDataService) RMIManage
				.getDataService(DataServiceType.HotelInfoDataService);
		hotelSearch = new HotelSearch(hotelInfoData);
	}
	
	/**
	 * �������������Ƶ�
	 */
	@Override
	public ArrayList<HotelInfoVO> selectCondition(HotelInfoVO hotelInfoVO,RoomInfoVO vo2,String userID,boolean done){
		try {
			return hotelSearch.selectCondition(hotelInfoVO,vo2,userID,done);
		} catch (RemoteException  e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void reinitDataService(Remote dataService) {
		hotelInfoData = (HotelInfoDataService)dataService;
		hotelSearch = new HotelSearch(hotelInfoData);
	}
	
	
	
}
