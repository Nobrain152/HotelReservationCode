package dataservice.hoteldataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.HotelEvaluatePO;
import util.ResultMsg;

public interface HotelEvaluateDataService {

	/**
	 * ����
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg insert(HotelEvaluatePO po) throws RemoteException;
	
		/**
	 * ���ݶ���ID����
	 * @param ID
	 * @return
	 * @throws RemoteException
	 */
	public HotelEvaluatePO findByID(String ID) throws RemoteException;
	
	/**
	 * ��ʾ
	 * @return ArrayList<HotelEvaluatePO>
	 * @throws RemoteException
	 */
	public ArrayList<HotelEvaluatePO> show(String hotelid) throws RemoteException;




}	