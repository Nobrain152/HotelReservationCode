package dataservice.promotiondataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PromotionHotelPO;
import util.PromotionHotelType;
import util.ResultMsg;

/**
 * �Ƶ�Ӫ�����Ե����ݲ�ӿ�
 * @author kevin
 *
 */

public interface PromotionHotelDataService {
	public ResultMsg insert(PromotionHotelPO Promotion) throws RemoteException;
	
	public ResultMsg delete(PromotionHotelPO Promotion) throws RemoteException;
	
	public ResultMsg update(PromotionHotelPO Promotion) throws RemoteException;
	
	public PromotionHotelPO findByName(String name) throws RemoteException;
	
	public ArrayList<PromotionHotelPO> findByType(PromotionHotelType type) throws RemoteException;
	
	public ArrayList<PromotionHotelPO> show() throws RemoteException;
	
	
}
