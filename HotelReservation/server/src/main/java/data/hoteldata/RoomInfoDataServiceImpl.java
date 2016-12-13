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
	
	/**
	 * �ӿ�д�������⣬��ʱ���ã��ȷ�������Ȳ�д
	 */
	@Override
	public ResultMsg delete(String hotelid, String roomid) throws RemoteException {
		sql = "DELETE FROM " + tableName + " WHERE roomID = \'" + roomid +
				"\' AND hotelID = \'" + hotelid+"\'";
		ResultMsg a = delete(sql);
		return a;
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
	
	
	private ResultMsg delete(String sql){
		try {
			preState = conn.prepareStatement(sql);
			affectRows = preState.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�޷��������ݿ�");
			return ResultMsg.FAIL;
		}
		
		if(affectRows != 1){
			System.out.println("��ǰ���ݿ���Ӱ�������Ϊ"+affectRows);
			System.out.println("�����ݿ��������Ϣ�����ڻ��ߴ��ڶ����޷���λɾ������"+tableName+"����");
			return ResultMsg.NOT_EXIST;
		}
		
		return ResultMsg.SUCCESS;
	}
	


}