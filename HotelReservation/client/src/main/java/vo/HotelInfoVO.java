package vo;

import java.util.ArrayList;

import util.Adress;
import util.Area;

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
	private Adress address;
	
	/**
	 * 所属商圈
	 */
	private Area area;
	
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
	
	/**
	 * 用于界面调用时返回对应用户在该酒店的订单信息
	 */
	private ArrayList<OrderVO> order;
	
	/**
	 * 酒店评分
	 */
	private double score;
	
	/**
	 * 用于搜索时保存频分区间上限和下限
	 */
	private double up;
	
	private double down;
	
	/**
	 * 酒店起价
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