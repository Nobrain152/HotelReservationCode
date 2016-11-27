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
 * �������ݲ�ʵ�ֵĸ���
 * @author T5-SK
 *
 */

public class DataSuperClass extends UnicastRemoteObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * �����ݿ������
	 */
	protected Connection conn;
	/**
	 * 
	 */
	protected PreparedStatement preState;
	/**
	 * ���ݿ����
	 */
	protected String sql;
	/**
	 * ���ݿ����Ӱ������
	 */
	protected ResultSet result;
	/**
	 * ���ҷ��ص���Ϣ
	 */
	protected ArrayList<String> findMes;
	/**
	 * �����ݿ������Ӱ�쵽����������Ϣ������
	 */
	protected int affectRows;
	/**
	 * 
	 */
	protected static DataServiceHelper helper = new DataServiceHelper();
	
	private static final Map<String, ArrayList<String>> SQLmap = new HashMap<String, ArrayList<String>>(50);
	
	static{
		//����POд����д��Ĳ��֣��ɹ�֮��������伴��
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
	 * �����ݿ�������һ������
	 * @param tableName �������
	 * @param paras �ɱ�����б�
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
			//����쳣�����ˣ�������
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
