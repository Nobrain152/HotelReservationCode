package hotel;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.hotelbl.HotelEvaluateController;
import util.ResultMsg;
import vo.HotelEvaluateVO;

public class HotelEvaluateControllerTest {

	HotelEvaluateController impl;
	ArrayList<HotelEvaluateVO> evList;
	HotelEvaluateVO evaluation1;
	HotelEvaluateVO evaluation2;
	
	ResultMsg evMsg;
	ResultMsg reMsg1;
	ResultMsg reMsg2;
	
	
	@Before
	public void setUp() {
		evaluation1=new HotelEvaluateVO("gyf","StarHotel",10,"execellent",true,"41531623636");
		evaluation2=new HotelEvaluateVO("gyf","SunHotel",8,"very good",false,"4325236526");
				
				
		impl = new HotelEvaluateController();
		reMsg1 = ResultMsg.SUCCESS;
		reMsg2 = ResultMsg.FAIL;
		evList = impl.evaluationList;
		evList.add(evaluation1);
		evList.add(evaluation2);
		evMsg = ResultMsg.SUCCESS;
	}
	
	@Test
	public void testinputEvaluate(){
		ResultMsg msg1 = impl.inputEvaluate(evaluation1);
		assertEquals(msg1, evMsg);
	}
	
	@Test
	public void testcheckOrder(){
		ResultMsg msg1 = impl.checkOrder(evaluation1); 
		assertEquals(msg1, reMsg1);
		ResultMsg msg2 = impl.checkOrder(evaluation2); 
		assertEquals(msg2, reMsg2);
	}

}
