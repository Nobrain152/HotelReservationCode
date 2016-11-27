package bl.userbl;

import java.util.ArrayList;

import blservice.userblservice.WebManagerHotelOperationBlService;
import vo.HotelInfoVO;


/**
 * 网站管理人员对酒店的操作
 * @author 曹畅
 *
 */
public class WebManagerHotelOperationController implements WebManagerHotelOperationBlService {

	WebManager manager=new WebManager();
	
	/**
	 * 添加酒店	
	 * @param 酒店信息VO
	 */
	public void HotelAdd(HotelInfoVO vo){
		manager.HotelAdd(vo);
	}
			
	/**
	 * 添加酒店工作人员
	 * @param 酒店IDVO
	 * @param 用户IDVO
	 */
	public boolean StuffAdd(String hotelid,String userid){
		return manager.StuffAdd(hotelid, userid);
	}


	/**
	 * 查看酒店列表
	 * @return 酒店信息列表
	 */
	public ArrayList<HotelInfoVO> HotelScan() {
		return manager.HotelScan();
	}

}
