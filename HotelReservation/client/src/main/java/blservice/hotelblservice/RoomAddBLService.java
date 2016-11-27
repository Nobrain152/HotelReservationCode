package blservice.hotelblservice;

import util.ResultMsg;
import vo.RoomInfoVO;

/**
 * ��ӿ��ÿͷ��Ľӿ�
 * @author gyf
 *
 */
public interface RoomAddBLService {
	
	/**
	 * ��ӿ��ÿͷ�
	 * @param roomInfoVO
	 * @return
	 */
	public ResultMsg addRoom(RoomInfoVO roomInfoVO);
	
	/**
	 * ���¿ͷ���Ϣ
	 * @param roomInfoVO
	 * @return
	 */
    public ResultMsg updateRoom(RoomInfoVO roomInfoVO);
   
}