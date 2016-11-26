package bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.hoteldataservice.HotelInfoDataService;
import util.HotelMsg;
import vo.HotelInfoVO;

/**
 * �����Ƶ�
 * @author gyf
 *
 */
public class HotelSearch {
	private HotelInfoDataService hotelData;
	private HotelMsg evaluation;
	public ArrayList<HotelInfoVO> hotelList;
	
	public HotelSearch(HotelInfoDataService hotelDataService){
		this.hotelData=hotelDataService;
		hotelList = new ArrayList<HotelInfoVO>();
	}

	/**
	 * ѡ������
	 * @param hotelInfoVO
	 * @return
	 * @throws RemoteException
	 */
	public HotelMsg selectCondition(HotelInfoVO hotelInfoVO) throws RemoteException{
		evaluation =new HotelMsg(hotelInfoVO.getName(),hotelInfoVO.getAddress(),
    			hotelInfoVO.getArea(),hotelInfoVO.getLevel(),hotelInfoVO.getIntroduction(),
    			hotelInfoVO.getFacility(),hotelInfoVO.getIsReserved());
		return evaluation;
	}
	
	/**
	 * ��ʾ�Ƶ��б�
	 * @param hotelListInfoVO
	 * @return
	 * @throws RemoteException
	 */
    public ArrayList<HotelInfoVO> showList(HotelInfoVO hotelListInfoVO) throws RemoteException{
    	return hotelList;
    }
}
