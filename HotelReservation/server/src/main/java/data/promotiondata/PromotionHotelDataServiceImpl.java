package data.promotiondata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import dataSuper.DataSuperClass;
import dataservice.promotiondataservice.PromotionHotelDataService;
import po.HotelEvaluatePO;
import po.PromotionHotelPO;
import util.PromotionHotelType;
import util.ResultMsg;

public class PromotionHotelDataServiceImpl extends DataSuperClass implements PromotionHotelDataService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static String tableName = "promotionHotel";
	
	public PromotionHotelDataServiceImpl() throws RemoteException {
		super();
	}
	
	@Override
	public ResultMsg insert(PromotionHotelPO po) throws RemoteException {
		return addToSQL(tableName, po.getHotelID(),po.getType().toString(),
							po.getMemberType().toString(),po.getTimeBegin(),
							po.getTimeOver(),""+po.getRatio(),
							""+po.getLevel(),""+po.getNumber(),
							po.getBusinessName());
	}

	@Override
	public ResultMsg delete(PromotionHotelPO po) throws RemoteException {
		//改接口，重新写
		return null;
	}

	@Override
	public ResultMsg update(PromotionHotelPO po) throws RemoteException {
		return modifyFromSQL(tableName, po.getHotelID(),po.getType().toString(),
							po.getMemberType().toString(),po.getTimeBegin(),
							po.getTimeOver(),""+po.getRatio(),
							""+po.getLevel(),""+po.getNumber(),
							po.getBusinessName());
	}

	@Override
	public PromotionHotelPO findByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PromotionHotelPO> findByType(PromotionHotelType type, String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PromotionHotelPO> show() throws RemoteException {
		return null;
	}
	
	private ArrayList<PromotionHotelPO> findMsgs(String sql) throws RemoteException{
		ArrayList<PromotionHotelPO> pos = new ArrayList<PromotionHotelPO>();
		try {
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				//构造函数不明
				//pos.add(new PromotionHotelpo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pos;
	}


}
