package dataservice.promotiondataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PromotionWebPO;
import util.Area;
import util.PromotionWebType;
import util.ResultMsg;

public class PromotionWebDataService_Stub implements PromotionWebDataService{
	private PromotionWebPO PromotionWebPO1;
	private PromotionWebPO PromotionWebPO2;
	private ArrayList<PromotionWebPO> PromotionWebPOs;
	
	
	public PromotionWebDataService_Stub(){
		
		PromotionWebPOs = new ArrayList<PromotionWebPO>();
		PromotionWebPOs.add(PromotionWebPO1);
		PromotionWebPOs.add(PromotionWebPO2);
	}


	@Override
	public ResultMsg insert(PromotionWebPO Promotion) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResultMsg deleteCircleCut(Area area) throws RemoteException {
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


	
}