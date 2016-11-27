package dataSuper;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import util.ResultMsg;

/**
 * 所有数据层实现的父类
 * @author T5-SK
 *
 */

public class DataSuperClass extends UnicastRemoteObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 与数据库的连接
	 */
	protected Connection conn;
	/**
	 * 
	 */
	protected PreparedStatement preState;
	/**
	 * 数据库语句
	 */
	protected String sql;
	/**
	 * 数据库操作影响结果集
	 */
	protected ResultSet result;
	/**
	 * 查找返回的消息
	 */
	protected ArrayList<String> findMes;
	/**
	 * 在数据库操作中影响到的行数（信息条数）
	 */
	protected int affectRows;
	/**
	 * 
	 */
	protected static DataServiceHelper helper = new DataServiceHelper();
	
	private static final Map<String, ArrayList<String>> SQLmap = new HashMap<String, ArrayList<String>>(50);
	
	static{
		//根据PO写，先写别的部分，成功之后回来补充即可
		SQLmap.put("customer", helper.bulidSQL("customer", 7, "userid","username","contact","isMember","credit","order","hotel"));
		//SQLmap.put("HotelCondition",helper.bulidSQL("HotelCondition", 10, "address","businessDistrict","hotelName","roomtype","upLevel",""));
		SQLmap.put("credit", helper.bulidSQL("credit", 2, "userID","credit"));
		SQLmap.put("customerInfo", helper.bulidSQL("customerInfo", 2, "cresit","isMember"));
	}
	
	public DataSuperClass() throws RemoteException {
		this.conn = DataBaseInit.getConnection();
		System.out.println("succeed to bulid dataservice");
	}
	
	/**
	 * 向数据库中增加一条数据
	 * @param tableName 表的名字
	 * @param paras 可变参数列表
	 * @return
	 */
	protected ResultMsg addToSQL(String tableName , String... paras) {
		try {
			int paralen = Integer.parseInt(SQLmap.get(tableName).get(0));
			preState = conn.prepareStatement(SQLmap.get(tableName).get(1));
			for (int i = 0; i < paralen; i++) {
				preState.setString(i + 1, paras[i]);
			}
			affectRows = preState.executeUpdate();
		} /*catch(MySQLIntegrityConstraintViolationException e){
			return ResultMsg.hasExist;
			//这个异常捕获不了？不存在
		} */catch (SQLException e) {
			e.printStackTrace();
			return ResultMsg.FAIL;
		}
		
		if(affectRows == 0){
			return ResultMsg.FAIL;
		}
		
		return ResultMsg.SUCCESS;
	}
}
