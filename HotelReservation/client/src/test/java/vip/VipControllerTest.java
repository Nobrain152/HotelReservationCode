package vip;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Before;
import org.junit.Test;

import bl.vipbl.Vip;
import dataservice.creditdataservice.CreditDataService;
import dataservice.userdataservice.CustomerManagementDataService;
import dataservice.vipdataservice.VipDataService;
import po.CommonVipPO;
import po.LevelSystemPO;
import util.ResultMsg;
import util.VipType;
import vo.CustomerInfoVO;

public class VipControllerTest {
	int level;
	int integral;
	private VipDataService vipDataService;
	private CustomerManagementDataService dataService;
	private CreditDataService creditDataService;
	CustomerInfoVO customerInfoVO;
	
	@Before
	public void setUp() throws Exception {
		customerInfoVO = new CustomerInfoVO("10000001", "txin", "sfd", "18805156300", 100, true, VipType.COMMON_VIP);
	}

	@Test
	public void testSearchLevel() throws RemoteException {
		Vip vip = new Vip(vipDataService,dataService,creditDataService);
		level = vip.searchLevel(customerInfoVO);
		assertEquals(level,1);
	}

	@Test
	public void testRegisterVip() throws RemoteException {
		Vip vip = new Vip(vipDataService,dataService,creditDataService);
		vip.registerVip(customerInfoVO.getUsername(), customerInfoVO.getVipType(), "1997-05-13");
		CommonVipPO commonVipPO = vipDataService.findByUserIDC(customerInfoVO.getUserID());
		assertEquals(commonVipPO.getBirthday(), "1997-05-13");
	}
	
	@Test
	public void testCreateLevelSystem() throws RemoteException{
		
		//LevelSystemPO levelSystemPO = new LevelSystemPO(levels, credits);
		//ResultMsg resultMsg = vipDataService.insertL(levelSystemPO);
	}
}
