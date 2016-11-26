package bl.hotelbl;

import java.rmi.RemoteException;

import dataservice.hoteldataservice.HotelEvaluateDataService;
import po.HotelEvaluatePO;
import util.EvaluationMsg;
import util.ResultMsg;
import vo.HotelEvaluateVO;

public class HotelEvaluate {
	
	private HotelEvaluateDataService evaluateData;
	
	public HotelEvaluate(HotelEvaluateDataService evaluateDataService){
		this.evaluateData = evaluateDataService;
	}
	
	/**
	 * ��������
	 * @param evaluateInfoVO
	 * @return
	 * @throws RemoteException
	 */
	public EvaluationMsg inputEvaluate(HotelEvaluateVO evaluateInfoVO) throws RemoteException{
		HotelEvaluatePO evaluatePO = evaluateData.findByID(evaluateInfoVO.getOrderID());
		EvaluationMsg evaluation = new EvaluationMsg(evaluatePO.getScore(),evaluatePO.getComment(),
				evaluatePO.getIsReserved());
		return evaluation;
	}

	/**
	 * ����Ƿ�����ִ�ж�����
	 * @param evaluateInfoVO
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg checkOrder(HotelEvaluateVO evaluateInfoVO) throws RemoteException{
		HotelEvaluatePO evaluatePO = evaluateData.findByID(evaluateInfoVO.getOrderID());
		ResultMsg result;
		if(evaluatePO.getIsReserved()){
			result = ResultMsg.SUCCESS;
		}
		else{
			result= ResultMsg.FAIL;
		}
		return result;
	}
   
}
