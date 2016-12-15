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
	public ArrayList<HotelInfoVO> HotelScan();
	
	
	
	/**
	 * ��ӾƵ�	
	 * @param �Ƶ���ϢVO
	 */
	public String HotelAdd(HotelInfoVO vo);
		
	/**
	 * ��ӾƵ깤����Ա
	 * @param �Ƶ�IDVO
	 * @param �û�IDVO
	 */
	public String StuffAdd(StuffInfoVO vo);
		
}