package blservice.hotelblservice;

import java.util.ArrayList;

import util.HotelMsg;
import vo.HotelInfoVO;

/**
 * �����Ƶ�Ľӿ�
 * @author gyf
 *
 */
public interface HotelSearchBLService {
	
	/**
	 * ѡ��Ƶ�����
	 * @param hotelConditionVO
	 * @return
	 */
	public HotelMsg selectCondition(HotelInfoVO hotelConditionVO);
	
	/**
	 * ��ʾ�������ľƵ��б�
	 * @param hotelListInfoVO
	 * @return
	 */
    public ArrayList<HotelInfoVO> showList(HotelInfoVO hotelListInfoVO);
    
}