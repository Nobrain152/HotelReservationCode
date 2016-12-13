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

import util.MyDate;
import util.OrderState;
import util.ResultMsg;






/**
 * �������ݲ�ʵ�ֵĸ���
 * @author T5-SK
 *
 */

public class DataSuperClass extends UnicastRemoteObject{
	
	/**
	 * ���л�
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
		SQLmap.put("createID", helper.bulidSQL("createID", 4, "customerID","hotelStuffID","webStuffID","webManagerID"));
		SQLmap.put("credit", helper.bulidSQL("credit",6, "userID","orderID","time","action","creditChange","creditResult"));
		SQLmap.put("hotelEvaluate", helper.bulidSQL("hotelEvaluate", 6, "userID","hotelID","score","comment","reserve","orderID"));
		SQLmap.put("hotelInfo", helper.bulidSQL("hotelInfo", 10, "hotelID","name","address","area","level","introduction","facility","reserve","score","SP"));
		SQLmap.put("roomInfo", helper.bulidSQL("roomInfo", 5, "state","type","roomID","price","hotelID"));
		SQLmap.put("order", helper.bulidSQL("order", 13, "orderID","customerInfoPO","orderState","price","hotelID","hasChild","latestExecutionTime","checkInTime","checkOutTime","cancelledTime","roomNumber","peopleNumber","roomInfoPO"));
		SQLmap.put("promiotionHotel", helper.bulidSQL("promotionHotel", 9, "hotelID","promotionHotelType","customType","beginTime","endTime","ratio","level","number","businessName"));
		SQLmap.put("promiotionWeb", helper.bulidSQL("promotionWeb", 7, "promotionWebType","customType","beginTime","endTime","ratio","level","location"));
		SQLmap.put("contact", helper.bulidSQL("contact", 2, "phoneNumber","emailAddress"));
		SQLmap.put("customer", helper.bulidSQL("customer", 7, "userid","username","contact","isMember","credit","order","hotel"));
		SQLmap.put("loginIn", helper.bulidSQL("loginIn", 2, "username","password"));
		SQLmap.put("userInfo", helper.bulidSQL("userInfo", 3, "userID","username","contact"));
		SQLmap.put("levelSystem", helper.bulidSQL("LevelSystem", 2, "levels","credits"));
		SQLmap.put("customerInfo", helper.bulidSQL("customerInfo", 6, "userID","username","contact","credit","isMember","vipType"));
		SQLmap.put("commonVip", helper.bulidSQL("commonVip", 7, "userID","username","password","contact","credit","birthday","vipType"));
		SQLmap.put("businessVip", helper.bulidSQL("businessVip", 7, "userID","username","password","contact","credit","businessName","vipType"));
		
		
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
		}*/ catch (SQLException e) {
			e.printStackTrace();
			return ResultMsg.FAIL;
		}
		
		if(affectRows == 0){
			return ResultMsg.FAIL;
		}
		
