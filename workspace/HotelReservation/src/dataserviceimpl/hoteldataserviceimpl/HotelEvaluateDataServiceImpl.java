package dataserviceimpl.hoteldataserviceimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.HotelEvaluatePO;

public class HotelEvaluateDataServiceImpl {
	ArrayList<HotelEvaluatePO> POs;
	
	public HotelEvaluateDataServiceImpl(){
		POs = new ArrayList<>();
	}
	
	/**
	 * ����
	 */
	public boolean insert(HotelEvaluatePO po) throws RemoteException{
		if(POs.add(po))
			return true;
		else
			return false;
	}
	
	
	/**
	 * ɾ��
	 */
	public boolean delete(HotelEvaluatePO po) throws RemoteException{
		if(POs.remove(po))
			return true;
		else
			return false;
	}
	
	
	/**
	 * ����
	 */
	public ArrayList<HotelEvaluatePO> find(String searchInfo) throws RemoteException{
		ArrayList<HotelEvaluatePO> arrayList = new ArrayList<HotelEvaluatePO>();
		for (HotelEvaluatePO p : POs) {
			if(p.getHotelName().equals(searchInfo)){
				arrayList.add(p);
			}
		}
		return arrayList;
	}
	
	
	/**
	 * ��ʾ
	 */
	public ArrayList<HotelEvaluatePO>show() throws RemoteException{
		return POs;
	}




}	