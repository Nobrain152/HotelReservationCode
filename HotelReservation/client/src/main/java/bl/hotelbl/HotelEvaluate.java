package bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import dataservice.hoteldataservice.HotelEvaluateDataService;
import po.HotelEvaluatePO;
import util.ResultMsg;
import vo.HotelEvaluateVO;

/**
 * ���۾Ƶ�
 * @author �ܳ�
 *
 */
public class HotelEvaluate {
	
	private HotelEvaluateDataService evaluateData;
	ResultMsg result;
	
	public HotelEvaluate(HotelEvaluateDataService evaluateDataService){
		this.evaluateData = evaluateDataService;
	}
	
	/**
	 * ��������
	 * @param evaluateInfoVO
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg inputEvaluate(HotelEvaluateVO evaluateInfoVO) throws RemoteException{
		if(checkOrder(evaluateInfoVO)==ResultMsg.SUCCESS){
			HotelEvaluatePO evaluatePO = (HotelEvaluatePO)VOPOchange.VOtoPO(evaluateInfoVO);
			result = evaluateData.insert(evaluatePO);
			return result;
		}
		result=ResultMsg.FAIL;
		return result;
	}

	/**
	 * ����Ƿ�����ִ�ж�����
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
	
	/**
	    * �鿴ĳһ�Ƶ������
	    * @param hotelid
	    * @return
	    */
	   public ArrayList<HotelEvaluateVO> getEvaluate(String hotelid)throws RemoteException{
		   ArrayList<HotelEvaluateVO> vos=new ArrayList<HotelEvaluateVO>();
		   ArrayList<HotelEvaluatePO> pos;
		try {
			pos = evaluateData.find(hotelid);
		} catch (RemoteException e) {
			return null;
		}
		   for(int i=0;i<pos.size();i++){
			   vos.add((HotelEvaluateVO)VOPOchange.POtoVO(pos.get(i)));
		   }
		   return vos;
	   }
   
}
