package blservice.promotionservice;

import java.util.ArrayList;

import util.ResultMsg;
import vo.PromotionHotelVO;

/**
 * �Ƶ���������߼���ӿ�
 * @author kevin
 *
 */

public interface PromotionHotelBLService {
	/**
	 * �޸Ĵ������ԣ������Ƿ��޸ĳɹ�����Ϣ
	 * @param level
	 * @param ratio
	 * @return
	 */
	public ResultMsg changeBirthCut(int level,double ratio);
	
	public ResultMsg changeOverCut(int number,double ratio);
	
	public ResultMsg changeJoin(String businessName,double ratio) ;
	
	public ResultMsg changeHotelCustomCut (String timeBegin,String timeOver, double ratio);

	/**
	 * ���Ӵ�������
	 * @param level
	 * @param ratio
	 * @return
	 */
	public ResultMsg addBirthCut(int level,double ratio);
	
	public ResultMsg addOverCut(int number,double ratio);
	
	public ResultMsg addJoin(String businessName,double ratio) ;
	
	public ResultMsg addHotelCustomCut (String timeBegin,String timeOver, double ratio);
	
	/**
	 * @param type
	 * 0:��ʾ��Ա���մ�������
	 * 1:��ʾ���������Żݲ���
	 * 2:��ʾ������ҵ��������
	 * 3:��ʾ�Զ����������
	 * @return ��Ӧ���������б�
	 */
	public ArrayList<PromotionHotelVO> getHotelPromotion(int type);
}
