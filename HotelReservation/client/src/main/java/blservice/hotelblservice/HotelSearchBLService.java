package blservice.hotelblservice;

import java.util.ArrayList;

import util.HotelMsg;
import vo.HotelInfoVO;

public interface HotelSearchBLService {
	
	/**
	 * ѡ��Ƶ�����
	 *
	 */
	public HotelMsg selectCondition(HotelInfoVO hotelConditionVO);
	
	/**
	 * ��ʾ�Ƶ��б�
	 * 
	 */
    public ArrayList<HotelInfoVO> showList(HotelInfoVO hotelListInfoVO);
    
}