package vip;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Before;
import org.junit.Test;

import bl.vipbl.Vip;
import net.RMIManage;
import dataservice.creditdataservice.CreditDataService;
import dataservice.userdataservice.CustomerManagementDataService;
import dataservice.userdataservice.UserManagementDataService;
import dataservice.vipdataservice.VipDataService;
import po.CommonVipPO;
import po.LevelSystemPO;
import util.DataServiceType;
import util.ResultMsg;
import util.VipType;
import vo.CustomerInfoVO;

public class VipControllerTest {
	int level;
	int integral;
	private VipDataService vipDataService;
	private UserManagementDataService dataService;
	private CreditDataService creditDataService;
	Vip vip;
	CustomerInfoVO customerInfoVO;
	
	@Before
	public void setUp() throws Exception {
		vipDataService = (VipDataService)RMIManage.
				getDataService(DataServiceType.VipDataService);
		dataService = (UserManagementDataService)RMIManage.
				getDataService(DataServiceType.UserManagementDataService);
		creditDataService = (CreditDataService)RMIManage.
				getDataService(DataServiceType.CreditDataService);
		vip = new Vip(vipDataService,dataService,creditDataService);
		customerInfoVO = new CustomerInfoVO("19954722", "ÌÆöÎ", "sfd", "18805156300", 300, true, VipType.COMMON_VIP);
	}
//
//	@Test
//	public void testSearchLevel() throws RemoteException {
//		Vip vip = new Vip(vipDataService,dataService,creditDataService);
//		level = vip.searchLevel(customerInfoVO);
//		assertEquals(level,1);
//	}

//	@Test
//	public void testRegisterVip() throws RemoteException {
//		vip.registerVip(customerInfoVO.getUserID(), customerInfoVO.getVipType(), "1997-05-13");
//		CommonVipPO commonVipPO = vipDataService.findByUserIDC(customerInfoVO.getUserID());
//		assertEquals(commonVipPO.getBirthday(), "1997-05-13");
//	}
	
	@Test
	public void testCreateLevelSystem() throws RemoteException{
		LevelSystemPO levelSystemPO = new LevelSystemPO(1, 100);
		vipDataService.insertL(levelSystemPO);
		assertEquals(levelSystemPO.getLevels(), 1);
	}
}
