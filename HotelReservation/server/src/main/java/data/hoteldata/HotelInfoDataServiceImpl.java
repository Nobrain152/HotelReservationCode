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
	 * ����
	 */
	public ResultMsg insert(HotelInfoPO po) throws RemoteException{
		return addToSQL(tableName, po.getHotelID(),po.getName(),po.getAddress(),po.getArea(),
				""+po.getLevel(),po.getIntroduction(),po.getFacility(),
				Boolean.toString(po.getIsReserved()),""+po.getScore());
	}
	
	
	/**
	 * ɾ��
	 */
	public ResultMsg delete(HotelInfoPO po) throws RemoteException{
		return delFromSQL(tableName, po.getName());
	}
	
	/**
	 * ����
	 */
	public ResultMsg update(HotelInfoPO po) throws RemoteException{
		return modifyFromSQL(tableName, po.getHotelID(),po.getName(),po.getAddress(),po.getArea(),
				""+po.getLevel(),po.getIntroduction(),po.getFacility(),
				Boolean.toString(po.getIsReserved()),""+po.getScore());
	}
	
	/**
	 * ����
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
								Double.parseDouble(findMes.get(8)));
		}
		
		return hotelInfoPO;
	}

	/**
	 * ��ʾ
	 */
	public ArrayList<HotelInfoPO> show() throws RemoteException{
		ArrayList<HotelInfoPO> pos = new ArrayList<HotelInfoPO>(30);
		
		try {
			sql = "SELECT * FROM " + tableName ;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				pos.add(new HotelInfoPO(result.getString(1), result.getString(2),
						result.getString(3), result.getString(4),
						Integer.valueOf(result.getString(5)),result.getString(6),
						result.getString(7),Boolean.getBoolean(result.getString(8)),
						Double.parseDouble(result.getString(9))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�����ݿ��л�ȡ���е�hotel��Ϣ����");
			return null;
		}
		
		return pos.size()==0?null:pos;
	}



	@Override
	public ArrayList<HotelInfoPO> findByAreaAndCircle(String area, String circle) {
		ArrayList<HotelInfoPO> pos = new ArrayList<HotelInfoPO>(50);
		
		try {
			sql = "SELECT "+ area + " FROM " + tableName ;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�Ƶ���Ϣ�����ݿ��в��ҳ���");
		}
		
		
		return null;
	}

	@Override
	public ArrayList<HotelInfoPO> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}