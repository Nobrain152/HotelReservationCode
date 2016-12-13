package blservice.promotionblservice;

import java.util.ArrayList;

import util.Area;
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
	public ResultMsg changeLevelCut(int level,double ratio);
	
	public ResultMsg changeCircleCut(Area location,double ratio);
	
	public ResultMsg changeWebCustomCut(String timeBegin,String timeOver, double ratio);
	
	//���Ӵ�������
	public ResultMsg addLevelCut(int level,double ratio);
	
	public ResultMsg addCircleCut(Area location,double ratio);
	
	public ResultMsg addWebCustomCut(String timeBegin,String timeOver, double ratio);
	
	//ɾ����������
	public ResultMsg deleteLevelCut(int level);
	
	public ResultMsg deleteCircleCut(Area location);
	
	public ResultMsg deleteWebCustomCut(String timeBegin,String timeOver);
	
	/**
	 * @param type
	 * 0:��ʾ��Ա�ȼ��Żݲ���
	 * 1:��ʾ�ض������Żݲ���
	 * 2:��ʾ�Զ����������
	 * @return ��Ӧ���������б�
	 */
	public ArrayList<PromotionWebVO> getWebPromotion(PromotionWebType type);
}
