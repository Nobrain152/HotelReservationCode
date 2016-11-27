package blservice.hotelblservice;

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
	public ResultMsg inputHotelInfo(HotelInfoVO hotelInfoVO);
	
	/**
	 * �����Ϣ�Ƿ��������
	 * @param hotelInfoVO
	 * @return
	 */
    public ResultMsg checkInfo(HotelInfoVO hotelInfoVO);
  
}