package vip;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import bl.vipbl.Vip;
import dataservice.vipdataservice.VipDataService;
import util.VipType;
import vo.ContactVO;
import vo.CustomerInfoVO;

public class VipControllerTest {
	int level;
	int integral;
	private VipDataService vipDataService;
	CustomerInfoVO customerInfoVO;
	
	@Before
	public void setUp() throws Exception {
		customerInfoVO = new CustomerInfoVO("0513", "txin", new ContactVO("18805156300", null), 100, true, VipType.COMMON_VIP);
	}

	@Test
	public void testSearchLevel() throws RemoteException {
		Vip vip = new Vip(vipDataService);
		level = vip.searchLevel(customerInfoVO);
		assertEquals(level,1);
	}

}
