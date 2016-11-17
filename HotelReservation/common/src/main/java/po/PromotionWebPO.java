package po;

import java.io.Serializable;

import util.PromotionWebType;

/**
 * 表示酒店营销策略的PO
 * @author kevin
 *
 */

public class PromotionWebPO implements Serializable {
	private static final long serialVersionUID = 5894748451667870139L;
	
	public PromotionWebPO(String hotel,PromotionWebType type,String customType,String timeBegin,String timeOver,String ratio) {
		// TODO Auto-generated constructor stub
		super();
		this.type = type;
		this.customType = customType;
		this.timeBegin = timeBegin;
		this.timeOver = timeOver;
		this.ratio = ratio;
	}
	
	/**
	 * 酒店名称
	 */
	String hotel;
	
	/**
	 * 促销策略类型
	 */
	PromotionWebType type ;
	
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
	
	public PromotionWebType getType() {
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
