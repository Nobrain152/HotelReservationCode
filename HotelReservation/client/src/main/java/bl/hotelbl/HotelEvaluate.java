package bl.hotelbl;

import java.rmi.RemoteException;

import bl.VOPOchange;
import dataservice.hoteldataservice.HotelEvaluateDataService;
import po.HotelEvaluatePO;
import util.ResultMsg;
import vo.HotelEvaluateVO;

/**
 * 评价酒店
 * @author gyf
 *
 */
public class HotelEvaluate {
	
	private HotelEvaluateDataService evaluateData;
	ResultMsg result;
	
	public HotelEvaluate(HotelEvaluateDataService evaluateDataService){
		this.evaluateData = evaluateDataService;
	}
	
	/**
	 * 输入评价
	 * @param evaluateInfoVO
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg inputEvaluate(HotelEvaluateVO evaluateInfoVO) throws RemoteException{
		HotelEvaluatePO evaluatePO = (HotelEvaluatePO)VOPOchange.VOtoPO(evaluateInfoVO);
		result = evaluateData.insert(evaluatePO);
		return result;
	}

	/**
	 * 检查是否在已执行订单中
	 * @param evaluateInfoVO
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg checkOrder(HotelEvaluateVO evaluateInfoVO) throws RemoteException{
		HotelEvaluatePO evaluatePO = evaluateData.findByID(evaluateInfoVO.getOrderID());
		if(evaluatePO.getIsReserved())
			result = ResultMsg.SUCCESS;
		else
			result= ResultMsg.FAIL;
		return result;
	}
   
}
