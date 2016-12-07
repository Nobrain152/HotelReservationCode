package bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.hotelblservice.HotelSearchBLService;
import dataservice.hoteldataservice.HotelInfoDataService;
import net.RMIManage;
import util.DataServiceType;
import vo.HotelInfoVO;
import vo.RoomInfoVO;

/**
 * 
 * @author 曹畅
 * 
 */
public class HotelSearchController implements HotelSearchBLService{
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
	 * 根据条件搜索酒店
	 */
	@Override
	public ArrayList<HotelInfoVO> selectCondition(HotelInfoVO hotelInfoVO,RoomInfoVO vo2){
		try {
			return hotelSearch.selectCondition(hotelInfoVO,vo2);
		} catch (RemoteException  e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
