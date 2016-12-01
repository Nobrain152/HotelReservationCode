package data.hoteldata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.hoteldataservice.HotelEvaluateDataService;
import po.HotelEvaluatePO;
import util.ResultMsg;

public class HotelEvaluateDataServiceImpl implements HotelEvaluateDataService{
	ArrayList<HotelEvaluatePO> POs;
	
	public HotelEvaluateDataServiceImpl(){
		POs = new ArrayList<HotelEvaluatePO>();
	}
	
	/**
	 * ����
	 */
	public ResultMsg insert(HotelEvaluatePO po) throws RemoteException{
		if(POs.add(po))
			return ResultMsg.SUCCESS;
		else
			return ResultMsg.FAIL;
	}
	
	
	/**
	 * ɾ��
	 */
	public ResultMsg delete(HotelEvaluatePO po) throws RemoteException{
		if(POs.remove(po))
			return ResultMsg.SUCCESS;
		else
			return ResultMsg.FAIL;
	}
	
	
	/**
	 * ����
	 */
	public ArrayList<HotelEvaluatePO> find(String searchInfo) throws RemoteException{
		ArrayList<HotelEvaluatePO> arrayList = new ArrayList<HotelEvaluatePO>();
		for (HotelEvaluatePO p : POs) {
			if(p.getHotelID().equals(searchInfo)){
				arrayList.add(p);
			}
		}
		return arrayList;
	}
	
	
	/**
	 * ��ʾ
	 */
	

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