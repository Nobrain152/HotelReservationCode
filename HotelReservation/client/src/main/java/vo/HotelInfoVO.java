package vo;

/**
 * �Ƶ���Ϣ
 * @author lenovo
 *
 */
public class HotelInfoVO {

	/**
	 * �Ƶ�����
	 */
	private String name;

	/**
	 * �Ƶ��ַ
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
	
	/**
	 * �Ƶ�ID
	 */
	private String hotelID;
	
	public HotelInfoVO(String name, String address, String area, int level, String introduction, String facility, boolean reserve ,String hotelID) {
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