package blservice.promotionservice;

import java.util.ArrayList;

import util.PromotionWebType;
import util.ResultMsg;
import vo.PromotionWebVO;

/**
 * ��վ�������Խӿ�
 * @author kevin
 *
 */


public interface PromotionWebBLService {
	//�޸Ĵ�������
	public ResultMsg changeLevelCut(int level,double ratio,String hotelID);
	
	public ResultMsg changeCircleCut(String location,double ratio,String hotelID);
	
	public ResultMsg changeWebCustomCut(String timeBegin,String timeOver, double ratio,String hotelID);
	
	//���Ӵ�������
	public ResultMsg addLevelCut(int level,double ratio,String hotelID);
	
	public ResultMsg addCircleCut(String location,double ratio,String hotelID);
	
	public ResultMsg addWebCustomCut(String timeBegin,String timeOver, double ratio,String hotelID);
	
	/**
	 * @param type
	 * 0:��ʾ��Ա�ȼ��Żݲ���
	 * 1:��ʾ�ض������Żݲ���
	 * 2:��ʾ�Զ����������
	 * @return ��Ӧ���������б�
	 */
	public ArrayList<PromotionWebVO> getWebPromotion(PromotionWebType type,String hotelID);
}
