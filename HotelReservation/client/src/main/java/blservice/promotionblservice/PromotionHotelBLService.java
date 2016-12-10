package blservice.promotionblservice;

import java.util.ArrayList;

import util.PromotionHotelType;
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
	public ResultMsg changeBirthCut(int level,double ratio,String hotelID);
	
	public ResultMsg changeOverCut(int number,double ratio,String hotelID);
	
	public ResultMsg changeJoin(String businessName,double ratio,String hotelID) ;
	
	public ResultMsg changeHotelCustomCut (String timeBegin,String timeOver, double ratio,String hotelID);

	/**
	 * ���Ӵ�������
	 * @param level
	 * @param ratio
	 * @return
	 */
	public ResultMsg addBirthCut(int level,double ratio,String hotelID);
	
	public ResultMsg addOverCut(int number,double ratio,String hotelID);
	
	public ResultMsg addJoin(String businessName,double ratio,String hotelID) ;
	
	public ResultMsg addHotelCustomCut(String timeBegin,String timeOver, double ratio,String hotelID);
	
	//ɾ����������
	public ResultMsg deleteBirthCut(int level, String hotelID);
	
	public ResultMsg deleteOverCut(int number, String hotelID);
	
	public ResultMsg deleteJoin(String businessName, String hotelID);
	
	public ResultMsg deleteHotelCustomCut(String timeBegin,String timeOver, String hotelID);
	
	/**
	 * @param type
	 * 0:��ʾ��Ա���մ�������
	 * 1:��ʾ���������Żݲ���
	 * 2:��ʾ������ҵ��������
	 * 3:��ʾ�Զ����������
	 * @return ��Ӧ���������б�
	 */
	public ArrayList<PromotionHotelVO> getHotelPromotion(PromotionHotelType type,String hotelID);
}
