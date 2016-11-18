package bl.userbl;

import java.util.ArrayList;

import blservice.userblservice.WebManagerHotelOperationBlService;
import data.userdata.UserManagementDataServiceImpl;
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
		return check.addHotelStuff(vo1,vo2);
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
