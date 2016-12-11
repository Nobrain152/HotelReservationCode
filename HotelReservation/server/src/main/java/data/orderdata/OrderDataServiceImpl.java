package data.orderdata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import data.hoteldata.RoomInfoDataServiceImpl;
import data.userdata.CustomerManagementDataServiceImpl;
import dataSuper.DataSuperClass;
import datafactory.DataFactory;
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
	}
	
	@Override
	public ResultMsg insert(OrderPO po) throws RemoteException {
		return addToSQL(tableName, po.getOrderID(),po.getInitiator().getUserID(),
				po.getOrderState().toString(),""+po.getPrice(),po.getHotelID(),
				""+po.getHasChild(),po.getLatestExecutionTime(),po.getCheckInTime(),
				po.getCheckOutTime(),po.getCancelledTime(),""+po.getRoomNumber(),
				""+po.getPeopleNumber(),po.getRoomInfoPO().getRoomID());
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
				""+po.getPeopleNumber(),po.getRoomInfoPO().getRoomID());
	}

	@Override
	public OrderPO findByOrderID(String ID) throws RemoteException {
		OrderPO orderPO = getMsg(ID);
		if(orderPO == null){
			return null;
		}
		return orderPO;
	}
	
	
	
	//抽象出来
	@Override
	//没有userID信息
	public ArrayList<OrderPO> findByUserID(String ID) throws RemoteException {
		ArrayList<OrderPO> pos = new ArrayList<OrderPO>(50);
		OrderPO orderPO = null;
		
		try {
			sql = "SELECT * FROM " + tableName + " WHERE orderID = \'" + ID + "\'";
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			CustomerManagementDataServiceImpl customer = (CustomerManagementDataServiceImpl) DataFactory.getDataFactory().getCustomerManagementDataServiceImpl();
			RoomInfoDataServiceImpl room = (RoomInfoDataServiceImpl) DataFactory.getDataFactory().getRoomInfoDataServiceImpl();
			
			while (result.next()) {
					orderPO = new OrderPO(result.getString(1), 
							customer.GetCustomerInfo(result.getString(2)), 
							OrderState.valueOf(result.getString(3)),
							Double.valueOf(result.getString(4)), result.getString(5), 
							Boolean.valueOf(result.getString(6)), result.getString(7), 
							result.getString(8), result.getString(9), 
							result.getString(10),
							Integer.getInteger(result.getString(11)),
							Integer.getInteger(result.getString(12)),
							room.findByRoomID(result.getString(13)));
					pos.add(orderPO);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("订单信息从数据库中查找出错");
		}
		
		return pos.size()==0?null:pos;
	}

	@Override
	public ArrayList<OrderPO> findByHotelID(String ID) throws RemoteException {
		
		return null;
	}

	@Override
	public ArrayList<OrderPO> showList() throws RemoteException {
		ArrayList<OrderPO> pos = new ArrayList<OrderPO>(50);
		CustomerManagementDataServiceImpl customer = (CustomerManagementDataServiceImpl) DataFactory.getDataFactory().getCustomerManagementDataServiceImpl();
		RoomInfoDataServiceImpl room = (RoomInfoDataServiceImpl) DataFactory.getDataFactory().getRoomInfoDataServiceImpl();
		OrderPO orderPO = null;
		
		try {
			sql = "SELECT * FROM " + tableName ;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			
			while (result.next()) {
					orderPO = new OrderPO(result.getString(1), 
							customer.GetCustomerInfo(result.getString(2))/*需要返回customerinfo*/, 
							OrderState.valueOf(result.getString(3)),
							Double.valueOf(result.getString(4)), result.getString(5), 
							Boolean.valueOf(result.getString(6)), result.getString(7), 
							result.getString(8), result.getString(9), 
							result.getString(10),
							Integer.getInteger(result.getString(11)),
							Integer.getInteger(result.getString(12)),
							room.findByRoomID(result.getString(13)));
					pos.add(orderPO);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("订单信息从数据库中查找出错");
		}
		
		return pos.size()==0?null:pos;
		
	}
	
	private OrderPO getMsg(String ID) throws RemoteException{
		findMes = findFromSQL(tableName,ID);
		OrderPO orderPO = null;
		CustomerManagementDataServiceImpl customer = new CustomerManagementDataServiceImpl();
		RoomInfoDataServiceImpl room = new RoomInfoDataServiceImpl();
		if(findMes != null){
			
			orderPO = new OrderPO(findMes.get(0), 
								customer.GetCustomerInfo(findMes.get(1))/*需要返回customerinfo*/, 
								OrderState.valueOf(findMes.get(2)),
								Double.valueOf(findMes.get(3)), findMes.get(4), 
								Boolean.valueOf(findMes.get(5)), findMes.get(6), 
								findMes.get(7), findMes.get(8), findMes.get(9), 
								Integer.getInteger(findMes.get(10)),Integer.getInteger(findMes.get(11)),
								room.findByRoomID(findMes.get(12)));
		}
		return orderPO;
	}

	
}

