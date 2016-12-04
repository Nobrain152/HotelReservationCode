package blservice.orderblservice;

import java.util.ArrayList;

import util.ResultMsg;
import vo.OrderVO;

/**
 * ��վӪ����Ա�鿴�����б������鿴һ�������б�����
 * 
 * @author txin
 *
 */
public interface OrderOnWebBLService {
	
	/**
	 * ��վӪ����Ա�鿴�����б�
	 *
	 * @param void
	 * @return �����б�
	 */
	public ArrayList<OrderVO> complaintListScan();
	
	/**
	 * ��վӪ����Ա��������
	 *
	 * @param orderVO ����VO
	 * @return ϵͳ��ʾ��Ϣ
	 */
	public ResultMsg complaintHandle(OrderVO orderVO,double rate);
	
	/**
	 * ��վӪ����Ա�鿴�쳣�����б�
	 *
	 * @param void
	 * @return �쳣�����б�
	 */
	public ArrayList<OrderVO> abnormalOrderScan();
	
	/**
	 * ��վӪ����Ա�鿴�쳣��������
	 *
	 * @param orderVO ����VO
	 * @return ���˶�������
	 */
	public OrderVO abnormalOrderDetail(String ID);
	
}
