package blservice.userblservice;

import java.util.ArrayList;

import vo.HotelInfoVO;
import vo.StuffInfoVO;

/**
 * ��վ������Ա�ԾƵ�Ĳ���
 * @author �ܳ�
 *
 */
public interface WebManagerHotelOperationBlService{
	
	/**
	 * �鿴�Ƶ��б�
	 * @return �Ƶ���Ϣ�б�
	 */
	public ArrayList<HotelInfoVO> hotelScan();
	
	
	
	/**
	 * ��ӾƵ�	
	 * @param �Ƶ���ϢVO
	 */
	public String hotelAdd(HotelInfoVO vo);
		
	/**
	 * ��ӾƵ깤����Ա
	 * @param �Ƶ�IDVO
	 * @param �û�IDVO
	 */
	public String stuffAdd(StuffInfoVO vo);
		
}