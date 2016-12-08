package data.promotiondata;

import java.rmi.RemoteException;
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
							po.getMemberType().toString(),po.getTimeBegin(),
							po.getTimeOver(),""+po.getRatio(),
							""+po.getLevel(),""+po.getNumber(),
							po.getBusinessName());
	}

	@Override
	public ResultMsg delete(PromotionHotelPO po) throws RemoteException {
		return delFromSQL(tableName, po.getHotelID());
	}

	@Override
	public ResultMsg update(PromotionHotelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}


}
