package dataservice.PromotionDataService;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.util.PromotionHotelType;
import po.PromotionHotelPO;

/**
 * 网站促销策略的数据层接口
 * @author T5-SK
 *
 */

public interface PromotionWebDataService {
	public void insert(PromotionHotelPO Promotion) throws RemoteException;
	
	public void delete(PromotionHotelPO Promotion) throws RemoteException;
	
	public void update(PromotionHotelPO Promotion) throws RemoteException;
	
	public PromotionHotelPO findByName(String name) throws RemoteException;
	
	public ArrayList<PromotionHotelPO> findByType(PromotionHotelType type) throws RemoteException;
	
	public ArrayList<PromotionHotelPO> show() throws RemoteException;
	
}
