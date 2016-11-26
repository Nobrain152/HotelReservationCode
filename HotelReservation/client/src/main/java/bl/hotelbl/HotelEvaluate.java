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
	 * ��������
	 *
	 */
	public EvaluationMsg inputEvaluate(HotelEvaluateVO evaluateInfoVO) throws RemoteException{
		evaluation=new EvaluationMsg(evaluateInfoVO.getScore(),evaluateInfoVO.getComment(),
				evaluateInfoVO.isReserved());
		return evaluation;
	}
	
	
   /**
     * ����Ƿ�����ִ�ж�����
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
