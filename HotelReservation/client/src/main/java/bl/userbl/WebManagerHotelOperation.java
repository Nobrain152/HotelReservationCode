package bl.userbl;

import java.util.ArrayList;

import blservice.userblservice.WebManagerHotelOperationBlService;
import data.userdata.UserManagementDataServiceImpl;
import po.UserIDPO;
import vo.HotelInfoVO;
import vo.UserIDVO;


/**
 * ��վ������Ա�ԾƵ�Ĳ���
 * @author �ܳ�
 *
 */
public class WebManagerHotelOperation implements WebManagerHotelOperationBlService {

	UserManagementDataServiceImpl check;
	String po;
	UserIDPO po1;
	
	public WebManagerHotelOperation(){
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
	public boolean StuffAdd(HotelInfoVO vo1,UserIDVO vo2){
		po = vo1.getHotelID();
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
