package data.promotiondata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import dataSuper.DataSuperClass;
import dataservice.promotiondataservice.PromotionWebDataService;
import po.PromotionWebPO;
import util.Area;
import util.PromotionWebType;
import util.ResultMsg;

public class PromotionWebDataServiceImpl extends DataSuperClass implements PromotionWebDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static String tableName = "promotionWeb";
	
	public PromotionWebDataServiceImpl() throws RemoteException {
		super();
	}


	@Override
	public ResultMsg insert(PromotionWebPO Promotion) throws RemoteException {
		return addToSQL(tableName, Promotion.getType().toString(),
									Promotion.getTimeBegin(),Promotion.getTimeOver(),
									""+Promotion.getRatio(),""+Promotion.getLevel(),
									Promotion.getLocation().toString());
	}

	
	@Override
	public ResultMsg deleteCircleCut(Area area) throws RemoteException {
		sql = "DELETE FROM " + tableName + " WHERE location = \'" + area +
				"\'";
		ResultMsg a = delete(sql);
		return a;
	}

	@Override
	public ResultMsg deleteLevelCut(int level) throws RemoteException {
		sql = "DELETE FROM " + tableName + " WHERE level = \'" + level +
				"\'";
		ResultMsg a = delete(sql);
		return a;
	}

	@Override
	public ResultMsg deleteWebCustomCut(String beginTime, String endTme) throws RemoteException {
		sql = "DELETE FROM " + tableName + " WHERE beginTime = \'" + beginTime +
				"\' AND endTime = \'" + endTme+"\'";
		ResultMsg a = delete(sql);
		return a;
	}

	@Override
	public ResultMsg update(PromotionWebPO Promotion) throws RemoteException {
		return modifyFromSQL(tableName, Promotion.getType().toString(),
							Promotion.getTimeBegin(),
							Promotion.getTimeOver(),""+Promotion.getRatio(),
							""+Promotion.getLevel(),Promotion.getLocation().toString());
	}

	@Override
	public ArrayList<PromotionWebPO> findByType(PromotionWebType type) throws RemoteException {
		ArrayList<PromotionWebPO> pos = new ArrayList<PromotionWebPO>();
		sql = "SELECT * FROM " + tableName + " WHERE promotionWebType = \'" + type.toString() + "\'";
		pos = findMsgs(sql);
		return pos;
	}

	@Override
	public ArrayList<PromotionWebPO> show() throws RemoteException {
		ArrayList<PromotionWebPO> pos = new ArrayList<PromotionWebPO>();
		sql = "SELECT * FROM " + tableName ;
		pos = findMsgs(sql);
		return pos;
	}
	
	private ResultMsg delete(String sql){
		try {
			preState = conn.prepareStatement(sql);
			affectRows = preState.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("无法连接数据库");
			return ResultMsg.FAIL;
		}
		
		if(affectRows != 1){
			System.out.println("当前数据库中影响的条数为"+affectRows);
			System.out.println("在数据库中这个信息不存在或者存在多条无法定位删除，在"+tableName+"表中");
			return ResultMsg.NOT_EXIST;
		}
		
		return ResultMsg.SUCCESS;
	}


	private ArrayList<PromotionWebPO> findMsgs(String sql) throws RemoteException{
		ArrayList<PromotionWebPO> pos = new ArrayList<PromotionWebPO>();
		try {
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				if(result.getString(1).equals(PromotionWebType.VIP_LEVEL_PROMOTION.toString())){
					pos.add(new PromotionWebPO(PromotionWebType.valueOf(result.getString(1)),
												Integer.valueOf(result.getString(5)), 
												Double.valueOf(result.getString(4))));
				}
				else if(result.getString(1).equals(PromotionWebType.VIP_CIRCLE_PROMOTION.toString())){
					pos.add(new PromotionWebPO(PromotionWebType.valueOf(result.getString(1)), 
												Area.valueOf(result.getString(6)), 
												Double.valueOf(result.getString(4))));
				}
				else if(result.getString(1).equals(PromotionWebType.WEB_CUSTOM_PROMOTION.toString())){
					pos.add(new PromotionWebPO(PromotionWebType.valueOf(result.getString(1)), 
												result.getString(2), result.getString(3), 
												Double.valueOf(result.getString(4))));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pos;
	}
	



}
