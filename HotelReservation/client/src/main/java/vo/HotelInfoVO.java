package vo;

import java.util.ArrayList;

import util.Adress;
import util.Area;

/**
 * �Ƶ���Ϣ
 * @author �ܳ�
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
	private ArrayList<OrderVO> order;
	
	/**
	 * �Ƶ�����
	 */
	private double score;
	
	/**
	 * ��������ʱ����Ƶ���������޺�����
	 */
	private double up;
	
	private double down;
	
	/**
	 * �Ƶ����
	 */
	private int SP;
	
	
	public HotelInfoVO() {}
	
	public HotelInfoVO(String name, Adress address, Area area, int level, String introduction, String facility, boolean reserve ,String hotelID,double score,int sp) {
		this.name = name;
		this.address = address;
		this.area= area;
		this.level= level;
		this.introduction=introduction;
		this.facility=facility;
		this.reserve=reserve;
		this.hotelID = hotelID;
		this.order=new ArrayList<OrderVO>();
		this.score=score;
		SP=sp;
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
	
	public ArrayList<OrderVO> getOrder(){
		return order;
	}
	
	public void setOrder(ArrayList<OrderVO> vo){
		this.order=vo;
	}
	
	public double getScore(){
		return score;
	}
	
	public void setScore(double s){
		score=s;
	}

	public double getUp(){
		return up;
	}
	
	public void setUp(double s){
		up=s;
	}
	
	public double getDown(){
		return down;
	}
	
	public void setDown(double s){
		down=s;
	}
	
	public int getSP(){
		return SP;
	}
	
	public void setSP(int sp){
		SP=sp;
	}

}	