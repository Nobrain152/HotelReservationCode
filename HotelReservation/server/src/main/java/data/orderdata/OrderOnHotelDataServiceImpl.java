package data.orderdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.OrderOnHotelPO;
import util.User;

public class OrderOnHotelDataServiceImpl {

	ArrayList<OrderOnHotelPO> hotelPOs;
	
	public OrderOnHotelDataServiceImpl(){
		hotelPOs = new ArrayList<>();
	}
	
	
	/**
	 * �����ݿ��в��뵥һ�־û�����
	 */
	public boolean insert(OrderOnHotelPO po) throws RemoteException{
		if(hotelPOs.add(po))
			return true;
		else
			return false;
	}
	
	
	/**
	 * �����ݿ���ɾ����һ�־û�����
	 */
	public boolean delete(OrderOnHotelPO po) throws RemoteException{
		if(hotelPOs.remove(po))
			return true;
		else
			return false;
	}
	
	
	/**
	 * �����ݿ��и��µ�һ�־û�����
	 */
	public boolean update(OrderOnHotelPO po) throws RemoteException{
		for (OrderOnHotelPO op : hotelPOs) {
			if(op.getInitiator() == po.getInitiator()){
				op = po;
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * ��������Ϣ���в��ҷ�����Ӧ��OrderOnHotelPO���
	 */
	public ArrayList<OrderOnHotelPO> find(User initiator) throws RemoteException{
		ArrayList<OrderOnHotelPO> arrayList = new ArrayList<OrderOnHotelPO>();
		for (OrderOnHotelPO op : hotelPOs) {
			if(op.getInitiator().getName().equals(initiator.getName())){
				arrayList.add(op);
			}
		}
		return arrayList;
	}
	
	
	/**
	 * �������оƵ궩��PO
	 */
	public ArrayList<OrderOnHotelPO> show() throws RemoteException{
		return hotelPOs;
	}
	
}
