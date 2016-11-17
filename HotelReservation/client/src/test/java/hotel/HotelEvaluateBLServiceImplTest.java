package hotel;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import businesslogic.util.EvaluationMsg;
import businesslogic.util.ResultMsg;
import vo.HotelEvaluateVO;

public class HotelEvaluateBLServiceImplTest {

	HotelEvaluateBLServiceImpl impl;
	ArrayList<HotelEvaluateVO> evList;
	HotelEvaluateVO evaluation1;
	HotelEvaluateVO evaluation2;
	
	EvaluationMsg evMsg;
	ResultMsg reMsg1;
	ResultMsg reMsg2;
	
	
	@Before
	public void setUp() {
		evaluation1=new HotelEvaluateVO("gyf","StarHotel",10,"execellent",true);
		evaluation2=new HotelEvaluateVO("gyf","SunHotel",8,"very good",false);
				
				
		impl = new HotelEvaluateBLServiceImpl();
		reMsg1 = new ResultMsg(true, "������ۣ�");
		reMsg1 = new ResultMsg(false, "���۳���");
		evList = impl.evaluationList;
		evList.add(evaluation1);
		evList.add(evaluation2);
		
		
		evMsg = new EvaluationMsg(evaluation1.getScore(),
				evaluation1.getComment(),evaluation1.isReserved());
	}
	
	@Test
	public void testinputEvaluate(){
		EvaluationMsg msg1 = impl.inputEvaluate(evaluation1);
		assertEquals(msg1.getScore(), evMsg.getScore());
		assertEquals(msg1.getComment(), evMsg.getComment());
		assertEquals(msg1.isReserved(), evMsg.isReserved());
		
	}
	
	@Test
	public void testcheckOrder(){
		ResultMsg msg1 = impl.checkOrder(evaluation1); 
		assertEquals(msg1.getMessage(), reMsg1.getMessage());
		ResultMsg msg2 = impl.checkOrder(evaluation2); 
		assertEquals(msg2.getMessage(), reMsg2.getMessage());
	}

}
