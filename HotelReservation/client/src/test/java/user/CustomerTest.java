package user;

import static org.junit.Assert.assertEquals;

import bl.userbl.Customer;
import vo.CustomerInfoVO;
import vo.UserInfoVO;

public class CustomerTest {
	private CustomerInfoVO vo;
	private Customer cu;
	
	public void setup(){
		vo=new CustomerInfoVO("1234567","Jerry","13067893451",100);
		cu=new Customer("1234567");
		
	}
	
	public void testinquiry(){
		UserInfoVO po=cu.IndividualBaseInfolnquiry("1234567");
		assertEquals(po.getUserid(),"1234567");
		assertEquals(po.getUsername(),"Jerry");
		assertEquals(po.getContact(),"13067893451");
	}
	
	public void testmodify(){
		CustomerInfoVO vo1=new CustomerInfoVO("1234567","Tom","13067893451",100);
		boolean cantest=cu.IndividualBaseInfoModification("1234567",vo1);
		UserInfoVO po=cu.IndividualBaseInfolnquiry("1234567");
		if(cantest){
			assertEquals(po.getUserid(),"1234567");
			assertEquals(po.getUsername(),"Tom");
			assertEquals(po.getContact(),"13067893451");
			
		}
	}
}
