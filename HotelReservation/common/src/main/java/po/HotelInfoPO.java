package po;

import java.io.Serializable;

/**
 * 酒店信息
 * @author gyf
 *
 */
public class HotelInfoPO implements Serializable{

	
	private static final long serialVersionUID = 1L;

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
	 * 简介
	 */
	private String introduction;
	
	/**
	 * 服务设施
	 */
	private String facility;

	/**
	 * 是否订过
	 */
	private boolean reserve;
	
	/**
	 * 酒店ID
	 */
	private String hotelID;
	
	public HotelInfoPO(String name, String address, String area, int level, String introduction, String facility, boolean reserve ,String hotelID) {
		this.name = name;
		this.address = address;
		this.area= area;
		this.level= level;
		this.introduction=introduction;
		this.facility=facility;
		this.reserve=reserve;
		this.hotelID = hotelID;
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
	
	public boolean getIsReserved(){
		return reserve;
	}

	public String getHotelID() {
		return hotelID;
	}

}	