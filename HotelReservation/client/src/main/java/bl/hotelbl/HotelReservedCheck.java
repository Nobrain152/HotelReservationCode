package bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.hoteldataservice.HotelInfoDataService;
import vo.HotelInfoVO;

/**
 * ��ʾԤ�����ľƵ��б�
 * @author gyf
 *
 */
public class HotelReservedCheck {
	public ArrayList<HotelInfoVO> hotelList;
	private HotelInfoDataService hotelData;
	
	public HotelReservedCheck(HotelInfoDataService hotelDataService) {
		this.hotelData=hotelDataService;
		hotelList = new ArrayList<HotelInfoVO>();
	}
	
	
	/**
	 * ��ʾԤ�����ľƵ��б�
	 * @param reservedHotelListVO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<HotelInfoVO> checkReserved(HotelInfoVO reservedHotelListVO) throws RemoteException{
		//TODO ��ҪVOPOת��
    	return hotelList; 
    }
}