		return ResultMsg.SUCCESS;
	}
	
	/**
	 * �����ݿ���ɾ��һ������
	 * @param tableName �������
	 * @param ID Ҫɾ�����ݵ�ID
	 * @return
	 */
	protected ResultMsg delFromSQL(String tableName , String ID) {
		try {
			preState = conn.prepareStatement(SQLmap.get(tableName).get(2) +"\"" + ID + "\"");
			affectRows = preState.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�޷��������ݿ�");
			return ResultMsg.FAIL;
		}
		
		if(affectRows != 1){
			System.out.println("��ǰ���ݿ���Ӱ�������Ϊ"+affectRows);
			System.out.println("�����ݿ��������Ϣ�����ڻ��ߴ��ڶ����޷���λɾ������"+tableName+"���У�IDΪ" + ID);
			return ResultMsg.NOT_EXIST;
		}
		
		return ResultMsg.SUCCESS;
	}
	
	/**
	 * �����ݿ��в���һ����Ϣ
	 * @param tableName �������
	 * @param ID Ҫ�������ݵ�ID
	 * @return �Ҳ����·���null�����򷵻�PO��������Ϣ
	 */
	protected ArrayList<String> findFromSQL(String tableName, String ID) {
		try {
			preState = conn.prepareStatement(SQLmap.get(tableName).get(3) + "\""+ ID + "\"");
			result = preState.executeQuery();
			if(result.next()) {
				// ������ҵ���Ӧ��ID
				int paralen = Integer.parseInt(SQLmap.get(tableName).get(0));
				ArrayList<String> temp = new ArrayList<String>(paralen);
				for (int i = 0; i < paralen; i++) {
					temp.add(result.getString(i + 1));
				}
				return temp;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}
	
	/**
	 * ����û��ID��SQL����
	 * @param tableName
	 * @return
	 */
	protected ArrayList<String> findFromSQL(String tableName){
		ArrayList<String> temp = new ArrayList<String>();
		try {
			preState = conn.prepareStatement(SQLmap.get(tableName).get(3));
			result = preState.executeQuery();
			while(result.next()) {
				int paralen = Integer.parseInt(SQLmap.get(tableName).get(0));
				temp = new ArrayList<String>(paralen);
				for (int i = 0; i < paralen; i++) {
					temp.add(result.getString(i + 1));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(temp.size() == 0 ) {
			return null;
		}else{
			return temp;
		}
	}
	
	/**
	 * �޸�һ������
	 * @param tableName �������
	 * @param newParas  PO�����б�
	 * @return 
	 */
	protected ResultMsg modifyFromSQL(String tableName , String... newParas) {
		
		try {
			int paralen = Integer.parseInt(SQLmap.get(tableName).get(0));
			preState = conn.prepareStatement(SQLmap.get(tableName).get(4) +"\"" + newParas[0]  +"\"");
			for (int i = 0; i < paralen - 1; i++) {
				preState.setString(i + 1, newParas[i + 1]);
			}
			affectRows = preState.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMsg.FAIL;
		}
		
		if(affectRows == 0){
			return ResultMsg.NOT_EXIST;
		}else if(affectRows > 1){
			return ResultMsg.FAIL;
		}
		
		return ResultMsg.SUCCESS;
	}
	
	public ResultMsg changeOneDocState (String docID,
			String tableName, OrderState state) {
		
		try {
			sql = "UPDATE `" + tableName + "` SET state =  ? WHERE id = "+"\"" + docID+"\"" ;
			preState = conn.prepareStatement(sql);
			preState.setString(1, state.name());
			affectRows = preState.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMsg.FAIL;
		}
		if(affectRows == 0){
			return ResultMsg.NOT_EXIST;
		}else{
			return ResultMsg.SUCCESS;
		}
		
		
	}
	
	
	
	/**
	 * �������������Ϣ
	 * @param tableName
	 * @return
	 */
	protected ResultMsg initialFromSQL(String tableName) {
		
		try {
			sql = SQLmap.get(tableName).get(5);
			preState = conn.prepareStatement(sql);

			preState.executeUpdate();
			return ResultMsg.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultMsg.FAIL;
	}
	
	/**
	 * ִ����䲢����ִ�н��
	 * 
	 * @param tempPreState
	 * @return
	 */
	protected ResultMsg getDoResult(PreparedStatement tempPreState) {
		try {
			if (tempPreState.execute()) {
				return ResultMsg.SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultMsg.FAIL;
	}

	protected int  getDayDocCount(String tableName, MyDate date) {
		try {
			sql = "SELECT id from " + tableName + " ORDER BY `id` DESC";
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			String nowDate = MyDate.getDatePart(date);
			while (result.next()) {
				
				String id = result.getString(1);
				if(id.length() == 10){
				}else if(id.length() == 16){
					if(id.substring(3, 9).equals(nowDate)){
						
						try {
							return Integer.parseInt(id.substring(id.length() - 7)) + 1;
						} catch (Exception e) {
							return -1;
						}
					}else{
						return 1;
					}
					
					
					
				}
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1 ;
	}
	
	/**
	 * ���ص�ǰ���е�һ�������е���������
	 */
	protected int getResultSize(String tableName) {
		int paralen = Integer.parseInt(SQLmap.get(tableName).get(0));
		return paralen;
	}
	
}
