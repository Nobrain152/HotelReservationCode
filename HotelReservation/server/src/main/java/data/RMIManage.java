package data;

import java.net.InetAddress;

/**
 * �����ʼ��RMI����
 * @author T5-SK
 *
 */
@SuppressWarnings("unused")
public class RMIManage {
	/*
	private InetAddress hostInetAddress;
	private String hostAdr;
	private String hostName;
	private String port;
	private static DataFactory datafactory;
	private static Map<String, Class<? extends Remote>> NAMING_MAP = new HashMap<String, Class<? extends Remote>>(10);

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

		} catch (RemoteException e) {
			System.err.println("��������ʵ�ֶ������");
			e.printStackTrace();
		}
	}

	public RMIManage() {
		try {
			hostInetAddress = InetAddress.getLocalHost();
			hostAdr = hostInetAddress.getHostAddress();
			hostName = hostInetAddress.getHostName();
			port = "6600";

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
				Naming.rebind(pres + key, proxy);
			}

		} catch (NumberFormatException e) {
			System.err.println("port ת������");
			e.printStackTrace();
			return false;
		} catch (ExportException e) {
			System.err.println("�˿ڱ�ռ�ó���");
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
		System.exit(0);
	}

	public static void main(String[] args) {
		RMIManage rmi = new RMIManage();
		
		if(rmi.startRMI()){
			System.out.println("������������������");
		}

	}
	*/
}
