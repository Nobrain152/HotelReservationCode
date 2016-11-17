package dataservice.hoteldataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.HotelEvaluatePO;

public interface HotelEvaluateDataService {
	
	/**
	 * ����
	 */
	public boolean insert(HotelEvaluatePO po) throws RemoteException;
	
	
	/**
	 * ɾ��
	 */
	public boolean delete(HotelEvaluatePO po) throws RemoteException;
	
	
	/**
	 * ����
	 */
	public ArrayList<HotelEvaluatePO> find(String searchInfo) throws RemoteException;
	
	
	/**
	 * ��ʾ
	 */
	public ArrayList<HotelEvaluatePO>show() throws RemoteException;




}	