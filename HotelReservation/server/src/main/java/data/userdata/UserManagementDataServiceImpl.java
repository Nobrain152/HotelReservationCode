package data.userdata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import data.creatID.CreateID;
import dataSuper.DataSuperClass;
import dataservice.userdataservice.UserManagementDataService;
import po.CustomerInfoPO;
import po.LoginInPO;
import po.StuffInfoPO;
import po.UserInfoPO;
import util.ResultMsg;
import util.UserType;
import util.VipType;

public class UserManagementDataServiceImpl extends DataSuperClass implements UserManagementDataService {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final static String tableName = "userInfo";
	
	private final static String tableName2 = "customerInfo";
	
	private final static String tableName3 = "stuffInfo";
	
	/**
	 * ��ͨ�û���customerinfo
	 * �Ƶ깤����Ա��stuffinfo
	 * ��վӪ����Ա����վ������Ա��userinfo
	 * 
	 * @throws RemoteException
	 */
	public UserManagementDataServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public String GetLoginInfo(String userid) throws RemoteException {
		LoginInpoData login = new LoginInpoData();
		LoginInPO po =login.findLoginPO(userid);
		return po.getPassword();
	}
	
	
	@Override
	public String AddCustomer(CustomerInfoPO po) throws RemoteException {
		String newID = CreateID.getCreateID().getNewCustomerID();
		ResultMsg bMsg = addToSQL(tableName2,newID,po.getUsername(),po.getPassword(),po.getContact(),
										po.getType().toString(),""+po.getIsMember(),
										po.getVipType().toString(),""+po.getCredit());
		if(bMsg == ResultMsg.SUCCESS){
			return newID;
		}else{
			return null;
		}
	}
	
	@Override
	public String AddHotelStuff(StuffInfoPO po) throws RemoteException{
		String newID = CreateID.getCreateID().getNewHotelStuffID();
		ResultMsg bMsg = addToSQL(tableName3,newID,po.getUsername(),po.getPassword(),
											po.getContact(),po.getType().toString(),
											po.getHotel());
		if(bMsg == ResultMsg.SUCCESS){
			return newID;
		}else{
			return null;
		}
	}

	@Override
	public String AddWebStuff(UserInfoPO po) throws RemoteException {
		String newID = CreateID.getCreateID().getNewWebStuffID();
		ResultMsg bMsg = addToSQL(tableName, newID,po.getUsername(),po.getPassword(),
									po.getContact(),po.getType().toString());
		if(bMsg == ResultMsg.SUCCESS){
			return newID;
		}else{
			return null;
		}
	}

	@Override
	public String AddWebManager(UserInfoPO po) throws RemoteException {
		String newID = CreateID.getCreateID().getNewWebManagerID();
		ResultMsg bMsg = addToSQL(tableName, newID,po.getUsername(),po.getPassword(),
									po.getContact(),po.getType().toString());
		if(bMsg == ResultMsg.SUCCESS){
			return newID;
		}else{
			return null;
		}
	}


	@Override
	public StuffInfoPO GetHotelStuffInfo(String userid) throws RemoteException{
		findMes = findFromSQL(tableName3, userid);
		StuffInfoPO po = new StuffInfoPO(findMes.get(0),findMes.get(1),findMes.get(3),
										findMes.get(5),findMes.get(2));
		return po;
	}

	
	
	@Override
	public UserInfoPO GetWebManagerInfo(String userid) throws RemoteException{
		findMes = findFromSQL(tableName,userid);
		UserInfoPO po = new UserInfoPO(findMes.get(0), findMes.get(1), findMes.get(3), findMes.get(2));
		return po;
	}

	@Override
	public UserInfoPO GetWebStuffInfo(String userid) throws RemoteException{
		findMes = findFromSQL(tableName, userid);
		UserInfoPO po = new UserInfoPO(findMes.get(0), findMes.get(1),findMes.get(3), findMes.get(2));
		return po;
	}

	@Override
	public CustomerInfoPO GetCustomerInfo(String userid) throws RemoteException{
		findMes = findFromSQL(tableName2, userid);
		CustomerInfoPO po = null;
		if(findMes.get(6) != null){
			po = new CustomerInfoPO(findMes.get(0), findMes.get(1), findMes.get(3), 
												findMes.get(2), Integer.valueOf(findMes.get(7)), 
												Boolean.valueOf(findMes.get(5)), 
												VipType.valueOf(findMes.get(6)));
		}else{
			po = new CustomerInfoPO(findMes.get(0), findMes.get(1), findMes.get(3), 
					findMes.get(2), Integer.valueOf(findMes.get(7)), 
					Boolean.valueOf(findMes.get(5)), 
					null);
		}
		
		return po;
	}

	@Override
	public ResultMsg SetHotelStuffInfo(String userid, StuffInfoPO po) throws RemoteException{
		return modifyFromSQL(tableName3, po.getUserID(),po.getUsername(),po.getPassword(),
							po.getContact(),po.getType().toString(),
							po.getHotel());
	}

	@Override
	public ResultMsg SetWebManagerInfo(String userid, UserInfoPO po) throws RemoteException{
		return modifyFromSQL(tableName, po.getUserID(),po.getUsername(),po.getPassword(),
										po.getContact(),po.getType().toString());
	}

	@Override
	public ResultMsg SetWebStuffInfo(String userid, UserInfoPO po2) throws RemoteException{
		return modifyFromSQL(tableName, po2.getUserID(),po2.getUsername(),po2.getPassword(),
										po2.getContact(),po2.getType().toString());
	}

	@Override
	public ResultMsg SetCustomerInfo(String userid, CustomerInfoPO po) throws RemoteException{
		return modifyFromSQL(tableName2, po.getUserID(),po.getUsername(),po.getPassword(),po.getContact(),
											po.getType().toString(),""+po.getIsMember(),
											po.getVipType().toString(),""+po.getCredit());
	}



	@Override
	public ArrayList<UserInfoPO> WebStuffScan() throws RemoteException{
		ArrayList<UserInfoPO> pos = new ArrayList<UserInfoPO>();
		
		try {
			sql = "SELECT * FROM " + tableName ;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				if(result.getString(5).equals(UserType.WebStuff.toString())){
					pos.add(new UserInfoPO(result.getString(1), result.getString(2), result.getString(4),
											result.getString(3)));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�����ݿ��л�ȡ���е�webStuff��Ϣ����");
			return null;
		}
		
		return pos.size()==0?null:pos;
	}

	@Override
	public ArrayList<StuffInfoPO> HotelStuffScan() throws RemoteException{
		ArrayList<StuffInfoPO> pos = new ArrayList<StuffInfoPO>();
		
		try {
			sql = "SELECT * FROM " + tableName ;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				if(result.getString(5).equals(UserType.WebStuff.toString())){
					pos.add(new StuffInfoPO(result.getString(1), result.getString(2), result.getString(4),
											result.getString(6), result.getString(3)));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�����ݿ��л�ȡ���е�stuffinfo��Ϣ����");
			return null;
		}
		
		return pos.size()==0?null:pos;
	}

	

}	