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
	 * ����
	 */
	public ResultMsg insert(HotelInfoPO po) throws RemoteException{
		if(hotelPOs.add(po))
			return ResultMsg.SUCCESS;
		else
			return ResultMsg.FAIL;
	}
	
	
	/**
	 * ɾ��
	 */
	public ResultMsg delete(HotelInfoPO po) throws RemoteException{
		if(hotelPOs.remove(po))
			return ResultMsg.SUCCESS;
		else
			return ResultMsg.FAIL;
	}
	
	/**
	 * ����
	 */
	public ResultMsg update(HotelInfoPO po) throws RemoteException{
			for (HotelInfoPO op : hotelPOs) {
				po = op;
				return ResultMsg.SUCCESS;
			}
			return ResultMsg.FAIL;
		
	}
	
	/**
	 * ����
	 */
	public ArrayList<HotelInfoPO> find(HotelInfoPO po) throws RemoteException{
		ArrayList<HotelInfoPO> arrayList = new ArrayList<HotelInfoPO>();
		for (HotelInfoPO op : hotelPOs) {
			
				arrayList.add(op);
			
		}
		return arrayList;
	}
		
	
	/**
	 * ��ʾ
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