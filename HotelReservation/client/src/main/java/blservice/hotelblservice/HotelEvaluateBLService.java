package blservice.hotelblservice;

import util.EvaluationMsg;
import util.ResultMsg;
import vo.HotelEvaluateVO;

public interface HotelEvaluateBLService {
	
	/**
	 * ��������
	 *
	 */
	public EvaluationMsg inputEvaluate(HotelEvaluateVO evaluateInfoVO);
	
	
   /**
     * ����Ƿ�����ִ�ж�����
     * 
     */
   public ResultMsg checkOrder(HotelEvaluateVO orderListVO);
   
   
 
      
}