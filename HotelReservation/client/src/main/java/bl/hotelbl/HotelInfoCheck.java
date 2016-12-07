
package bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import dataservice.hoteldataservice.HotelInfoDataService;
import po.HotelInfoPO;
import vo.HotelInfoVO;

/**
 * �鿴�Ƶ���Ϣ
 * @author �ܳ�
 *
 */
public class HotelInfoCheck {
	
	private HotelInfoDataService hotelData;
	
	public HotelInfoCheck(HotelInfoDataService hotelDataService){
		this.hotelData = hotelDataService;
	}
	
	/**
	 * �鿴�Ƶ���Ϣ
	 * @param hotelInfoVO
	 * @return
	 * @throws RemoteException
	 */
	public HotelInfoVO checkHotelInfo(String hotelid) throws RemoteException{
		HotelInfoPO hotelInfoPO = hotelData.find(hotelid);
    	return (HotelInfoVO)VOPOchange.POtoVO(hotelInfoPO);
    }
	
	
	/**
	 * �鿴����ע��ľƵ��б�
	 * @return
	 */
	public ArrayList<HotelInfoVO> hotelScan()throws RemoteException{
		ArrayList<HotelInfoVO> vos=new ArrayList<HotelInfoVO>();
		ArrayList<HotelInfoPO> pos=hotelData.show();
		for(int i=0;i<pos.size();i++){
			vos.add((HotelInfoVO)VOPOchange.POtoVO(pos.get(i)));
		}
		return vos;
	}
}
