package blservice.hotelblservice;

import util.ResultMsg;
import vo.HotelEvaluateVO;

/**
 * ���۾Ƶ�Ľӿ�
 * @author gyf
 *
 */
public interface HotelEvaluateBLService {
	
	/**
	 * �������
	 * @param evaluateInfoVO
	 * @return
	 */
	public ResultMsg inputEvaluate(HotelEvaluateVO evaluateInfoVO);
		
   /**
    * ����Ƿ�����Ԥ��
    * @param orderListVO
    * @return
    */
   public ResultMsg checkOrder(HotelEvaluateVO orderListVO);
  
}