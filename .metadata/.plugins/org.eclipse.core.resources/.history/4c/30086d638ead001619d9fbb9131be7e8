package data.hoteldata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.HotelInfoPO;

public class HotelInfoDataServiceImpl {
	
	ArrayList<HotelInfoPO> hotelPOs;
	
	public HotelInfoDataServiceImpl(){
		hotelPOs = new ArrayList<>();
	}
	
	/**
	 * 增加
	 */
	public boolean insert(HotelInfoPO po) throws RemoteException{
		if(hotelPOs.add(po))
			return true;
		else
			return false;
	}
	
	
	/**
	 * 删除
	 */
	public boolean delete(HotelInfoPO po) throws RemoteException{
		if(hotelPOs.remove(po))
			return true;
		else
			return false;
	}
	
	/**
	 * 更新
	 */
	public boolean update(HotelInfoPO po) throws RemoteException{
			for (HotelInfoPO op : hotelPOs) {
				op = po;
				return true;
			}
			return false;
		
	}
	
	/**
	 * 查找
	 */
	public ArrayList<HotelInfoPO> find(HotelInfoPO po) throws RemoteException{
		ArrayList<HotelInfoPO> arrayList = new ArrayList<HotelInfoPO>();
		for (HotelInfoPO op : hotelPOs) {
			
				arrayList.add(op);
			
		}
		return arrayList;
	}
		
	
	/**
	 * 显示
	 */
	public ArrayList<HotelInfoPO> show() throws RemoteException{
		return hotelPOs;
	}




}