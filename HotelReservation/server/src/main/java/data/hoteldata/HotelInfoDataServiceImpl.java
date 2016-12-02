package data.hoteldata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.hoteldataservice.HotelInfoDataService;
import po.HotelInfoPO;
import util.ResultMsg;

public class HotelInfoDataServiceImpl implements HotelInfoDataService{
	
	ArrayList<HotelInfoPO> hotelPOs;
	
	public HotelInfoDataServiceImpl(){
		hotelPOs = new ArrayList<HotelInfoPO>();
	}
	
	/**
	 * 增加
	 */
	public ResultMsg insert(HotelInfoPO po) throws RemoteException{
		if(hotelPOs.add(po))
			return ResultMsg.SUCCESS;
		else
			return ResultMsg.FAIL;
	}
	
	
	/**
	 * 删除
	 */
	public ResultMsg delete(HotelInfoPO po) throws RemoteException{
		if(hotelPOs.remove(po))
			return ResultMsg.SUCCESS;
		else
			return ResultMsg.FAIL;
	}
	
	/**
	 * 更新
	 */
	public ResultMsg update(HotelInfoPO po) throws RemoteException{
			for (HotelInfoPO op : hotelPOs) {
				po = op;
				return ResultMsg.SUCCESS;
			}
			return ResultMsg.FAIL;
		
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

	@Override
	public HotelInfoPO findByID(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}



}