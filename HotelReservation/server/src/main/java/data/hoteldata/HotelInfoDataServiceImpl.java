package data.hoteldata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;


import dataSuper.DataSuperClass;
import dataservice.hoteldataservice.HotelInfoDataService;
import po.HotelInfoPO;
import util.ResultMsg;

public class HotelInfoDataServiceImpl extends DataSuperClass implements HotelInfoDataService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String tableName = "hotelInfo";
	
	ArrayList<HotelInfoPO> hotelPOs;
	
	public HotelInfoDataServiceImpl() throws RemoteException{
		super();
	}
	
	/**
	 * 增加
	 */
	public ResultMsg insert(HotelInfoPO po) throws RemoteException{
		return addToSQL(tableName, po.getHotelID(),po.getName(),po.getAddress(),po.getArea(),
				""+po.getLevel(),po.getIntroduction(),po.getFacility(),
				Boolean.toString(po.getIsReserved()),""+po.getScore(),""+po.getSP());
	}
	
	
	/**
	 * 删除
	 */
	public ResultMsg delete(HotelInfoPO po) throws RemoteException{
		return delFromSQL(tableName, po.getName());
	}
	
	/**
	 * 更新
	 */
	public ResultMsg update(HotelInfoPO po) throws RemoteException{
		return modifyFromSQL(tableName, po.getHotelID(),po.getName(),po.getAddress(),po.getArea(),
				""+po.getLevel(),po.getIntroduction(),po.getFacility(),
				Boolean.toString(po.getIsReserved()),""+po.getScore(),""+po.getSP());
	}
	
	/**
	 * 查找
	 */
	@Override
	public HotelInfoPO find(String ID) throws RemoteException {
		HotelInfoPO hotelInfo = findMsg(ID);
		return hotelInfo;
	}
	
		
	
	private HotelInfoPO findMsg(String ID) {
		findMes = findFromSQL(tableName,ID);
		HotelInfoPO hotelInfoPO = null;
		
		if(findMes != null){
			hotelInfoPO = new HotelInfoPO(findMes.get(0), findMes.get(1), 
								findMes.get(2), findMes.get(3),
								Integer.valueOf(findMes.get(4)), findMes.get(5), 
								findMes.get(6),Boolean.valueOf(findMes.get(7)),
								Double.parseDouble(findMes.get(8)),Integer.valueOf(findMes.get(9)));
		}
		
		return hotelInfoPO;
	}

	/**
	 * 显示
	 */
	public ArrayList<HotelInfoPO> show() throws RemoteException{
		ArrayList<HotelInfoPO> pos = new ArrayList<HotelInfoPO>();
		
		try {
			sql = "SELECT * FROM " + tableName ;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				pos.add(new HotelInfoPO(result.getString(1), result.getString(2),
						result.getString(3), result.getString(4),
						Integer.valueOf(result.getString(5)),result.getString(6),
						result.getString(7),Boolean.valueOf(result.getString(8)),
						Double.parseDouble(result.getString(9)),
						Integer.valueOf(result.getString(10))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("从数据库中获取所有的hotel信息错误");
			return null;
		}
		
		return pos.size()==0?null:pos;
	}



	@Override
	public ArrayList<HotelInfoPO> findByAreaAndCircle(String area, String circle) {
		ArrayList<HotelInfoPO> pos = new ArrayList<HotelInfoPO>();
		
		try {
			sql = "SELECT * FROM " + tableName + " WHERE area = \'" + area + "\' AND circle = \'" + circle + "\'";
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				pos.add(new HotelInfoPO(result.getString(1), result.getString(2),
						result.getString(3), result.getString(4),
						Integer.valueOf(result.getString(5)),result.getString(6),
						result.getString(7),Boolean.valueOf(result.getString(8)),
						Double.parseDouble(result.getString(9)),
						Integer.valueOf(result.getString(10))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("酒店信息从数据库中查找出错");
			return null;
		}
		return pos.size()==0?null:pos;
	}

	@Override
	public ArrayList<HotelInfoPO> findByName(String name) {
		ArrayList<HotelInfoPO> pos = new ArrayList<HotelInfoPO>();
		
		try {
			sql = "SELECT * FROM " + tableName + " WHERE name = \'" + name + "\'";
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				pos.add(new HotelInfoPO(result.getString(1), result.getString(2),
						result.getString(3), result.getString(4),
						Integer.valueOf(result.getString(5)),result.getString(6),
						result.getString(7),Boolean.valueOf(result.getString(8)),
						Double.parseDouble(result.getString(9)),
						Integer.valueOf(result.getString(10))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("酒店信息从数据库中查找出错");
			return null;
		}
		return pos.size()==0?null:pos;
	}

}