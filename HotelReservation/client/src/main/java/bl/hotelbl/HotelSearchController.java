package bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.hotelblservice.HotelSearchBLService;
import dataservice.hoteldataservice.HotelEvaluateDataService;
import dataservice.hoteldataservice.HotelInfoDataService;
import net.RMIManage;
import util.DataServiceType;
import util.HotelMsg;
import vo.HotelInfoVO;

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
	 * ѡ��Ƶ�����
	 *
	 */
	@Override
	public HotelMsg selectCondition(HotelInfoVO hotelInfoVO){
		try {
			return hotelSearch.selectCondition(hotelInfoVO);
		} catch (RemoteException  e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ��ʾ�Ƶ��б�
	 * 
	 */
	@Override
    public ArrayList<HotelInfoVO> showList(HotelInfoVO hotelListInfoVO){
    	try {
			return hotelSearch.showList(hotelListInfoVO);
		} catch (RemoteException  e) {
			e.printStackTrace();
		}
		return null;
    }
}
