package blservice.orderblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.OrderVO;

/**
 * ��վӪ����Ա�鿴�����б������鿴һ�������б�����
 * 
 * @author txin
 *
 */
public interface OrderOnWebBLService {
	
	/**
	 * ��վӪ����Ա�鿴�쳣�����б�
	 *
	 * @param void
	 * @return �쳣�����б�
	 */
	public ArrayList<OrderVO> abnormalOrderScan();
	
	/**
	 * ���ÿ��δִ�ж���
	 * @param today
	 * @return
	 * @throws RemoteException
	 */	
	public ArrayList<OrderVO> dayUnexOrder(String today);
	
	/**
	 * ��վӪ����Ա�鿴�쳣��������
	 *
	 * @param orderVO ����VO
	 * @return ���˶�������
	 */
	public OrderVO abnormalOrderDetail(String ID);
	
}
