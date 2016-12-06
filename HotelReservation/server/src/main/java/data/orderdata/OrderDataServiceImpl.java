package data.orderdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.print.attribute.standard.RequestingUserName;

import data.hoteldata.RoomInfoDataServiceImpl;
import data.userdata.CustomerManagementDataServiceImpl;
import dataSuper.DataServiceHelper;
import dataSuper.DataSuperClass;
import dataservice.orderdataservice.OrderDataService;
import po.OrderPO;
import util.OrderState;
import util.ResultMsg;

public class OrderDataServiceImpl extends DataSuperClass implements OrderDataService{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String tableName = "order";
	
	public OrderDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ResultMsg insert(OrderPO po) throws RemoteException {
		return addToSQL(tableName, po.getOrderID(),po.getInitiator().getUserID(),
				po.getOrderState().toString(),""+po.getPrice(),po.getHotelID(),
				""+po.getHasChild(),po.getLatestExecutionTime(),po.getCheckInTime(),
				po.getCheckOutTime(),po.getCancelledTime(),""+po.getRoomNumber(),
				""+po.getPeopleNumber(),po.getRoomInfoPO().getRoomID(),
				""+po.getPass(),po.getReason());
	}

	@Override
	public ResultMsg delete(String ID) throws RemoteException {
		return delFromSQL(tableName, ID);
	}

	@Override
	public ResultMsg update(OrderPO po) throws RemoteException {
		return modifyFromSQL(tableName, po.getOrderID(),po.getInitiator().getUserID(),
				po.getOrderState().toString(),""+po.getPrice(),po.getHotelID(),
				""+po.getHasChild(),po.getLatestExecutionTime(),po.getCheckInTime(),
				po.getCheckOutTime(),po.getCancelledTime(),""+po.getRoomNumber(),
				""+po.getPeopleNumber(),po.getRoomInfoPO().getRoomID(),
				""+po.getPass(),po.getReason());
	}

	@Override
	public OrderPO findByOrderID(String ID) throws RemoteException {
		OrderPO orderPO = getMsg(ID);
		if(orderPO == null){
			return null;
		}
		return orderPO;
	}

	@Override
	public ArrayList<OrderPO> findByUserID(String ID) throws RemoteException {
		
		return null;
	}

	@Override
	public ArrayList<OrderPO> findByHotelID(String ID) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<OrderPO> showList() throws RemoteException {
		return null;
	}
	
	private OrderPO getMsg(String ID) throws RemoteException{
		findMes = findFromSQL(tableName,ID);
		OrderPO orderPO = null;
		CustomerManagementDataServiceImpl customer = new CustomerManagementDataServiceImpl();
		RoomInfoDataServiceImpl room = new RoomInfoDataServiceImpl();
		if(findMes != null){
			orderPO = new OrderPO(findMes.get(0), null/*ÐèÒª·µ»Øcustomerinfo*/, 
								OrderState.valueOf(findMes.get(2)),
								Double.valueOf(findMes.get(3)), findMes.get(4), 
								Boolean.getBoolean(findMes.get(5)), findMes.get(6), 
								findMes.get(7), findMes.get(8), findMes.get(9), 
								Integer.getInteger(findMes.get(10)),Integer.getInteger(findMes.get(11)),
								room.findByRoomID(findMes.get(12)));
		}
		
		if(findMes != null && findMes.get(14) != null){
			orderPO = new OrderPO(orderPO, findMes.get(14));
		}
		
		if(findMes !=null && findMes.get(13) != null){
			orderPO = new OrderPO(orderPO, Boolean.getBoolean(findMes.get(13)));
		}
		
		return orderPO;
	}

	
}

