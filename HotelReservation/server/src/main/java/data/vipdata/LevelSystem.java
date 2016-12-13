package data.vipdata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import dataSuper.DataSuperClass;
import po.LevelSystemPO;
import util.ResultMsg;

public class LevelSystem extends DataSuperClass{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LevelSystem() throws RemoteException {
		super();
	}
	
	private final String tableName = "LevelSystem";
	
	public ResultMsg insert(LevelSystemPO po) throws RemoteException{
		ResultMsg a ;
		a = addToSQL(tableName, ""+po.getLevels(), ""+po.getCredits());
		return a;
	}
	
	public ResultMsg updata(LevelSystemPO po) {
		ResultMsg a;
		a = modifyFromSQL(tableName, ""+po.getLevels(),""+po.getCredits());
		return a;
	}
	
	public ArrayList<LevelSystemPO> show() {
		ArrayList<LevelSystemPO> pos = new ArrayList<LevelSystemPO>();
		LevelSystemPO po = null;
		sql = "SELECT * FROM " + tableName;
		try {
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while(result.next()){
				po = new LevelSystemPO(Integer.valueOf(result.getString(1)), 
										Integer.valueOf(result.getString(2)));
				pos.add(po);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pos;
	}
	
}
