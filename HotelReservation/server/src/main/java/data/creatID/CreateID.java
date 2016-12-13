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
	
	
	public CreateID() throws RemoteException {
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
	 * @return
	 */
	public ResultMsg initialize(){
		ResultMsg a = initialFromSQL(tableName);
		if(a != ResultMsg.SUCCESS){
			return ResultMsg.FAIL;
		}
		ResultMsg b = addToSQL(tableName, "10000020","20000000","30000000","40000000");
		
		return b;
	}
	
	public String getNewCustomerID() {
		sql = "SELECT * FROM " + tableName;
		findMes = findMes(sql);
		ResultMsg aMsg = addToSQL(tableName, ""+(Integer.valueOf(findMes.get(0))+1),findMes.get(1),
									findMes.get(2),findMes.get(3));
		
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
									findMes.get(2),findMes.get(3));
		
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
									""+(Integer.valueOf(findMes.get(2))+1),findMes.get(3));
		
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
									findMes.get(2),""+(Integer.valueOf(findMes.get(3))+1));
		
		if(aMsg == ResultMsg.SUCCESS){
			return ""+(Integer.valueOf(findMes.get(3))+1);
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
	
	/*//test
	public static void main(String[] args) throws RemoteException{
		CreateID createID = CreateID.getCreateID();
		createID.initialize();
		System.out.println(createID.getNewCustomerID());
	} */
}
