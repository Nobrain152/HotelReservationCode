package blservice.promotionblservice;

import util.PromotionHotelType;
import util.PromotionWebType;
import vo.CustomerInfoVO;

/**
 * ������ֵ�߼���ӿ�
 * @author T5-SK
 *
 */


import vo.OrderVO;

/**
 * ����������Ժ�ļ۸�
 * @author txin15
 *
 */
public interface PromotionValueBLService {
	
	/**
	 * ����Ƶ�������Ժ�ļ۸�
	 * @param user
	 * @param order
	 * @param hotelType
	 * @return
	 */
	public double getValue(CustomerInfoVO user,OrderVO order,PromotionHotelType hotelType);
	
	/**
	 * ������վ�������Ժ�ļ۸�
	 * @param user
	 * @param order
	 * @param webType
	 * @return
	 */
	public double getValue(CustomerInfoVO user,OrderVO order,PromotionWebType webType);
}
