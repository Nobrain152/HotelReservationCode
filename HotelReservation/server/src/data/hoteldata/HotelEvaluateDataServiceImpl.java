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
	 * 增加
	 */
	public boolean insert(HotelEvaluatePO po) throws RemoteException{
		if(POs.add(po))
			return true;
		else
			return false;
	}
	
	
	/**
	 * 删除
	 */
	public boolean delete(HotelEvaluatePO po) throws RemoteException{
		if(POs.remove(po))
			return true;
		else
			return false;
	}
	
	
	/**
	 * 查找
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
	 * 显示
	 */
	public ArrayList<HotelEvaluatePO>show() throws RemoteException{
		return POs;
	}




}	