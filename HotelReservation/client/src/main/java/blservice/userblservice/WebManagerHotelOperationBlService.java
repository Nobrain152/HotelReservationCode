package blservice.userblservice;

import java.util.ArrayList;

import vo.HotelIDVO;
import vo.HotelInfoVO;
import vo.UserIDVO;


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
	public void HotelAdd(HotelInfoVO vo);
		
	/**
	 * ��ӾƵ깤����Ա
	 * @param �Ƶ�IDVO
	 * @param �û�IDVO
	 */
	public boolean StuffAdd(HotelIDVO vo1,UserIDVO vo2);
		
}