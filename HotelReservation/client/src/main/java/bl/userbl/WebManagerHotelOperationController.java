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
 * ��վ������Ա�ԾƵ�Ĳ���
 * @author �ܳ�
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
	 * ��ӾƵ�	
	 * @param �Ƶ���ϢVO
	 */
	public void HotelAdd(HotelInfoVO vo){
		
	}
			
	/**
	 * ��ӾƵ깤����Ա
	 * @param �Ƶ�IDVO
	 * @param �û�IDVO
	 */
	public boolean StuffAdd(HotelIDVO vo1,UserIDVO vo2){
		po=new HotelIDPO(vo1.getHotelID());
		po1=new UserIDPO(vo2.getUserID());
		return check.addHotelStuff(po,po1);
	}


	/**
	 * �鿴�Ƶ��б�
	 * @return �Ƶ���Ϣ�б�
	 */
	public ArrayList<HotelInfoVO> HotelScan() {
		// TODO Auto-generated method stub
		return null;
	}

}
