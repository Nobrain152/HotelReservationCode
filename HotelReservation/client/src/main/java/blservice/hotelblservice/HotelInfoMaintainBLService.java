package blservice.hotelblservice;

import po.HotelInfoPO;
import util.ResultMsg;
import vo.HotelInfoVO;

/**
 * ά���Ƶ������Ϣ�Ľӿ�
 * @author �ܳ�
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
    
    /**
     * ��ӾƵ�
     * @param hotelInfoVO
     * @return
     */
    public String addHotel(HotelInfoVO hotelInfoVO);
    
    public HotelInfoPO find(String hotelID);
  
}