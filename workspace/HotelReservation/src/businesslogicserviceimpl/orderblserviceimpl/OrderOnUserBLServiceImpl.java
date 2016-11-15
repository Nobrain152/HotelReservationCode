package businesslogicserviceimpl.orderblserviceimpl;

import businesslogic.util.OrderOnUserMsg;
import businesslogic.util.OrderState;
import businesslogic.util.ResultMsg;
import vo.OrderOnUserVO;

import java.util.ArrayList;

public class OrderOnUserBLServiceImpl {
	
	ArrayList<OrderOnUserVO> userList;
	
	public OrderOnUserBLServiceImpl() {
		userList = new ArrayList<OrderOnUserVO>();
	}
	/**
	 * �ͻ��鿴���˶�����Ϣ
	 *
	 * @param void
	 * @return ���˶����б�
	 */
	public ArrayList<OrderOnUserVO> personalOrderScan() {
		return userList;
	}
	
	/**
	 * �ͻ���������
	 *
	 * @param ���˶���
	 * @return void
	 */
	public void createOrder(OrderOnUserVO order) {
		userList.add(order);
	}
	
	/**
	 * �ͻ��������˶���
	 *
	 * @param order ����
	 * @return ϵͳ��ʾ��Ϣ
	 */
	public ResultMsg personalOrderCancel(OrderOnUserVO order) {
		if(order.getOrderState() == OrderState.UNEXECUTED)
			return new ResultMsg(true, "�����ɹ�!");
		else if(order.getOrderState() == OrderState.CANCELLED)
			return new ResultMsg(false, "�����ظ�������");
		else if(order.getOrderState() == OrderState.EXECUTED)
			return new ResultMsg(false, "�ö����Ѿ�ִ�У����ɳ�����");
		else
			return new ResultMsg(false, "�쳣���������ɳ�����");
	}
	
	/**
	 * �ͻ��鿴���˶�������
	 *
	 * @param void
	 * @return ���˶�������
	 */
	public OrderOnUserMsg personalOrderDetail(OrderOnUserVO order) {
		return new OrderOnUserMsg(order.getInitiator(), order.getOrderID(),order.getOrderState(), order.getPrice(), order.getLatestExecutionTime(), 
				order.getRoomType(), order.getRoomNumber(), order.getPeopleNumber(), order.getHasChild());
	}

}