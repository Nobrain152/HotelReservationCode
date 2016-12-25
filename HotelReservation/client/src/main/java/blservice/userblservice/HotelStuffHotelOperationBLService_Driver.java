package blservice.userblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.OrderState;
import util.ResultMsg;
import util.Sort;
import vo.HotelEvaluateVO;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.PromotionHotelVO;
import vo.RoomInfoVO;

public class HotelStuffHotelOperationBLService_Driver {

	 public static void main(String[] args){
			
		 HotelStuffHotelOperationBlService a=new HotelStuffHotelOperationBLService_Stub();
		 HotelStuffHotelOperationBLService_Driver b=new HotelStuffHotelOperationBLService_Driver();
		   b.drive(a);
		
		}
		
		public void drive(HotelStuffHotelOperationBlService a){
			ArrayList<HotelInfoVO> hotelInfoVOs;
			HotelInfoVO hotel;
			ArrayList<OrderVO> order;
			
			hotel=a.HotelInformationInquiry("5000");
			boolean b=a.HotelStrategeDelete(new PromotionHotelVO());
			b=a.HotelStrategeAdd(new PromotionHotelVO());
			b=a.HotelStrategeManage(new PromotionHotelVO());
			ArrayList<PromotionHotelVO> p=a.HotelPromotionInquire(new PromotionHotelVO());
			ArrayList<RoomInfoVO> r=a.HotelRoomList("5000");
			order=a.OrderScan("5000");
			order=a.AbnormalOrderScan("5000");
			order=a.specialOrderScan("5000",OrderState.ABNORMAL);
			ResultMsg res=a.HotelInformationModification(new HotelInfoVO(),"22345678");
			res=a.SetRoomInfo(new ArrayList<RoomInfoVO>());
			res=a.UpdateRoomState(new RoomInfoVO());
			res=a.TypeInRoom(new RoomInfoVO());
			res=a.setAbnormalOrder("5000","1234567890");
			try {
				res=a.OrderStateUpdate("22345678",new OrderVO());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
