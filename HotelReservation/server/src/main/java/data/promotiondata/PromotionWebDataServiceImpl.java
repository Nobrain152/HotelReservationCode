package data.promotiondata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.promotiondataservice.PromotionWebDataService;
import po.PromotionHotelPO;
import util.PromotionHotelType;
import util.ResultMsg;

public class PromotionWebDataServiceImpl implements PromotionWebDataService{

	@Override
	public ResultMsg insert(PromotionHotelPO Promotion) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMsg.FAIL;
	}

	@Override
	public ResultMsg delete(PromotionHotelPO Promotion) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMsg.FAIL;
	}

	@Override
	public ResultMsg update(PromotionHotelPO Promotion) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMsg.FAIL;
	}

	@Override
	public PromotionHotelPO findByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PromotionHotelPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PromotionHotelPO> findByType(PromotionHotelType type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
