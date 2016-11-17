package util;

/**
 * 酒店返回信息
 * 
 */
public class HotelMsg {
	/**
	 * 酒店名称
	 */
	private String name;

	/**
	 * 酒店地址
	 */
	private String address;
	
	/**
	 * 所属商圈
	 */
	private String area;
	
	
	/**
	 * 星级
	 */
	private int level;
	
	/**
	 * 介绍
	 */
	private String introduction;
	
	/**
	 * 服务设施
	 */
	private String facility;
	
	/**
	 * 是否预定
	 */
	private boolean reserve;
	
	
	

	public HotelMsg(String name, String address, String area, int level, String introduction, String facility, boolean reserve) {
		super();
		this.name = name;
		this.address = address;
		this.area= area;
		this.level= level;
		this.introduction=introduction;
		this.facility=facility;
		this.reserve=reserve;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}
	
	public String getArea() {
		return area;
	}
	
	public int getLevel() {
		return level;
	}
	
	public String getIntroduction() {
		return introduction;
	}
	
	public String getFacility() {
		return facility;
	}
	
	public boolean isReserved(){
		return reserve;
	}

	
}
