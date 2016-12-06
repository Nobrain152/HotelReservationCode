package data.hoteldata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.mysqlx.protobuf.MysqlxDatatypes.Array;

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
				Boolean.toString(po.getIsReserved()));
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
				Boolean.toString(po.getIsReserved()));
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
			hotelInfoPO = new HotelInfoPO(findMes.get(0), findMes.get(1), findMes.get(2), findMes.get(3),
								Integer.valueOf(findMes.get(4)), findMes.get(5), findMes.get(6), 
								Boolean.getBoolean(findMes.get(7)) );
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
				pos.add(new HotelInfoPO(findMes.get(0), findMes.get(1), findMes.get(2), findMes.get(3),
						Integer.valueOf(findMes.get(4)), findMes.get(5), findMes.get(6), 
						Boolean.getBoolean(findMes.get(7)) ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�����ݿ��л�ȡ���е�hotel��Ϣ����");
			return null;
		}
		
		return pos.size()==0?null:pos;
	}

	@Override
	public HotelInfoPO findByOrderID(String ID) throws RemoteException {
		return null;
	}

}