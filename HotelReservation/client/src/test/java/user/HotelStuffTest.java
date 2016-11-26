package user;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import blservice.userblservice.HotelStuff;
import util.ResultMsg;
import vo.StuffInfoVO;

public class HotelStuffTest {
	StuffInfoVO vo;
	private HotelStuff stuff;
	String id="1234567";
	
	@Before
	public void setup(){
		stuff=new HotelStuff("7654321");
	    vo=new StuffInfoVO("7654321","Tim","18192345782",id);
		
	}
	
	@Test
	public void testInquiry(){
		assertEquals(stuff.getid(),"7654321");
		assertEquals(stuff.getName(),"Tim");
		assertEquals(stuff.getcontact(),"18192345782");
	}
	
	@Test
	public void testModify(){
		StuffInfoVO vo1=new StuffInfoVO("1234567","Tom","13067893451",id);
		ResultMsg cantest=stuff.BaseInfoModification(vo1);
		if(cantest == ResultMsg.SUCCESS){
			assertEquals(stuff.getid(),"1234567");
			assertEquals(stuff.getName(),"Tom");
			assertEquals(stuff.getcontact(),"13067893451");
			
		}
	}

}
