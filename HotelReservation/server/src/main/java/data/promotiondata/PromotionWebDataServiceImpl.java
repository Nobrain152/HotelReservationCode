package data.promotiondata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import dataSuper.DataSuperClass;
import dataservice.promotiondataservice.PromotionWebDataService;
import po.PromotionHotelPO;
import po.PromotionWebPO;
import util.PromotionHotelType;
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
		return addToSQL(tableName, Promotion.getType().toString(),Promotion.getMemberType().toString(),
									Promotion.getTimeBegin(),Promotion.getTimeOver(),
									""+Promotion.getRatio(),""+Promotion.getLevel(),
									Promotion.getLocation());
	}

	@Override
	public ResultMsg deleteCircleCut(String circle) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg deleteLevelCut(int level) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg deleteWebCustomCut(String beginTime, String endTme) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg update(PromotionWebPO Promotion) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PromotionWebPO> findByType(PromotionWebType type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PromotionWebPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
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
