package blservice.promotionservice;

import java.util.ArrayList;

import util.PromotionMsg;
import vo.PromotionHotelVO;

/**
 * �Ƶ���������߼���ӿ�
 * @author kevin
 *
 */

public interface PromotionHotelBLService {
	//�޸Ĵ������ԣ������Ƿ��޸ĳɹ�����Ϣ
	public PromotionMsg changeBirthCut(int level,double ratio);
	
	public PromotionMsg changeOverCut(int number,double ratio);
	
	public PromotionMsg changeJoin(String businessName,double ratio) ;
	
	public PromotionMsg changeHotelCustomCut (String timeBegin,String timeOver, double ratio);
	//���Ӵ�������
	public PromotionMsg addBirthCut(int level,double ratio);
	
	public PromotionMsg addOverCut(int number,double ratio);
	
	public PromotionMsg addJoin(String businessName,double ratio) ;
	
	public PromotionMsg addHotelCustomCut (String timeBegin,String timeOver, double ratio);
	
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
