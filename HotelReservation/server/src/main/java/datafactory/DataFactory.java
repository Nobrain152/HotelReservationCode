package datafactory;

import java.rmi.RemoteException;

import data.creditdata.CreditDataServiceImpl;
import data.vipdata.VipDataSerivceImpl;
import dataservice.creditdataservice.CreditDataService;
import dataservice.vipdataservice.VipDataService;

/**
 * 数据工厂类
 * @author T5-SK
 *
 */

public class DataFactory {
	private static DataFactory dataFactory;
	
	public DataFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public DataFactory getDataFactory()throws RemoteException{
		if(dataFactory == null){
			dataFactory = new DataFactory();
		}
		return dataFactory;
	}
	
	//先实现一个的构建，其余的这个成功之后批量创建
	public CreditDataService getCreditDataServiceImpl() throws RemoteException{
		return new CreditDataServiceImpl();
	}
	
	public static VipDataService getVipDataService() throws RemoteException{
		return new VipDataSerivceImpl();
	}
	
}
