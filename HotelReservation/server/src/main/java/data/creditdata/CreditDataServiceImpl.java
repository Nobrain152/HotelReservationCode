package data.creditdata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import dataSuper.DataSuperClass;
import dataservice.creditdataservice.CreditDataService;
import po.CreditPO;
import util.Action;
import util.ResultMsg;

public class CreditDataServiceImpl extends DataSuperClass implements CreditDataService{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String tableName = "credit";
	
	public CreditDataServiceImpl() throws RemoteException{
		super();
	}
	
	
	
	@Override
	public ResultMsg insert(CreditPO creditPO) throws RemoteException {
		return addToSQL(tableName, creditPO.getUserID(),creditPO.getOrderID(),
				creditPO.getTime(),creditPO.getAction().toString(),
				creditPO.getCreditChange(),""+creditPO.getCreditResult());
	}

	@Override
	public ArrayList<CreditPO> getListByUserID(String userID) throws RemoteException {
		ArrayList<CreditPO> pos = new ArrayList<CreditPO>(50);
		
		try {
			sql = "SELECT userID FROM " + tableName ;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			
			while (result.next()) {
				if(result.getString(1) == userID){
					pos.add(new CreditPO(result.getString(1), result.getString(2),
							result.getString(3), Action.valueOf(result.getString(4)),
							result.getString(5), 
							Integer.getInteger(result.getString(6))));
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("信用信息从数据库中查找出错");
		}
		
		return pos.size()==0?null:pos;
	}



	@Override
	public ArrayList<CreditPO> show() throws RemoteException {
		ArrayList<CreditPO> pos = new ArrayList<CreditPO>(50);
		
		try {
			sql = "SELECT * FROM " + tableName ;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			
			while (result.next()) {
				pos.add(new CreditPO(result.getString(1), result.getString(2),
							result.getString(3), Action.valueOf(result.getString(4)),
							result.getString(5), 
							Integer.getInteger(result.getString(6))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("信用信息从数据库中查找出错");
		}
		return pos.size()==0?null:pos;
	}

	@Override
	public CreditPO getListByOrderID(String orderID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
