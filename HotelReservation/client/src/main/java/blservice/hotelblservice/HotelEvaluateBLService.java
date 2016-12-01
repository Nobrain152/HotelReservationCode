package blservice.hotelblservice;

import java.util.ArrayList;

import util.ResultMsg;
import vo.HotelEvaluateVO;

/**
 * ���۾Ƶ�Ľӿ�
 * @author �ܳ�
 *
 */
public interface HotelEvaluateBLService {
	
	/**
	 * �������
	 * @param evaluateInfoVO
	 * @return
	 */
	public ResultMsg inputEvaluate(HotelEvaluateVO evaluateInfoVO);
		
   /**
    * ����Ƿ�����Ԥ��
    * @param orderListVO
    * @return
    */
   public ResultMsg checkOrder(HotelEvaluateVO orderListVO);
   
   /**
    * �鿴ĳһ�Ƶ������
    * @param hotelid
    * @return
    */
   public ArrayList<HotelEvaluateVO> getEvaluate(String hotelid);
  
}