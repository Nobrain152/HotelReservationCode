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
	 * 输入评价
	 *
	 */
	public EvaluationMsg inputEvaluate(HotelEvaluateVO evaluateInfoVO){
		return new EvaluationMsg(evaluateInfoVO.getScore(),evaluateInfoVO.getComment(),
				evaluateInfoVO.isReserved());
	}
	
	
   /**
     * 检查是否在已执行订单中
     * 
     */
   public ResultMsg checkOrder(HotelEvaluateVO evaluateInfoVO){
	   if(evaluateInfoVO.isReserved()){
		   return new ResultMsg(true,"完成评价");
	   }
	   else{
		   return new ResultMsg(false,"评价出错");
	   }
   }
   
   
  
	
}