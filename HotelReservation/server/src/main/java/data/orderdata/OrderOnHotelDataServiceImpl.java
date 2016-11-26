package data.orderdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.orderdataservice.OrderOnHotelDataService;
import po.OrderOnHotelPO;
import util.ResultMsg;

public class OrderOnHotelDataServiceImpl implements OrderOnHotelDataService{

	ArrayList<OrderOnHotelPO> hotelPOs;
	
	public OrderOnHotelDataServiceImpl(){
		hotelPOs = new ArrayList<OrderOnHotelPO>();
	}
	
	/**
	 * �����ݿ��в��뵥һ�־û�����
	 */
	public ResultMsg insert(OrderOnHotelPO po) throws RemoteException{
		if(hotelPOs.add(po))
			return ResultMsg.SUCCESS;
		else
			return ResultMsg.FAIL;
	}
	
	
	/**
	 * �����ݿ���ɾ����һ�־û�����
	 */
	public ResultMsg delete(OrderOnHotelPO po) throws RemoteException{
		if(hotelPOs.remove(po))
			return ResultMsg.SUCCESS;
		else
			return ResultMsg.FAIL;
	}
	
	
	/**
	 * �����ݿ��и��µ�һ�־û�����
	 */
	public ResultMsg update(OrderOnHotelPO po) throws RemoteException{
		for (OrderOnHotelPO op : hotelPOs) {
			if(op.getInitiator() == po.getInitiator()){
				op = po;
				return ResultMsg.SUCCESS;
			}
		}
		return ResultMsg.FAIL;
	}
	
	
	/**
	 * ��������Ϣ���в��ҷ�����Ӧ��OrderOnHotelPO���
	 */
	public ArrayList<OrderOnHotelPO> findByName(String name) throws RemoteException{
		ArrayList<OrderOnHotelPO> arrayList = new ArrayList<OrderOnHotelPO>();
		for (OrderOnHotelPO op : hotelPOs) {
			if(op.getInitiator().getName().equals(name)){
				arrayList.add(op);
			}
		}
		return arrayList;
	}
	
	
	/**
	 * �������оƵ궩��PO
	 */
	public ArrayList<OrderOnHotelPO> getTotalHotelOrderList() throws RemoteException{
		return hotelPOs;
	}


	@Override
	public OrderOnHotelPO findByID(String ID) throws RemoteException {
		OrderOnHotelPO hotelPO = null;
		for (OrderOnHotelPO op : hotelPOs) {
			if(op.getOrderID().equals(ID)){
				hotelPO = op;
			}
		}
		return hotelPO;
	}

	
}
