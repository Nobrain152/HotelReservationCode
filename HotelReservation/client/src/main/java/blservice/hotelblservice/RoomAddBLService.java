package blservice.hotelblservice;

import util.ResultMsg;
import util.RoomMsg;
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
	public RoomMsg addRoom(RoomInfoVO roomInfoVO);
	
	/**
	 * ���¿ͷ���Ϣ
	 * @param roomInfoVO
	 * @return
	 */
    public ResultMsg updateRoom(RoomInfoVO roomInfoVO);
   
}