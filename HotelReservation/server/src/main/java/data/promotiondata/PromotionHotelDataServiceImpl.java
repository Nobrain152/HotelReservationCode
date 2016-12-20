package data.promotiondata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import dataSuper.DataSuperClass;
import dataservice.promotiondataservice.PromotionHotelDataService;
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
							po.getTimeBegin(),
							po.getTimeOver(),""+po.getRatio(),
							""+po.getLevel(),""+po.getNumber(),
							po.getBusinessName());
	}

	@Override
	public ResultMsg deleteOverCut(int num, String hotelID) throws RemoteException {
		sql = "DELETE FROM " + tableName + " WHERE number = \'" + num +
										"\' AND hotelID = \'" + hotelID+"\'";
		ResultMsg a = delete(sql);
		return a;
	}

	@Override
	public ResultMsg update(PromotionHotelPO po) throws RemoteException {
		return modifyFromSQL(tableName, po.getHotelID(),po.getType().toString(),
							po.getTimeBegin(),
							po.getTimeOver(),""+po.getRatio(),
							""+po.getLevel(),""+po.getNumber(),
							po.getBusinessName());
	}

	
	@Override
	public ArrayList<PromotionHotelPO> findByType(PromotionHotelType type, String hotelID) 
													throws RemoteException {
		ArrayList<PromotionHotelPO> pos = null;
		sql = "SELECT * FROM " + tableName  + " WHERE promotionHotelType = "
				+ "\'" + type.toString() + "\' AND hotelID = \'" + hotelID + "\'";
		pos = findMsgs(sql);
		return pos;
	}

	@Override
	public ArrayList<PromotionHotelPO> show() throws RemoteException {
		ArrayList<PromotionHotelPO> pos = null;
		sql = "SELECT * FROM " + tableName;
		pos = findMsgs(sql);
		return pos;
	}
	
	private ArrayList<PromotionHotelPO> findMsgs(String sql) throws RemoteException{
		ArrayList<PromotionHotelPO> pos = new ArrayList<PromotionHotelPO>();
		try {
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				System.out.println(result.getString(2));
				if(result.getString(2).equals(PromotionHotelType.BIRTH_PROMOTION.toString())){
					pos.add(new PromotionHotelPO(
							PromotionHotelType.valueOf(result.getString(2)),
							result.getString(1), Integer.valueOf(result.getString(6)),
							Double.valueOf(result.getString(5))));
				}else if(result.getString(2).equals(PromotionHotelType.OVERTHREE_PROMOTION.toString())){
					pos.add(new PromotionHotelPO(
							PromotionHotelType.valueOf(result.getString(2)),
							result.getString(1), Integer.valueOf(result.getString(7)),
							Double.valueOf(result.getString(5))));
				}
				else if(result.getString(2).equals(PromotionHotelType.JOIN_PROMOTION.toString())){
					pos.add(new PromotionHotelPO(
							PromotionHotelType.valueOf(result.getString(2)),
							result.getString(1), result.getString(8),
							Double.valueOf(result.getString(5))));
				}
				else if(result.getString(2).equals(PromotionHotelType.HOTEL_CUSTOM_PROMOTION.toString())){
					pos.add(new PromotionHotelPO(
							PromotionHotelType.valueOf(result.getString(2)),
							result.getString(1), result.getString(3), result.getString(4),
							Double.valueOf(result.getString(5))));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pos;
	}

	@Override
	public ResultMsg deleteBirthCut(int level, String hotelID) throws RemoteException {
		sql = "DELETE FROM " + tableName + " WHERE level = \'" + level +
				"\' AND hotelID = \'" + hotelID+"\'";
		ResultMsg a = delete(sql);
		return a;
	}

	@Override
	public ResultMsg deleteHotelCustomCut(String beginTime, String endTime, String hotelID) throws RemoteException {
		sql = "DELETE FROM " + tableName + " WHERE beginTime = \'" + beginTime +
				"\' AND endTime = \'" + endTime +"\' AND hotelID + \'" + hotelID +"\'";
		ResultMsg a = delete(sql);
		return a;
	}

	@Override
	public ResultMsg deleteJoin(String businessName, String hotelID) throws RemoteException {
		sql = "DELETE FROM " + tableName + " WHERE businessName = \'" + businessName +
				"\' AND hotelID = \'" + hotelID+"\'";
		ResultMsg a = delete(sql);
		return a;
	}

	private ResultMsg delete(String sql){
		try {
			preState = conn.prepareStatement(sql);
			affectRows = preState.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�޷��������ݿ�");
			return ResultMsg.FAIL;
		}
		
		if(affectRows != 1){
			System.out.println("��ǰ���ݿ���Ӱ�������Ϊ"+affectRows);
			System.out.println("�����ݿ��������Ϣ�����ڻ��ߴ��ڶ����޷���λɾ������"+tableName+"����");
			return ResultMsg.NOT_EXIST;
		}
		
		return ResultMsg.SUCCESS;
	}

}
