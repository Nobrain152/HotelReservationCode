package blservice.orderblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.ResultMsg;
import vo.OrderVO;

/**
 * ��վӪ����Ա�鿴�����б������鿴һ�������б�����
 * 
 * @author txin15
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
	
	/**
	 * ��վӪ����Ա�����쳣����
	 * 
	 * @param ID
	 * @param b
	 * @return
	 */
	public ResultMsg abnormalOrderCancel(String ID,boolean b);
	
}
