package data.vipdata;

import java.awt.Window.Type;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;


import dataSuper.DataSuperClass;
import dataservice.vipdataservice.VipDataService;
import po.BusinessVipPO;
import po.CommonVipPO;
import po.CustomerInfoPO;
import po.LevelSystemPO;
import po.RoomInfoPO;
import po.CustomerInfoPO;
import util.ResultMsg;
import util.RoomState;
import util.RoomType;
import util.VipType;

public class VipDataSerivceImpl extends DataSuperClass implements VipDataService{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VipDataSerivceImpl() throws RemoteException {
		super();
	}
	
	private final String tableName = "commonVip";
	private final String tableName2 = "businessVip";
	
	@Override
	public ResultMsg insertC(CommonVipPO vip) throws RemoteException {
		return addToSQL(tableName, vip.getUserID(),vip.getUsername(),
								vip.getPassword(),vip.getContact(),
								""+vip.getCredit(),vip.getBirthday(),
								vip.getVipType().toString());
	}

	@Override
	public ResultMsg delete(String userid) throws RemoteException {
		return delFromSQL(tableName, userid);
	}

	@Override
	public ResultMsg updateC(CommonVipPO vip) throws RemoteException {
		return modifyFromSQL(tableName, vip.getUserID(),vip.getUsername(),
								vip.getPassword(),vip.getContact(),
								""+vip.getCredit(),vip.getBirthday(),
								vip.getVipType().toString());
	}


	@Override
	public CommonVipPO findByUserIDC(String id) throws RemoteException {
		sql = "SELECT * FROM " + tableName  + " WHERE userID = \'" + id + "\'";
		CommonVipPO po = findMsgC(sql);
		return po;
	}

	@Override
	public ArrayList<CommonVipPO> showC(Type type) throws RemoteException {
		sql = "SELECT * FROM " + tableName;
		ArrayList<CommonVipPO> pos = findMsgCs(sql);
		return pos;
	}

	@Override
	public ResultMsg insertB(BusinessVipPO vip) throws RemoteException {
		return addToSQL(tableName2, vip.getUserID(),vip.getUsername(),
							vip.getPassword(),vip.getContact(),
							""+vip.getCredit(),vip.getBusinessName(),
							vip.getVipType().toString());
	}

	@Override
	public ResultMsg updateB(BusinessVipPO vip) throws RemoteException {
		return modifyFromSQL(tableName2, vip.getUserID(),vip.getUsername(),
							vip.getPassword(),vip.getContact(),
							""+vip.getCredit(),vip.getBusinessName(),
							vip.getVipType().toString());
	}

	@Override
	public BusinessVipPO findByUserIDB(String id) throws RemoteException {
		sql = "SELECT * FROM " + tableName2  + " WHERE userID = \'" + id + "\'";
		BusinessVipPO po = findMsgB(sql);
		return po;
	}

	@Override
	public ArrayList<BusinessVipPO> showB(Type type) throws RemoteException {
		sql = "SELECT * FROM " + tableName2;
		ArrayList<BusinessVipPO> pos = findMsgBs(sql);
		return pos;
	}

	@Override
	public ResultMsg update(LevelSystemPO levelSystemPO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LevelSystemPO getLevelSystemPO() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private CommonVipPO findMsgC(String sql) throws RemoteException{
		CommonVipPO po = null;
		try {
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			po = new CommonVipPO(result.getString(1), result.getString(2), 
								result.getString(3), result.getString(4),
								Integer.valueOf(result.getString(5)), 
								result.getString(6), 
								VipType.valueOf(result.getString(7)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return po;
	}
	
	private BusinessVipPO findMsgB(String sql) throws RemoteException{
		BusinessVipPO po = null;
		try {
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			po = new BusinessVipPO(result.getString(1), result.getString(2), 
								result.getString(3), result.getString(4),
								Integer.valueOf(result.getString(5)), 
								result.getString(6), 
								VipType.valueOf(result.getString(7)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return po;
	}
	
	private ArrayList<CommonVipPO> findMsgCs(String sql) throws RemoteException{
		ArrayList<CommonVipPO> pos = new ArrayList<CommonVipPO>();
		try {
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while(result.next()){
				pos.add(new CommonVipPO(result.getString(1), result.getString(2), 
								result.getString(3), result.getString(4),
								Integer.valueOf(result.getString(5)), 
								result.getString(6), 
								VipType.valueOf(result.getString(7))));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pos;
	}
	
	private  ArrayList<BusinessVipPO> findMsgBs(String sql) throws RemoteException{
		ArrayList<BusinessVipPO> pos = new ArrayList<BusinessVipPO>();
		try {
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			pos.add(new BusinessVipPO(result.getString(1), result.getString(2), 
								result.getString(3), result.getString(4),
								Integer.valueOf(result.getString(5)), 
								result.getString(6), 
								VipType.valueOf(result.getString(7))));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pos;
	}

	
}
