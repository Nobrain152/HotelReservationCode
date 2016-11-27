package user;


import static org.junit.Assert.assertEquals;

import bl.userbl.HotelStuff;
import vo.ContactVO;
import vo.StuffInfoVO;
import vo.UserInfoVO;

public class HotelStuffTest {
	private StuffInfoVO vo;
	private HotelStuff stuff;
	
	public void setup(){
		stuff=new HotelStuff("7654321");
		
	}
	
	public void testinquiry(){
		UserInfoVO po=stuff.IndividualBaseInfolnquiry("1234567");
		assertEquals(po.getUserID(),"7654321");
		assertEquals(po.getUsername(),"Tim");
		assertEquals(po.getContact(),"18192345782");
	}
	
	public void testmodify(){
		StuffInfoVO vo1=new StuffInfoVO("1234567","Tom",new ContactVO("13067893451",null),"1234567");
		boolean cantest=stuff.IndividualBaseInfoModification("1234567",vo1);
		UserInfoVO po=stuff.IndividualBaseInfolnquiry("1234567");
		if(cantest){
			assertEquals(po.getUserID(),"1234567");
			assertEquals(po.getUsername(),"Tom");
			assertEquals(po.getContact(),"13067893451");
			
		}
	}

}
