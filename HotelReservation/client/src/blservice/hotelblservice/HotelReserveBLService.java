package businesslogicservice.hotelblservice;

import businesslogic.util.OrderOnUserMsg;
import businesslogic.util.ResultMsg;
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
    public OrderOnUserMsg createUserOrder(OrderOnUserVO orderInfoVO);
   

      
}