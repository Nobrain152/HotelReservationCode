package data.hoteldata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.hoteldataservice.HotelEvaluateDataService;
import po.HotelEvaluatePO;
import util.ResultMsg;

public class HotelEvaluateDataServiceImpl implements HotelEvaluateDataService{
	
	private String tableName = "hotelEvaluate";
	
	@Override
	public ResultMsg insert(HotelEvaluatePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMsg delete(HotelEvaluatePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HotelEvaluatePO> find(String searchInfo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HotelEvaluatePO findByID(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HotelEvaluatePO> show(String hotelid) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}	