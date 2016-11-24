package bl.hotelbl;



import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.hotelblservice.HotelEvaluateBLService;
import dataservice.hoteldataservice.HotelEvaluateDataService;
import net.RMIManage;
import util.DataServiceType;
import util.EvaluationMsg;
import util.ResultMsg;
import vo.HotelEvaluateVO;

public class HotelEvaluateController implements HotelEvaluateBLService{
	public ArrayList<HotelEvaluateVO> evaluationList;
	private HotelEvaluate hotelEvaluate;
	private HotelEvaluateDataService hotelEvaluateData;
	
	public HotelEvaluateController() {
		evaluationList = new ArrayList<HotelEvaluateVO>();
		hotelEvaluateData = (HotelEvaluateDataService) RMIManage
				.getDataService(DataServiceType.HotelEvaluateDataService);
		hotelEvaluate = new HotelEvaluate(hotelEvaluateData);
	}
	
	/**
	 * 输入评价
	 *
	 */
	@Override
	public EvaluationMsg inputEvaluate(HotelEvaluateVO evaluateInfoVO){
		try {
			return hotelEvaluate.inputEvaluate(evaluateInfoVO);
		} catch (RemoteException  e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
   /**
     * 检查是否在已执行订单中
     * 
     */
	@Override
   public ResultMsg checkOrder(HotelEvaluateVO evaluateInfoVO){
		try {
			return hotelEvaluate.checkOrder(evaluateInfoVO);
		} catch (RemoteException  e) {
			e.printStackTrace();
		}
		return null;
   }
   
   
  
	
}