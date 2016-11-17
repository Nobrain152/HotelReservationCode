package blservice.hotelblservice;

import util.OrderOnUserMsg;
import util.ResultMsg;
import vo.HotelInfoVO;
import vo.OrderOnUserVO;

public interface HotelReserveBLService {
	
	/**
	 * 预定酒店
	 *
	 */
	public ResultMsg reserveHotel(HotelInfoVO reserveHotelVO);
	
	/**
	 * 创建用户订单
	 * 
	 */
    public OrderOnUserMsg createUserOrder(OrderOnUserVO orderInfoVO);
   

      
}