package po;

import java.io.Serializable;

import util.PromotionHotelType;

/**
 * 表示酒店营销策略的PO
 * @author Kevin
 *
 */

public class PromotionHotelPO implements Serializable {
	private static final long serialVersionUID = 5894748451667870139L;
	
	public PromotionHotelPO(String hotel,PromotionHotelType type,String customType,String timeBegin,String timeOver,String ratio) {
		// TODO Auto-generated constructor stub
		super();
		this.hotel = hotel;
		this.type = type;
		this.customType = customType;
		this.timeBegin = timeBegin;
		this.timeOver = timeOver;
		this.ratio = ratio;
	}
	
	/**
	 * 促销策略酒店
	 */
	String hotel;
	
	/**
	 * 促销策略类型
	 */
	PromotionHotelType type = null;
	
	/**
	 * 促销策略适用人群类型
	 */
	String customType = null;
	
	/**
	 * 促销策略开始时间
	 */
	String timeBegin = null;
	
	/**
	 * 促销策略结束时间
	 */
	String timeOver = null;
	
	/**
	 * 促销策略打折比例
	 */
	String ratio = null;
	
	public String getHotelName() {
		return hotel;
	}
	
	public PromotionHotelType getType() {
		return type;
	}
	
	public String getCustomType() {
		return customType;
	}
	
	public String getTimeBegin() {
		return timeBegin;
	}
	
	public String getTimeOver() {
		return timeOver;
	}
	
	public String getRatio() {
		return ratio;
	}
	
}
