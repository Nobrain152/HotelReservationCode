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
	public ResultMsg deleteOverCut(int num, String hotelID) throws RemoteException {
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
				if(result.getString(2).equals(PromotionHotelType.BIRTH_PROMOTION)||
				result.getString(2).equals(PromotionHotelType.OVERTHREE_PROMOTION)){
					pos.add(new PromotionHotelPO(
							PromotionHotelType.valueOf(result.getString(2)),
							result.getString(1), Integer.valueOf(result.getString(8)),
							Double.valueOf(result.getString(6))));
				}
				else if(result.getString(2).equals(PromotionHotelType.JOIN_PROMOTION)){
					pos.add(new PromotionHotelPO(
							PromotionHotelType.valueOf(result.getString(2)),
							result.getString(1), result.getString(9),
							Double.valueOf(result.getString(6))));
				}
				else if(result.getString(2).equals(PromotionHotelType.HOTEL_CUSTOM_PROMOTION)){
					pos.add(new PromotionHotelPO(
							PromotionHotelType.valueOf(result.getString(2)),
							result.getString(1), result.getString(4), result.getString(5),
							Double.valueOf(result.getString(6))));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pos;
	}

	@Override
	public ResultMsg deleteBirthCut(int level, String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg deleteHotelCustomCut(String beginTime, String endTime, String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg deleteJoin(String businessName, String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}



}
