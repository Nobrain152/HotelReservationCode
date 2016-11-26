package blservice.orderblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.ResultMsg;
import vo.OrderOnUserVO;

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
	public ArrayList<OrderOnUserVO> personalOrderScan();
	
	/**
	 * �ͻ���������
	 *
	 * @param ���˶���
	 * @return void
	 * @throws RemoteException 
	 */
	public void createOrder(OrderOnUserVO orderVO);
	
	/**
	 * �ͻ��������˶���
	 *
	 * @param orderVO ����VO
	 * @return ϵͳ��ʾ��Ϣ
	 */
	public ResultMsg personalOrderCancel(OrderOnUserVO orderVO);
	
	/**
	 * �ͻ��鿴���˶�������
	 *
	 * @param OrderOnUserVO ����VO
	 * @return ���˶�������
	 */
	public OrderOnUserVO personalOrderDetail(String ID);
	
}
