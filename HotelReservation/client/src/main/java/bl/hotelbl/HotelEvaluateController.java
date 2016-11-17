package bl.hotelbl;



import java.util.ArrayList;

import util.EvaluationMsg;
import util.ResultMsg;
import vo.HotelEvaluateVO;

public class HotelEvaluateController {
	public ArrayList<HotelEvaluateVO> evaluationList;
	
	public HotelEvaluateController() {
		evaluationList = new ArrayList<HotelEvaluateVO>();
	}
	
	/**
	 * ��������
	 *
	 */
	public EvaluationMsg inputEvaluate(HotelEvaluateVO evaluateInfoVO){
		return new EvaluationMsg(evaluateInfoVO.getScore(),evaluateInfoVO.getComment(),
				evaluateInfoVO.isReserved());
	}
	
	
   /**
     * ����Ƿ�����ִ�ж�����
     * 
     */
   public ResultMsg checkOrder(HotelEvaluateVO evaluateInfoVO){
	   if(evaluateInfoVO.isReserved()){
		   return new ResultMsg(true,"�������");
	   }
	   else{
		   return new ResultMsg(false,"���۳���");
	   }
   }
   
   
  
	
}