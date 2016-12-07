package po;

import java.io.Serializable;

/**
 * �Ƶ���Ϣ
 * @author gyf
 *
 */
public class HotelInfoPO implements Serializable{

	
	private static final long serialVersionUID = 1L;

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
	
	private double score;
	
	public HotelInfoPO() {}
	
	public HotelInfoPO(String hotelID,String name, String address, String area, int level, String introduction, String facility, boolean reserve,double score) {
		this.name = name;
		this.address = address;
		this.area= area;
		this.level= level;
		this.introduction=introduction;
		this.facility=facility;
		this.reserve=reserve;
		this.hotelID = hotelID;
		this.score=score;
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

	
	public void setHotelID(String newID) {
		this.hotelID = newID;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}

	public void setAddress(String newAddress) {
		this.address = newAddress;
	}
	
	public void setArea(String newArea) {
		this.area = newArea;
	}
	
	public void setLevel(int newLevel) {
		this.level = newLevel;
	}
	
	public void setIntroduction(String newIntroduction) {
		this.introduction = newIntroduction;
	}
	
	public void setFacility(String newFacility) {
		this.facility = newFacility;
	}
	
	public void setIsReserved(boolean newReserved){
		this.reserve = newReserved;
	}
	
	public double getScore(){
		return score;
	}
	
	public void setScore(double s){
		score=s;
	}
}	