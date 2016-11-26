package dataservice.hoteldataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.HotelEvaluatePO;
import util.ResultMsg;

public interface HotelEvaluateDataService {
	
	/**
	 * ����
	 */
	public ResultMsg insert(HotelEvaluatePO po) throws RemoteException;
	
	
	/**
	 * ɾ��
	 */
	public ResultMsg delete(HotelEvaluatePO po) throws RemoteException;
	
	
	/**
	 * ����
	 */
	public ArrayList<HotelEvaluatePO> find(String searchInfo) throws RemoteException;
	
	
	/**
	 * ��ʾ
	 */
	public ArrayList<HotelEvaluatePO>show() throws RemoteException;




}	