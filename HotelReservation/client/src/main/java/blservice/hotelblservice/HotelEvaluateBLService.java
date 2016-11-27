package blservice.hotelblservice;

import util.ResultMsg;
import vo.HotelEvaluateVO;

/**
 * 评价酒店的接口
 * @author gyf
 *
 */
public interface HotelEvaluateBLService {
	
	/**
	 * 添加评论
	 * @param evaluateInfoVO
	 * @return
	 */
	public ResultMsg inputEvaluate(HotelEvaluateVO evaluateInfoVO);
		
   /**
    * 检查是否在已预订
    * @param orderListVO
    * @return
    */
   public ResultMsg checkOrder(HotelEvaluateVO orderListVO);
  
}