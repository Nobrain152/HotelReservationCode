package businesslogicserviceimpl.userblserviceimpl;


import static org.junit.Assert.assertEquals;

import businesslogicservice.userblservice.HotelStuff;
import vo.HotelIDVO;
import vo.StuffInfoVO;

public class HotelStuffTest {
	private StuffInfoVO vo;
	private HotelStuff stuff;
	HotelIDVO id=new HotelIDVO("1234567");
	
	public void setup(){
		stuff=new HotelStuff("7654321");
	    vo=new StuffInfoVO("7654321","Tim","18192345782",id);
		
	}
	
	public void testinquiry(){
		assertEquals(stuff.getid(),"7654321");
		assertEquals(stuff.getName(),"Tim");
		assertEquals(stuff.getcontact(),"18192345782");
	}
	
	public void testmodify(){
		StuffInfoVO vo1=new StuffInfoVO("1234567","Tom","13067893451",id);
		boolean cantest=stuff.BaseInfoModification(vo1);
		if(cantest){
			assertEquals(stuff.getid(),"1234567");
			assertEquals(stuff.getName(),"Tom");
			assertEquals(stuff.getcontact(),"13067893451");
			
		}
	}

}
