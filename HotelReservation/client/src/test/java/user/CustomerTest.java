package user;

import static org.junit.Assert.assertEquals;

import bl.userbl.Customer;
import vo.ContactVO;
import vo.CustomerInfoVO;
import vo.UserInfoVO;

public class CustomerTest {
	private CustomerInfoVO vo;
	private Customer cu;
	
	public void setup(){
		vo=new CustomerInfoVO("1234567","Jerry",new ContactVO("13067893451",null),100);
		cu=new Customer("1234567");
		
	}
	
	public void testinquiry(){
		UserInfoVO po=cu.IndividualBaseInfolnquiry("1234567");
		assertEquals(po.getUserID(),"1234567");
		assertEquals(po.getUsername(),"Jerry");
		assertEquals(po.getContact(),"13067893451");
	}
	
	public void testmodify(){
		CustomerInfoVO vo1=new CustomerInfoVO("1234567","Tom",new ContactVO("13067893451",null),100);
		boolean cantest=cu.IndividualBaseInfoModification("1234567",vo1);
		UserInfoVO po=cu.IndividualBaseInfolnquiry("1234567");
		if(cantest){
			assertEquals(po.getUserID(),"1234567");
			assertEquals(po.getUsername(),"Tom");
			assertEquals(po.getContact(),"13067893451");
			
		}
	}
}
