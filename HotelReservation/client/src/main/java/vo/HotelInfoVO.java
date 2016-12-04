package vo;

import java.util.ArrayList;

/**
 * 酒店信息
 * @author 曹畅
 *
 */
public class HotelInfoVO {

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
	
	private ArrayList<OrderVO> order;
	
	public HotelInfoVO(String name, String address, String area, int level, String introduction, String facility, boolean reserve ,String hotelID) {
		this.name = name;
		this.address = address;
		this.area= area;
		this.level= level;
		this.introduction=introduction;
		this.facility=facility;
		this.reserve=reserve;
		this.hotelID = hotelID;
		this.order=new ArrayList<OrderVO>();
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
	
	public ArrayList<OrderVO> getOrder(){
		return order;
	}
	
	public void setOrder(ArrayList<OrderVO> vo){
		this.order=vo;
	}

}	