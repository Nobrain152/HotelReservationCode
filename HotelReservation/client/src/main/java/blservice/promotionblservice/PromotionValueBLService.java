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

public interface PromotionValueBLService {
	
	public double getValue(CustomerInfoVO user,OrderVO order,PromotionHotelType hotelType);
	
	public double getValue(CustomerInfoVO user,OrderVO order,PromotionWebType webType);
}
