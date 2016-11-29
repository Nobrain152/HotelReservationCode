package data.promotiondata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.promotiondataservice.PromotionWebDataService;
import po.PromotionHotelPO;
import po.PromotionWebPO;
import util.PromotionHotelType;
import util.PromotionWebType;
import util.ResultMsg;

public class PromotionWebDataServiceImpl implements PromotionWebDataService{

	@Override
	public ResultMsg insert(PromotionWebPO Promotion) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg delete(PromotionWebPO Promotion) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg update(PromotionWebPO Promotion) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PromotionWebPO findByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PromotionWebPO> findByType(PromotionWebType type, String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PromotionWebPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}



}
