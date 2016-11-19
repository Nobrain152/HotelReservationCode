package bl.userbl;

import java.util.ArrayList;

import blservice.userblservice.WebManagerHotelOperationBlService;
import data.userdata.UserManagementDataServiceImpl;
import po.HotelIDPO;
import po.UserIDPO;
import vo.HotelIDVO;
import vo.HotelInfoVO;
import vo.UserIDVO;


/**
 * 网站管理人员对酒店的操作
 * @author 曹畅
 *
 */
public class WebManagerHotelOperationController implements WebManagerHotelOperationBlService {

	UserManagementDataServiceImpl check;
	HotelIDPO po;
	UserIDPO po1;
	
	public WebManagerHotelOperationController(){
		check=new UserManagementDataServiceImpl();
	}
	
	/**
	 * 添加酒店	
	 * @param 酒店信息VO
	 */
	public void HotelAdd(HotelInfoVO vo){
		
	}
			
	/**
	 * 添加酒店工作人员
	 * @param 酒店IDVO
	 * @param 用户IDVO
	 */
	public boolean StuffAdd(HotelIDVO vo1,UserIDVO vo2){
		po=new HotelIDPO(vo1.getHotelID());
		po1=new UserIDPO(vo2.getUserID());
		return check.addHotelStuff(po,po1);
	}


	/**
	 * 查看酒店列表
	 * @return 酒店信息列表
	 */
	public ArrayList<HotelInfoVO> HotelScan() {
		// TODO Auto-generated method stub
		return null;
	}

}
