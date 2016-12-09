package data.hoteldata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import dataSuper.DataSuperClass;
import dataservice.hoteldataservice.RoomInfoDataService;
import po.RoomInfoPO;
import util.ResultMsg;
import util.RoomState;
import util.RoomType;

public class RoomInfoDataServiceImpl extends DataSuperClass implements RoomInfoDataService{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RoomInfoDataServiceImpl() throws RemoteException {
		super();
	}
	
	private final String tableName = "roomInfo";

	@Override
	public ResultMsg insert(RoomInfoPO po) throws RemoteException {
		return addToSQL(tableName, po.getState().toString(),po.getType().toString(),
						po.getRoomID(),""+po.getPrice(),po.getHotelid());
	}

	@Override
	public ResultMsg delete(RoomInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg update(RoomInfoPO po) throws RemoteException {
		return modifyFromSQL(tableName, po.getState().toString(),po.getType().toString(),
						po.getRoomID(),""+po.getPrice(),po.getHotelid());
	}

	@Override
	public RoomInfoPO findByRoomID(String id) throws RemoteException {
		sql =  "SELECT * FROM " + tableName  + " WHERE roomID = \'" + id + "\'";
		return findMsg(sql);
	}

	@Override
	public ArrayList<RoomInfoPO> show() throws RemoteException {
		sql = "SELECT * FROM " + tableName;
		return findMsgs(sql);
	}

	@Override
	public ArrayList<RoomInfoPO> HotelRoomSearch(String hotelID) throws RemoteException {
		sql =  "SELECT * FROM " + tableName  + " WHERE hotelID = \'" + hotelID + "\'";
		return findMsgs(sql);
	}

	@Override
	public ResultMsg HotelRoomMod(String hotelid, ArrayList<RoomInfoPO> po) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private RoomInfoPO findMsg(String sql) throws RemoteException{
		RoomInfoPO po = null;
		try {
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			po = new RoomInfoPO(RoomState.valueOf(result.getString(1)),
								RoomType.valueOf(result.getString(2)),
								result.getString(3), Double.valueOf(result.getString(4)), 
								result.getString(5));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return po;
	}
	
	private ArrayList<RoomInfoPO> findMsgs(String sql) throws RemoteException{
		ArrayList<RoomInfoPO> pos = new ArrayList<RoomInfoPO>();
		try {
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				pos.add(new RoomInfoPO(RoomState.valueOf(result.getString(1)),
						RoomType.valueOf(result.getString(2)),
						result.getString(3), Double.valueOf(result.getString(4)), 
						result.getString(5)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pos;
	}


}