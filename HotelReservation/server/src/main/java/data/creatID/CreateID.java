package data.creatID;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import dataSuper.DataSuperClass;
import util.ResultMsg;

public class CreateID extends DataSuperClass{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static CreateID createID;
	
	private static String tableName = "createID";
	
	
	private CreateID() throws RemoteException {
		super();
	}
	
	
	/**
	 * ����ģʽ
	 * @throws RemoteException
	 */
	public static CreateID getCreateID() throws RemoteException {
		if(createID == null){
			createID = new CreateID();
		}
		return createID;
	}
	
	/**
	 * ��ʼ�����ݿ��д�ŵ�ID
	 * user        ��λ����ͷΪ1
	 * hotelStuff  ��λ����ͷΪ2
	 * webStuff    ��λ����ͷΪ3
	 * webManager  ��λ����ͷΪ4
	 * hotelID     ��λ����ͷΪ5
	 * orderID     ��λ����ͷΪ6
	 * @return
	 */
	public ResultMsg initialize(){
		ResultMsg a = initialFromSQL(tableName);
		if(a != ResultMsg.SUCCESS){
			return ResultMsg.FAIL;
		}
		ResultMsg b = addToSQL(tableName, "10000020","20000000","30000000","40000000","5001","60000000");
		
		return b;
	}
	
	public String getNewCustomerID() {
		sql = "SELECT * FROM " + tableName;
		findMes = findMes(sql);
		ResultMsg aMsg = addToSQL(tableName, ""+(Integer.valueOf(findMes.get(0))+1),findMes.get(1),
									findMes.get(2),findMes.get(3),findMes.get(4),findMes.get(5));
		
		
		if(aMsg == ResultMsg.SUCCESS){
			return ""+(Integer.valueOf(findMes.get(0))+1);
		}else{
			return null;
		}
	}
	
	public String getNewHotelStuffID(){
		sql = "SELECT * FROM " + tableName;
		findMes = findMes(sql);
		ResultMsg aMsg = addToSQL(tableName, findMes.get(0),""+(Integer.valueOf(findMes.get(1))+1),
									findMes.get(2),findMes.get(3),findMes.get(4),findMes.get(5));
		
		if(aMsg == ResultMsg.SUCCESS){
			return ""+(Integer.valueOf(findMes.get(1))+1);
		}else{
			return null;
		}
	}
	
	public String getNewWebStuffID(){
		sql = "SELECT * FROM " + tableName;
		findMes = findMes(sql);
		ResultMsg aMsg = addToSQL(tableName, findMes.get(0),findMes.get(1),
									""+(Integer.valueOf(findMes.get(2))+1),findMes.get(3),
									findMes.get(4),findMes.get(5));
		
		if(aMsg == ResultMsg.SUCCESS){
			return ""+(Integer.valueOf(findMes.get(2))+1);
		}else{
			return null;
		}
	}
	
	public String getNewWebManagerID(){
		sql = "SELECT * FROM " + tableName;
		findMes = findMes(sql);
		ResultMsg aMsg = addToSQL(tableName, findMes.get(0),findMes.get(1),
									findMes.get(2),""+(Integer.valueOf(findMes.get(3))+1),
									findMes.get(4),findMes.get(5));
		
		if(aMsg == ResultMsg.SUCCESS){
			return ""+(Integer.valueOf(findMes.get(3))+1);
		}else{
			return null;
		}
	}
	
	public String getNewHotelID(){
		sql = "SELECT * FROM " + tableName;
		findMes = findMes(sql);
		ResultMsg aMsg = addToSQL(tableName, findMes.get(0),findMes.get(1),
									findMes.get(2),findMes.get(3),
									""+(Integer.valueOf(findMes.get(4))+1),findMes.get(5));
		
		if(aMsg == ResultMsg.SUCCESS){
			return ""+(Integer.valueOf(findMes.get(4))+1);
		}else{
			return null;
		}
	}
	
	public String getNewOrderID(){
		sql = "SELECT * FROM " + tableName;
		findMes = findMes(sql);
		ResultMsg aMsg = addToSQL(tableName, findMes.get(0),findMes.get(1),
									findMes.get(2),findMes.get(3),
									findMes.get(4),""+(Integer.valueOf(findMes.get(5))+1));
		
		if(aMsg == ResultMsg.SUCCESS){
			return ""+(Integer.valueOf(findMes.get(5))+1);
		}else{
			return null;
		}
	}
	
	/**
	 * �����ݿ��е�ȡsql�������Ϣ
	 * @param sql
	 * @return
	 */
	public ArrayList<String> findMes(String sql) {
		ArrayList<String> ans = null;
		try {
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			int size = getResultSize(tableName);
			ans = new ArrayList<String>(size);
			while(result.next()){
				for(int i=0; i<size; i++){
					ans.add(result.getString(i+1));
				}
			}
			
		} catch (SQLException e) {
			System.out.println("��createID���ȡ���ݳ���");
			e.printStackTrace();
		}
		
		return ans;
	}
	
	//test
	public static void main(String[] args) throws RemoteException{
		CreateID createID = CreateID.getCreateID();
		createID.initialize();
		String ID = createID.getNewHotelID();
		System.out.println(ID);
	} 
}
