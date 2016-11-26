package bl.userbl;

import java.util.ArrayList;

import bl.hotelbl.HotelInfoMaintainController;
import bl.hotelbl.RoomAddController;
import bl.orderbl.OrderOnHotelController;
import blservice.userblservice.HotelStuffHotelOperationBlService;
import util.ResultMsg;
import vo.HotelInfoVO;
import vo.HotelInfoVO;
import vo.OrderOnHotelVO;
import vo.PromotionHotelVO;
import vo.RoomInfoVO;
import vo.UserIDVO;



/**
 * �Ƶ깤����Ա�ԾƵ���еĲ���
 * @author �ܳ�
 *
 */
public class HotelStuffHotelOperation implements HotelStuffHotelOperationBlService {

	HotelInfoVO hotel;
	HotelInfoMaintainController mod;
	OrderOnHotelController order;
	RoomAddController room;
	
	public HotelStuffHotelOperation(){
		mod=new HotelInfoMaintainController();
		order=new OrderOnHotelController();
		room=new RoomAddController();
	}
	
	
	/**
	 * �鿴�Ƶ���Ϣ	
	 * @param �Ƶ�IDVO
	 * @return �Ƶ���ϢVO
	 */
	public HotelInfoVO HotelInformationInquiry(HotelInfoVO vo){
		return null;
	}
			
	/**
	 * �޸ľƵ���Ϣ	
	 * @param �Ƶ�VO
	 * @param �û�IDVO
	 * @return �޸Ľ��
	 */
	public ResultMsg HotelInformationModification(HotelInfoVO vo1,UserIDVO vo2){
		return mod.submitInfo(vo1);
	}
			
	
	/**
	 * ����Ƶ��������	
	 * @param �Ƶ�IDVO
	 * @param �Ƶ��������VO
	 * @return �޸Ľ��
	 */
	public boolean HotelStrategeManage(HotelInfoVO vo1,PromotionHotelVO vo){
		return false;
	}
			
	/**
	 * ���¶���״̬	
	 * @param �û�IDVO
	 * @param ����VO
	 */
	public ResultMsg OrderStateUpdate(UserIDVO vo1,OrderOnHotelVO vo2){
		return order.hotelOrderModify(vo2);
	}
			
	/**
	 * ����Ƶ궩��	
	 * @param �Ƶ�IDVO
	 * @return ����VO�б�
	 */
	public ArrayList<OrderOnHotelVO> OrderScan(HotelInfoVO vo){
		return order.hotelOrderScan();
	}

	/**
	 * �鿴�Ƶ��������
	 * @param �Ƶ�IDVO
	 * @return �Ƶ���������б�
	 */
	public ArrayList<PromotionHotelVO> HotelPromotionInquire(HotelInfoVO vo) {
		return null;
	}

	/**
	 * ���·�����Ϣ
	 * @param ������ϢVO
	 */
	public ResultMsg UpdateRoomState(RoomInfoVO vo) {
		return room.updateRoom(vo);
		
	}
}
