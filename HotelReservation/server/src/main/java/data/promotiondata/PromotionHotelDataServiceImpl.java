package data.promotiondata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.promotiondataservice.PromotionHotelDataService;
import po.PromotionHotelPO;
import util.PromotionHotelType;
import util.ResultMsg;

public class PromotionHotelDataServiceImpl implements PromotionHotelDataService{

	@Override
	public ResultMsg insert(PromotionHotelPO promotion) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg delete(PromotionHotelPO promotion) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg update(PromotionHotelPO promotion) throws RemoteException {
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
