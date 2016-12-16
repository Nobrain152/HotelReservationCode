package user;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import bl.userbl.Customer;
import dataservice.userdataservice.CustomerManagementDataService;
import util.ResultMsg;
import vo.CustomerInfoVO;
import vo.UserInfoVO;

public class CustomerTest {
	private Customer cu;
	private CustomerManagementDataService customerManagementDataService;

	
	public void setup(){
		cu=new Customer(customerManagementDataService);
		
	}
	
	public void testinquiry(){
		UserInfoVO po = null;
		try {
			po = cu.IndividualBaseInfolnquiry("12345678");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(po.getUserID(),"12345678");
		assertEquals(po.getUsername(),"Jerry");
		assertEquals(po.getContact(),"13067893451");
	}
	
	public void testmodify(){
		CustomerInfoVO vo1=new CustomerInfoVO("12345678","Tom","13067893451","1234567",100,false,null);
		ResultMsg cantest = ResultMsg.FAIL;
		try {
			cantest = cu.IndividualBaseInfoModification("12345678",vo1);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserInfoVO po = null;
		try {
			po = cu.IndividualBaseInfolnquiry("12345678");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(cantest==ResultMsg.SUCCESS){
			assertEquals(po.getUserID(),"12345678");
			assertEquals(po.getUsername(),"Tom");
			assertEquals(po.getContact(),"13067893451");
			
		}
	}
}
