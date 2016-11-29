package user;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import bl.userbl.Customer;
import data.userdata.CustomerManagementDataServiceImpl;
import dataservice.userdataservice.CustomerManagementDataService;
import vo.ContactVO;
import vo.CustomerInfoVO;
import vo.UserInfoVO;

public class CustomerTest {
	private Customer cu;
	private CustomerManagementDataService customerManagementDataService =new CustomerManagementDataServiceImpl();

	
	public void setup(){
		cu=new Customer(customerManagementDataService);
		
	}
	
	public void testinquiry(){
		UserInfoVO po = null;
		try {
			po = cu.IndividualBaseInfolnquiry("1234567");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(po.getUserID(),"1234567");
		assertEquals(po.getUsername(),"Jerry");
		assertEquals(po.getContact(),"13067893451");
	}
	
	public void testmodify(){
		CustomerInfoVO vo1=new CustomerInfoVO("1234567","Tom",new ContactVO("13067893451",null),100);
		boolean cantest = false;
		try {
			cantest = cu.IndividualBaseInfoModification("1234567",vo1);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserInfoVO po = null;
		try {
			po = cu.IndividualBaseInfolnquiry("1234567");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(cantest){
			assertEquals(po.getUserID(),"1234567");
			assertEquals(po.getUsername(),"Tom");
			assertEquals(po.getContact(),"13067893451");
			
		}
	}
}
