package blservice.hotelblservice;

import util.ResultMsg;
import vo.HotelInfoVO;
import vo.OrderOnUserVO;


public interface HotelReserveBLService {
	
	/**
	 * Ԥ���Ƶ�
	 *
	 */
	public ResultMsg reserveHotel(HotelInfoVO reserveHotelVO);
	
	/**
	 * �����û�����
	 * 
	 */
    public ResultMsg createUserOrder(OrderOnUserVO orderInfoVO);
   
}