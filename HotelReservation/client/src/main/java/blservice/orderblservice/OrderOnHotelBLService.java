package blservice.orderblservice;

import java.util.ArrayList;

import po.OrderPO;
import util.ResultMsg;
import vo.OrderVO;

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
	 * @param ID
	 * @return �Ƶ궩���б�
	 */
	public ArrayList<OrderVO> hotelOrderScan(String ID);
	
	/**
	 * �Ƶ깤����Ա�鿴�Ƶ궩������
	 *
	 * @param OrderVO ����VO
	 * @return �Ƶ궩������
	 */
	public OrderVO hotelOrderDetail(String ID);
	
	/**
	 * �Ƶ깤����Ա�޸Ķ���״̬
	 *
	 * @param orderVO ����VO
	 * @return ϵͳ��ʾ��Ϣ
	 */
	public ResultMsg hotelOrderModify(OrderVO orderVO);

	public void update(OrderPO poTmp);
	
}
