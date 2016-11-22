package net;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import config.StaticMessage;
import util.DataServiceType;

/**
 * ���������ͻ��˵�RMI����
 * 
 */
public class RMIManage {

	private static String pres = StaticMessage.RMIPres;
	
	private RMIManage RMIServer;

	private RMIManage(){};
	
	private DataServiceType type;

	/**
	 * ��ʼ������
	 * 
	 * @return
	 */
	public static synchronized boolean netInit() {
		try {
			pres = StaticMessage.RMIPres;
			
		} catch (Exception e) {
			
			return false;
		}
		
		
		return true;
	}
	
	//TODO �ӳټ��� �ȵ���¼ʱ�ٲ�ѯ
	
	/**
	 * ��ȡ�������ݷ���
	 * @param name
	 * @return
	 */
	public static Remote getDataService(DataServiceType type) {
		
				try {
					return Naming.lookup(pres + type.getName());
				} catch (Exception e) {
				} 
				return null;
		}
		
		
		
		

	
	public static Remote mygetDataService(DataServiceType type) throws MalformedURLException, RemoteException, NotBoundException {
			return Naming.lookup(pres + type.getName());
	}
}
