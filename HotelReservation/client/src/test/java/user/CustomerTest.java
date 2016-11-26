package user;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import blservice.userblservice.Customer;
import util.ResultMsg;
import vo.CustomerInfoVO;

public class CustomerTest {
	CustomerInfoVO vo;
	private Customer cu;
	
	@Before
	public void setup(){
		vo=new CustomerInfoVO("1234567","Jerry","13067893451",100);
		cu=new Customer("1234567");
	}
	
	@Test
	public void testInquiry(){
		assertEquals(cu.getid(),"1234567");
		assertEquals(cu.getname(),"Jerry");
		assertEquals(cu.getcontact(),"13067893451");
	}
	
	@Test
	public void testModify(){
		CustomerInfoVO vo1=new CustomerInfoVO("1234567","Tom","13067893451",100);
		ResultMsg cantest=cu.BaseInfoModification(vo1);
		if(cantest == ResultMsg.SUCCESS){
			assertEquals(cu.getid(),"1234567");
			assertEquals(cu.getname(),"Tom");
			assertEquals(cu.getcontact(),"13067893451");
			
		}
	}
}
