package vip;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import bl.vipbl.VipController;
import po.CommonVipPO;
import util.VipType;
import vo.CommonVipVO;
import vo.CustomerInfoVO;
import vo.LevelSystemVO;

public class VipControllerTest {
	private VipController vipController;
	CustomerInfoVO customerInfoVO;
	
	@Before
	public void setUp() throws Exception {
		vipController = new VipController();
		customerInfoVO = new CustomerInfoVO("19954722", "ÌÆöÎ", "sfd", "18805156300", 300, true, VipType.COMMON_VIP);
	}

//	@Test
//	public void testSearchLevel() throws RemoteException {
//		int level = vipController.searchLevel(customerInfoVO);
//		assertEquals(level,1);
//	}

	@Test
	public void testRegisterVip() throws RemoteException {
		vipController.registerVip(customerInfoVO.getUserID(), customerInfoVO.getVipType(), "1997-05-13");
		CommonVipVO commonVipVO = new CommonVipVO("19954722", "ÌÆöÎ", "sfd", "18805156300", 300, "1997-05-13", VipType.COMMON_VIP);
		assertEquals(commonVipVO.getBirthday(), "1997-05-13");
	}
	
//	@Test
//	OK
//	public void testCreateLevelSystem() throws RemoteException{
//		LevelSystemVO levelSystemVO = new LevelSystemVO(1, 100);
//		vipController.createLevelSystem(levelSystemVO);
//		assertEquals(levelSystemVO.getLevels(), 1);
//	}
}
