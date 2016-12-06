package datafactory;

import java.rmi.RemoteException;

import org.junit.internal.Throwables;

import data.creditdata.CreditDataServiceImpl;
import data.hoteldata.HotelEvaluateDataServiceImpl;
import data.hoteldata.HotelInfoDataServiceImpl;
import data.hoteldata.RoomInfoDataServiceImpl;
import data.orderdata.OrderDataServiceImpl;
import data.promotiondata.PromotionHotelDataServiceImpl;
import data.promotiondata.PromotionWebDataServiceImpl;
import data.userdata.CustomerManagementDataServiceImpl;
import data.userdata.UserManagementDataServiceImpl;
import data.vipdata.VipDataSerivceImpl;
import dataservice.creditdataservice.CreditDataService;
import dataservice.hoteldataservice.HotelEvaluateDataService;
import dataservice.hoteldataservice.HotelInfoDataService;
import dataservice.hoteldataservice.RoomInfoDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.promotiondataservice.PromotionHotelDataService;
import dataservice.promotiondataservice.PromotionWebDataService;
import dataservice.userdataservice.CustomerManagementDataService;
import dataservice.userdataservice.UserManagementDataService;
import dataservice.vipdataservice.VipDataService;

/**
 * ���ݹ�����
 * @author T5-SK
 *
 */

public class DataFactory {
	
	private static DataFactory dataFactory;
	
	public DataFactory() {
	}
	
	/**
	 * ����ģʽ
	 * @return
	 * @throws RemoteException
	 */
	public static DataFactory getDataFactory() throws RemoteException{
		if(dataFactory == null){
			dataFactory = new DataFactory();
		}
		return dataFactory;
	}
	
	//��ʵ��һ���Ĺ��������������ɹ�֮����������
	public CreditDataService getCreditDataServiceImpl() throws RemoteException{
		return new CreditDataServiceImpl();
	}
	
	public HotelEvaluateDataService getHotelEvaluateDataServiceImpl() throws RemoteException{
		return new HotelEvaluateDataServiceImpl();
	}
	
	public HotelInfoDataService getHotelInfoDataServiceImpl() throws RemoteException{
		return new HotelInfoDataServiceImpl();
	}
	
	public RoomInfoDataService getRoomInfoDataServiceImpl() throws RemoteException{
		return new RoomInfoDataServiceImpl();
	}
	
	public  OrderDataService getOrderDataServiceImpl() throws RemoteException {
		return new OrderDataServiceImpl();
	}
	
	public PromotionHotelDataService getPromotionHotelDataServiceImpl() throws RemoteException{
		return new PromotionHotelDataServiceImpl();
	}
	
	public PromotionWebDataService getPromotionWebDataServiceImpl() throws RemoteException{
		return new PromotionWebDataServiceImpl();
	}
	
	public CustomerManagementDataService getCustomerManagementDataServiceImpl() throws RemoteException{
		return new CustomerManagementDataServiceImpl();
	}
	
	public UserManagementDataService getUserManagementDataServiceImpl() throws RemoteException{
		return new UserManagementDataServiceImpl();
	}
	
	public  VipDataService getVipDataService() throws RemoteException{
		return new VipDataSerivceImpl();
	}
	
	
	
}
