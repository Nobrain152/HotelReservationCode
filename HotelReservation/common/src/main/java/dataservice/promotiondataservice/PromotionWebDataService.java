package dataservice.promotiondataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PromotionWebPO;
import util.PromotionWebType;
import util.ResultMsg;

/**
 * ��վ�������Ե����ݲ�ӿ�
 * @author T5-SK
 *
 */

public interface PromotionWebDataService {
	
	public ResultMsg insert(PromotionWebPO Promotion) throws RemoteException;
	
	public ResultMsg delete(PromotionWebPO Promotion) throws RemoteException;
	
	public ResultMsg update(PromotionWebPO Promotion) throws RemoteException;
	
	public PromotionWebPO findByName(String name) throws RemoteException;
	
	public ArrayList<PromotionWebPO> findByType(PromotionWebType type,String hotelID) throws RemoteException;
	
	public ArrayList<PromotionWebPO> show() throws RemoteException;
	
}
