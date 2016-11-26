package blservice.orderblservice;

import java.util.ArrayList;

import util.ResultMsg;
import vo.OrderOnHotelVO;

/**
 * �Ƶ깤����Ա�鿴�Ƶ궩���б����飬�޸Ķ���״̬
 * 
 * @author txin
 *
 */
public interface OrderOnHotelBLService {
	
	/**
	 * �Ƶ깤����Ա�鿴�Ƶ궩���б�
	 *
	 * @param void
	 * @return �Ƶ궩���б�
	 */
	public ArrayList<OrderOnHotelVO> hotelOrderScan();
	
	/**
	 * �Ƶ깤����Ա�鿴�Ƶ궩������
	 *
	 * @param OrderOnHotelVO ����VO
	 * @return �Ƶ궩������
	 */
	public OrderOnHotelVO hotelOrderDetail(String ID);
	
	/**
	 * �Ƶ깤����Ա�޸Ķ���״̬
	 *
	 * @param orderVO ����VO
	 * @return ϵͳ��ʾ��Ϣ
	 */
	public ResultMsg hotelOrderModify(OrderOnHotelVO orderVO);
	
}
