package data;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import data.orderdata.OrderOnWebDataServiceImpl;
import po.OrderOnWebPO;
import util.OrderState;
import util.ResultMsg;
import util.User;

public class OrderOnWebDataServiceImplTest {

	OrderOnWebDataServiceImpl webDataServiceImpl;
	ArrayList<OrderOnWebPO> list;
	OrderOnWebPO order1;
	OrderOnWebPO order2;
	OrderOnWebPO order3;
	OrderOnWebPO order4;
	
	@Before
	public void setUp(){
		webDataServiceImpl = new OrderOnWebDataServiceImpl();
		order1 = new OrderOnWebPO(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"),"42654645437",
				OrderState.UNEXECUTED,105,"火车晚点");
		order2 = new OrderOnWebPO(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"),"42654645437",
				OrderState.ABNORMAL,105, "");
		order3 = new OrderOnWebPO(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"),"42654645437",
				OrderState.CANCELLED,105, "");
		order4 = new OrderOnWebPO(new User("txin",100,"18805156300","151250132@smail.nju.edu.cn"),"42654645437",
				OrderState.EXECUTED,105, "");
		list = new ArrayList<OrderOnWebPO>();
	}
	
	@Test
	public void testInsert() throws RemoteException{
		ResultMsg b = webDataServiceImpl.insert(order1);
		assertEquals(b, ResultMsg.SUCCESS);
	}
	
	@Test
	public void testDelete() throws RemoteException{
		webDataServiceImpl.insert(order1);
		ResultMsg b = webDataServiceImpl.delete(order1);
		assertEquals(b, ResultMsg.SUCCESS);
	}
	
	@Test
	public void testUpdate() throws RemoteException{
		webDataServiceImpl.insert(order1);
		ResultMsg b = webDataServiceImpl.update(order1);
		assertEquals(b, ResultMsg.SUCCESS);
	}
	
	@Test
	public void testFindByName() throws RemoteException{
		webDataServiceImpl.insert(order1);
		webDataServiceImpl.insert(order2);
		ArrayList<OrderOnWebPO> arrayList = webDataServiceImpl.findByName("txin");
		list.add(order1);
		list.add(order2);
		assertEquals(list.get(0), arrayList.get(0));
		assertEquals(list.get(1), arrayList.get(1));
	}

	@Test
	public void testGetAbnormalList() throws RemoteException{
		webDataServiceImpl.insert(order1);
		webDataServiceImpl.insert(order2);
		webDataServiceImpl.insert(order3);
		webDataServiceImpl.insert(order4);
		list.add(order2);
		ArrayList<OrderOnWebPO> arrayList = webDataServiceImpl.getAbnormalList();
		assertEquals(list, arrayList);
	}
}
