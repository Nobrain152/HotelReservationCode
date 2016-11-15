package vo;

public class HotelInfoVO{

	/**
	 * ����
	 */
	private String name;

	/**
	 * ��ַ
	 */
	private String address;
	
	/**
	 * ������Ȧ
	 */
	private String area;
	
	
	/**
	 * �Ǽ�
	 */
	private int level;
	
	/**
	 * ���
	 */
	private String introduction;
	
	/**
	 * ������ʩ
	 */
	private String facility;
	

	/**
	 * �Ƿ񶩹�
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