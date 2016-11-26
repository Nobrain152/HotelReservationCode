package blservice.hotelblservice;

import util.HotelMsg;
import util.ResultMsg;
import vo.HotelInfoVO;

/**
 * ά���Ƶ������Ϣ�Ľӿ�
 * @author gyf
 *
 */
public interface HotelInfoMaintainBLService {
	
	/**
	 * ����Ƶ���Ϣ
	 * @param hotelInfoVO
	 * @return
	 */
	public HotelMsg inputHotelInfo(HotelInfoVO hotelInfoVO);
	
	/**
	 * �����Ϣ�Ƿ��������
	 * @param hotelInfoVO
	 * @return
	 */
    public ResultMsg checkInfo(HotelInfoVO hotelInfoVO);
  
}