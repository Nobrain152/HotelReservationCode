package vo;

public class HotelInfoVO{

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 地址
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
	
	
	
	public HotelInfoVO(String name, String address, String area, int level, String introduction, String facility, boolean reserve) {
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