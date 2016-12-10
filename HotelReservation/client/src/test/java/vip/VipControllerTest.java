package vip;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import bl.vipbl.Vip;
import dataservice.creditdataservice.CreditDataService;
import dataservice.userdataservice.CustomerManagementDataService;
import dataservice.userdataservice.UserManagementDataService;
import dataservice.vipdataservice.VipDataService;
import po.CommonVipPO;
import util.VipType;
import vo.ContactVO;
import vo.CustomerInfoVO;

public class VipControllerTest {
	int level;
	int integral;
	private VipDataService vipDataService;
	private CustomerManagementDataService dataService;
	private UserManagementDataService userManagementDataService;
	private CreditDataService creditDataService;
	CustomerInfoVO customerInfoVO;
	
	@Before
	public void setUp() throws Exception {
		customerInfoVO = new CustomerInfoVO("10000001", "txin", "sfd", "18805156300", 100, true, VipType.COMMON_VIP);
	}
//
//	@Test
//	public void testSearchLevel() throws RemoteException {
//		Vip vip = new Vip(vipDataService,dataService,creditDataService);
//		level = vip.searchLevel(customerInfoVO);
//		assertEquals(level,1);
//	}

	@Test
	public void testRegisterVip() throws RemoteException {
		Vip vip = new Vip(vipDataService,dataService,creditDataService);
		vip.registerVip(customerInfoVO.getUsername(), customerInfoVO.getVipType(), "1997-05-13");
		CommonVipPO commonVipPO = vipDataService.findByUserIDC(customerInfoVO.getUserID());
		assertEquals(commonVipPO.getBirthday(), "1997-05-13");
	}
}
