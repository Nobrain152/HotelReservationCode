package businesslogicservice.hotelblservice;

import businesslogic.util.EvaluationMsg;
import businesslogic.util.ResultMsg;
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