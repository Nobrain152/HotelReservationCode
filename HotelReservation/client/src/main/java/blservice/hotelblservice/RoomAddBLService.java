package blservice.hotelblservice;

import util.ResultMsg;
import util.RoomMsg;
import vo.RoomInfoVO;

public interface RoomAddBLService {
	
	/**
	 * ��ӿ��ÿͷ�
	 *
	 */
	public RoomMsg addRoom(RoomInfoVO roomInfoVO);
	
	/**
	 * ���¿ͷ���Ϣ
	 * 
	 */
    public ResultMsg updateRoom(RoomInfoVO roomInfoVO);
   
}