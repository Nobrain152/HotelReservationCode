package blservice.orderblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.ResultMsg;
import vo.OrderVO;

/**
 * �ͻ���ѯ���˶�����Ϣ�����飬ִ�ж����ĳ���
 * 
 * @author txin
 *
 */
public interface OrderOnUserBLService {
	
	/**
	 * �ͻ��鿴���˶�����Ϣ
	 *
	 * @param void
	 * @return ���˶����б�
	 */
	public ArrayList<OrderVO> personalOrderScan(String ID);
	
	/**
	 * �ͻ���������
	 *
	 * @param ���˶���
	 * @return void
	 * @throws RemoteException 
	 */
	public void createOrder(OrderVO orderVO);
	
	/**
	 * �ͻ��������˶���
	 *
	 * @param orderVO ����VO
	 * @return ϵͳ��ʾ��Ϣ
	 */
	public ResultMsg personalOrderCancel(OrderVO orderVO);
	
	/**
	 * �ͻ��鿴���˶�������
	 *
	 * @param OrderVO ����VO
	 * @return ���˶�������
	 */
	public OrderVO personalOrderDetail(String ID);
	
}
