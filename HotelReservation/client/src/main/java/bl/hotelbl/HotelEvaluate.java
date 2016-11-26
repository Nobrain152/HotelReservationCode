package bl.hotelbl;

import java.rmi.RemoteException;

import dataservice.hoteldataservice.HotelEvaluateDataService;
import util.EvaluationMsg;
import util.ResultMsg;
import vo.HotelEvaluateVO;

public class HotelEvaluate {
	private HotelEvaluateDataService evaluateData;
	private EvaluationMsg evaluation;
	private ResultMsg result;
	
	public HotelEvaluate(HotelEvaluateDataService evaluateDataService){
		this.evaluateData=evaluateDataService;
	}
	
	/**
	 * 输入评价
	 *
	 */
	public EvaluationMsg inputEvaluate(HotelEvaluateVO evaluateInfoVO) throws RemoteException{
		evaluation=new EvaluationMsg(evaluateInfoVO.getScore(),evaluateInfoVO.getComment(),
				evaluateInfoVO.isReserved());
		return evaluation;
	}
	
	
   /**
     * 检查是否在已执行订单中
     * 
     */
   public ResultMsg checkOrder(HotelEvaluateVO evaluateInfoVO) throws RemoteException{
	   if(evaluateInfoVO.isReserved()){
		   result = ResultMsg.SUCCESS;
	   }
	   else{
		   result= ResultMsg.FAIL;
	   }
	   return result;
   }
   
}
