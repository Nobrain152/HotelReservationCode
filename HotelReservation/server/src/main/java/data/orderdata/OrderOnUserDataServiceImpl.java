package data.orderdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.OrderOnUserPO;
import util.User;

public class OrderOnUserDataServiceImpl {

	ArrayList<OrderOnUserPO> userPOs;
	
	public OrderOnUserDataServiceImpl(){
		userPOs = new ArrayList<>();
	}
	
	
	/**
	 * �����ݿ��в��뵥һ�־û�����
	 */
	public boolean insert(OrderOnUserPO po) throws RemoteException{
		if(userPOs.add(po))
			return true;
		else
			return false;
	}
	
	
	/**
	 * �����ݿ���ɾ����һ�־û�����
	 */
	public boolean delete(OrderOnUserPO po) throws RemoteException{
		if(userPOs.remove(po))
			return true;
		else
			return false;
	}
	
	
	/**
	 * �����ݿ��и��µ�һ�־û�����
	 */
	public boolean update(OrderOnUserPO po) throws RemoteException{
		for (OrderOnUserPO op : userPOs) {
			if(op.getInitiator() == po.getInitiator()){
				op = po;
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * ��������Ϣ���в��ҷ�����Ӧ��OrderOnUserPO���
	 */
	public ArrayList<OrderOnUserPO> find(User initiator) throws RemoteException{
		ArrayList<OrderOnUserPO> arrayList = new ArrayList<OrderOnUserPO>();
		for (OrderOnUserPO op : userPOs) {
			if(op.getInitiator().getName().equals(initiator.getName())){
				arrayList.add(op);
			}
		}
		return arrayList;
	}
	
	
	/**
	 * �������оƵ궩��PO
	 */
	public ArrayList<OrderOnUserPO> show() throws RemoteException{
		return userPOs;
	}
	
}

