
package blservice.hotelblservice;

import util.ResultMsg;
import vo.HotelInfoVO;
import vo.OrderVO;


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
    public ResultMsg createUserOrder(OrderVO orderInfoVO);
   
}