package dataservice.hoteldataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.HotelInfoPO;
import util.Adress;
import util.Area;
import util.ResultMsg;

public interface HotelInfoDataService {
	
	/**
	 * ����
	 */
	public String insert(HotelInfoPO po) throws RemoteException;
	
	
	/**
	 * ɾ��
	 */
	public ResultMsg delete(HotelInfoPO po) throws RemoteException;
	
	/**
	 * ����
	 */
	public ResultMsg update(HotelInfoPO po) throws RemoteException;
	
	/**
	 * ����
	 */
	public HotelInfoPO find(String ID) throws RemoteException;

	/**
	 * ���ݶ���ID����
	 * @param ID
	 * @return
	 * @throws RemoteException
	 */
	
	/**
	 * ��ʾ
	 */
	public ArrayList<HotelInfoPO> show() throws RemoteException;
	
	/**
	 * ���ݵ�ַ����Ȧ�����Ƶ�
	 * @param area
	 * @param circle
	 * @return
	 */
	public ArrayList<HotelInfoPO> findByAreaAndCircle(Adress area,Area circle);
	
	/**
	 * ���ݾƵ�����������Ƶ�
	 * @param name
	 * @return
	 */
	public ArrayList<HotelInfoPO> findByName(String name);




}