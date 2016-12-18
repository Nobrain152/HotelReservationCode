package po;

import java.io.Serializable;
import java.util.ArrayList;

import util.Adress;
import util.Area;


/**
 * �Ƶ���Ϣ
 * @author �ܳ�
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
	private Adress address;
	
	/**
	 * ������Ȧ
	 */
	private Area area;
	
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
	
	/**
	 * ���ڽ������ʱ���ض�Ӧ�û��ڸþƵ�Ķ�����Ϣ
	 */
	public ArrayList<OrderPO> order;
	
	/**
	 * �Ƶ�����
	 */
	private double score;
	/**
	 * �Ƶ����
	 */
	private int SP;
	
	public HotelInfoPO() {}
	
	public HotelInfoPO(String hotelID,String name, Adress address, Area area, int level, String introduction, String facility, boolean reserve,double score,int SP) {
		this.name = name;
		this.address = address;
		this.area= area;
		this.level= level;
		this.introduction=introduction;
		this.facility=facility;
		this.reserve=reserve;
		this.hotelID = hotelID;
		this.score=score;
		this.SP=SP;
	}

	public String getName() {
		return name;
	}

	public Adress getAddress() {
		return address;
	}
	
	public Area getArea() {
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

	public void setAddress(Adress newAddress) {
		this.address = newAddress;
	}
	
	public void setArea(Area newArea) {
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
	
	public int getSP(){
		return SP;
	}
	
	public void setSP(int sp){
		SP=sp;
	}
	
	public ArrayList<OrderPO> getOrder(){
		return order;
	}
	
	public void setOrder(ArrayList<OrderPO> vo){
		this.order=vo;
	}
}	