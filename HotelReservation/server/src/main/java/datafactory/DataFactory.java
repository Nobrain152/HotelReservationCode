package datafactory;

import data.creditdata.CreditDataServiceImpl;
import data.vipdata.VipDataSerivceImpl;
import dataservice.creditdataservice.CreditDataService;
import dataservice.vipdataservice.VipDataService;

/**
 * ���ݹ�����
 * @author T5-SK
 *
 */

public class DataFactory {
	private static DataFactory dataFactory;
	
	public DataFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public DataFactory getDataFactory(){
		if(dataFactory == null){
			dataFactory = new DataFactory();
		}
		return dataFactory;
	}
	
	//��ʵ��һ���Ĺ��������������ɹ�֮����������
	public CreditDataService getCreditDataServiceImpl() {
		return new CreditDataServiceImpl();
	}
	
	public static VipDataService getVipDataService(){
		return new VipDataSerivceImpl();
	}
	
}
