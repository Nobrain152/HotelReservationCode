package businesslogicservice.hotelblservice;

import businesslogic.util.ResultMsg;
import businesslogic.util.RoomMsg;
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