
package blservice.hotelblservice;

import util.ResultMsg;
import vo.OrderVO;


public interface HotelReserveBLService {
	
	/**
	 * Ԥ���Ƶ�
	 *
	 */
	public ResultMsg reserveHotel(OrderVO vo);
	
	
   
}