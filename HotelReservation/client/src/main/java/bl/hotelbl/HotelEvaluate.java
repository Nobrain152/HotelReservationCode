package bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;


import bl.BusinessLogicDataFactory;
import bl.VOPOchange;
import blservice.hotelblservice.HotelInfoCheckBLService;
import blservice.hotelblservice.HotelInfoMaintainBLService;
import blservice.orderblservice.OrderOnUserBLService;
import dataservice.hoteldataservice.HotelEvaluateDataService;
import po.HotelEvaluatePO;
import util.OrderState;
import util.ResultMsg;
import vo.HotelEvaluateVO;
import vo.HotelInfoVO;
import vo.OrderVO;

/**
 * 评价酒店
 * @author 曹畅
 *
 */
public class HotelEvaluate {
	
	private HotelEvaluateDataService evaluateData;
	private HotelInfoCheckBLService check;
	private BusinessLogicDataFactory factory;
	private HotelInfoMaintainBLService maint;
	private OrderOnUserBLService order;
	ResultMsg result;
	
	public HotelEvaluate(HotelEvaluateDataService evaluateDataService){
		this.evaluateData = evaluateDataService;
		this.factory=BusinessLogicDataFactory.getFactory();
		this.check=factory.getHotelInfoCheckBLService();
		this.maint=factory.getHotelInfoMaintainBLService();
		this.order=factory.getOrderOnUserBLService();
	}
	
	/**
	 * 输入评价
	 * @param evaluateInfoVO
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg inputEvaluate(HotelEvaluateVO evaluateInfoVO) throws RemoteException{
		if(checkOrder(evaluateInfoVO)==ResultMsg.SUCCESS){
			HotelEvaluatePO evaluatePO = (HotelEvaluatePO)VOPOchange.VOtoPO(evaluateInfoVO);
			result = evaluateData.insert(evaluatePO);
			HotelInfoVO vo=check.checkHotelInfo(evaluateInfoVO.getHotelID());
			ArrayList<HotelEvaluateVO> past=getEvaluate(evaluateInfoVO.getHotelID());
			double sum=vo.getScore()*(past.size());
			sum+=evaluateInfoVO.getScore();
			sum=sum/(past.size()+1);
			vo.setScore(sum);
			ResultMsg r2=maint.inputHotelInfo(vo);
			if(r2==ResultMsg.SUCCESS){
				return result;
			}
			
		}
		result=ResultMsg.FAIL;
		return result;
	}

	/**
	 * 检查是否在已执行订单中
	 * @param evaluateInfoVO
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg checkOrder(HotelEvaluateVO evaluateInfoVO) throws RemoteException{
		OrderVO PO =order.personalOrderDetail(evaluateInfoVO.getOrderID());
		OrderState state=PO.getOrderState();
		if(state==OrderState.EXECUTED)
			result = ResultMsg.SUCCESS;
		else
			result= ResultMsg.FAIL;
		return result;
	}
	
	/**
	    * 查看某一酒店的评价
	    * @param hotelid
	    * @return
	    */
	   public ArrayList<HotelEvaluateVO> getEvaluate(String hotelid)throws RemoteException{
		   ArrayList<HotelEvaluateVO> vos=new ArrayList<HotelEvaluateVO>();
		   ArrayList<HotelEvaluatePO> pos;
		try {
			pos = evaluateData.show(hotelid);
		} catch (RemoteException e) {
			return null;
		}
		   for(int i=0;i<pos.size();i++){
			   vos.add((HotelEvaluateVO)VOPOchange.POtoVO(pos.get(i)));
		   }
		   return vos;
	   }
   
}
