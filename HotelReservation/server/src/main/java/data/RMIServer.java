package data;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.ExportException;
import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;

import config.StaticMessage;
import datafactory.DataFactory;

/**
 * 初始化RMI服务
 * @author T5-SK
 *
 */
@SuppressWarnings("unused")
public class RMIServer {
	
	/*private InetAddress hostInetAddress;
	private String hostAdr;//TODO unused
	private String hostName;
	private String port;
	private static DataFactory datafactory;
	private static Map<String, Class<? extends Remote>> NAMING_MAP = new HashMap<String, Class<? extends Remote>>(10);
	private static Map<String, Remote> remoteMap = new HashMap<>();
	static {
		datafactory = DataFactory.getDataFactory();

		try {
			NAMING_MAP.put("AccountDataService", datafactory.getAccountDataImpl().getClass());
			NAMING_MAP.put("DTManageDataService", datafactory.getDTMangeDataImpl().getClass());
			NAMING_MAP.put("FinanceDataService", datafactory.getFinanceDataImpl().getClass());
			NAMING_MAP.put("OrderDataService", datafactory.getOrderDataImpl().getClass());
			NAMING_MAP.put("PersonnelDataService", datafactory.getPersonnelDataImpl().getClass());
			NAMING_MAP.put("StatisticDataService", datafactory.getStatisticDataImpl().getClass());
			NAMING_MAP.put("StoreDataService", datafactory.getStoreDataImpl().getClass());
			NAMING_MAP.put("StrategyDataService", datafactory.getStrategyDataImpl().getClass());
			NAMING_MAP.put("TransportDataService", datafactory.getTransportDataImpl().getClass());

		} catch (Exception e) {
			System.err.println("产生数据实现对象出错");
			e.printStackTrace();
		}
	}

	public RMIServer(String address , String port) {
		try {
			hostInetAddress = InetAddress.getLocalHost();
			hostAdr = hostInetAddress.getHostAddress();
			hostName = hostInetAddress.getHostName();
			this.port = port;

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public synchronized boolean startRMI() {
//		String pres = "rmi://" + hostAdr + ":" + port + "/";
		String pres = StaticMessage.RMIPres;
		System.out.println(pres);
		try {
			LocateRegistry.createRegistry(Integer.parseInt(port));
			for (Entry<String, Class<? extends Remote>> iterator : NAMING_MAP.entrySet()) {
				String key = iterator.getKey();
				Class<? extends Remote> dataservice = iterator.getValue();
				Remote proxy = dataservice.newInstance();
				remoteMap.put(key, proxy);
				Naming.rebind(pres + key, proxy);
			}

		} catch (NumberFormatException e) {
			System.err.println("port 转换错误");
			e.printStackTrace();
			return false;
		} catch (ExportException e) {
			System.err.println("端口被占用出错");
			e.printStackTrace();
			return false;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		// String pre = "rmi://" + hostAdr

		return true;
	}

	public void stopRMI() {
//		for (Entry<String, Class<? extends Remote>> iterator : NAMING_MAP.entrySet()) {
//			String key = iterator.getKey();
//			
//			try {
//				UnicastRemoteObject.unexportObject(remoteMap.get(key), true);
//			} catch (NoSuchObjectException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		System.exit(0);
	}
	*/
}
