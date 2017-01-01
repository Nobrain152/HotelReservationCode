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
	public String name;

	/**
	 * �Ƶ��ַ
	 */
	public Adress address;
	
	/**
	 * ������Ȧ
	 */
	public Area area;
	
	/**
	 * �Ǽ�
	 */
	public int level;
	
	/**
	 * ���
	 */
	public String introduction;
	
	/**
	 * ������ʩ
	 */
	public String facility;

	/**
	 * �Ƿ񶩹�
	 */
	public boolean reserve;
	
	/**
	 * �Ƶ�ID
	 */
	public String hotelID;
	
	/**
	 * ���ڽ������ʱ���ض�Ӧ�û��ڸþƵ�Ķ�����Ϣ
	 */
	public ArrayList<OrderVO> order;
	
	/**
	 * �Ƶ�����
	 */
	public double score;
	
	/**
	 * ��������ʱ����Ƶ���������޺�����
	 */
	public double up;
	
	public double down;
	
	/**
	 * �Ƶ����
	 */
	public int SP;
	
	
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
		this.order=new ArrayList<>();
		this.score=score;
		SP=sp;
	}

	public HotelInfoVO(String name, Adress address, Area area, int level,double up,double down){
		this.name = name;
		this.address = address;
		this.area = area;
		this.level = level;
		this.up = up;
		this.down = down;
	}
	
	public HotelInfoVO(Adress address, Area area){
		this.address=address;
		this.area=area;
		this.name =null;
		this.level= 0;
		this.introduction=null;
		this.facility=null;
		this.reserve=false;
		this.hotelID = null;
		this.order=new ArrayList<>();
		this.score=0;
		this.up = 0;
		this.down = 0;
		SP=0;
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
	
	public void setName(String str){
		name=str;
	}
	
	public void setLevel(int n){
		level=n;
	}
	
	public void setReserve(boolean b){
		reserve=b;
	}

}	