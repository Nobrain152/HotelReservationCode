package bl.hotelbl;



import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.hotelblservice.HotelEvaluateBLService;
import dataservice.hoteldataservice.HotelEvaluateDataService;
import net.RMIManage;
import util.DataServiceType;
import util.ResultMsg;
import vo.HotelEvaluateVO;

/**
 * 
 * @author ²Ü³©
 *
 */
public class HotelEvaluateController implements HotelEvaluateBLService{

	private HotelEvaluate hotelEvaluate;
	private HotelEvaluateDataService hotelEvaluateData;
	public ArrayList<HotelEvaluateVO> evaluationList;
	
	public HotelEvaluateController() {
		hotelEvaluateData = (HotelEvaluateDataService) RMIManage
				.getDataService(DataServiceType.HotelEvaluateDataService);
		hotelEvaluate = new HotelEvaluate(hotelEvaluateData);
	}

	@Override
	public ResultMsg inputEvaluate(HotelEvaluateVO evaluateInfoVO){
		try {
			return hotelEvaluate.inputEvaluate(evaluateInfoVO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public ResultMsg checkOrder(HotelEvaluateVO evaluateInfoVO){
		try {
			return hotelEvaluate.checkOrder(evaluateInfoVO);
		} catch (RemoteException  e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public ArrayList<HotelEvaluateVO> getEvaluate(String hotelid) {
		try {
			return hotelEvaluate.getEvaluate(hotelid);
		} catch (RemoteException e) {
			return null;
		}
	}
	
}