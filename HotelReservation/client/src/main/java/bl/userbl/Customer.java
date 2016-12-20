package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;


import bl.BusinessLogicDataFactory;
import bl.VOPOchange;
import blservice.creditblservice.CreditBLService;
import blservice.hotelblservice.HotelEvaluateBLService;
import blservice.hotelblservice.HotelInfoCheckBLService;
import blservice.hotelblservice.HotelReserveBLService;
import blservice.hotelblservice.HotelSearchBLService;
import blservice.orderblservice.OrderOnUserBLService;
import dataservice.userdataservice.CustomerManagementDataService;
import po.CustomerInfoPO;
import util.OrderState;
import util.ResultMsg;
import util.Sort;
import vo.CustomerInfoVO;
import vo.HotelEvaluateVO;
import vo.HotelInfoVO;
import vo.CreditVO;
import vo.OrderVO;
import vo.RoomInfoVO;
/**
 * 客户类
 * @author 曹畅
 *
 */
public class Customer extends User {
	private HotelSearchBLService hotel;
	private HotelEvaluateBLService eval;
	private ArrayList<HotelInfoVO> hotelInfoVOs;
	private CreditBLService integral;
	private CustomerManagementDataService userdataservice;
	private OrderOnUserBLService order;
	private HotelInfoCheckBLService hotelinfo;
	private HotelReserveBLService reserve;
	private BusinessLogicDataFactory factory;
	
	/**
	 * 构造方法
	 * @param 用户ID
	 */
	public Customer(CustomerManagementDataService userdataservice){
		super(userdataservice);
		factory=BusinessLogicDataFactory.getFactory();
		hotel=factory.getHotelSearchBLService();
		eval=factory.getHotelEvaluateBLService();
		order=factory.getOrderOnUserBLService();
		hotelinfo=factory.getHotelInfoCheckBLService();
		this.userdataservice=userdataservice;
		integral=factory.getCreditBLService();
		reserve=factory.getHotelReserveBLService();
	}
	
	/**
	 * 根据输入的酒店搜索条件返回符合条件的酒店信息VO列表
	 * @param 筛选条件VO
	 * @return 酒店信息VO列表
	 */
	public ArrayList<HotelInfoVO> HotelSearch(RoomInfoVO vo1,HotelInfoVO vo,String userid)throws RemoteException{
		ArrayList<HotelInfoVO> hotelInfoVOs= hotel.selectCondition(vo,vo1);
		ArrayList<OrderVO> ord=this.IndividualOrderInquiry(userid);
		for(HotelInfoVO v:hotelInfoVOs){
			String hotelid=v.getHotelID();
			ArrayList<OrderVO> hotelorder=new ArrayList<OrderVO>();
			for(OrderVO v1:ord){
				if(hotelid.equals(v1.hotelID)){
					hotelorder.add(v1);
				}
			}
			v.setOrder(hotelorder);
		}
		if(vo.getIsReserved()==true){
			ArrayList<String> r=userdataservice.GetCustomerHotel(userid);
			for(int i=0;i<hotelInfoVOs.size();i++){
				boolean remo=true;
				for(int j=0;j<r.size();j++){
					if(hotelInfoVOs.get(i).getHotelID().equals(r.get(j))){
						remo=false;
						break;
					}
				}
				if(remo){
					hotelInfoVOs.remove(i);
				}
			}
		}
		return hotelInfoVOs;
	}		
	
	
	
	/**
	 * 根据输入的酒店ID和用户ID返回符合条件的酒店信息VO列表
	 * @param 筛选条件VO
	 * @return 酒店信息VO列表
	 */
	public HotelInfoVO HotelDetail(String hotelid,String userid)throws RemoteException{
		ArrayList<String> hotel=userdataservice.GetCustomerHotel(userid);
		boolean wrong=true;
		for(String s:hotel){
			if(s.equals(hotelid)){
				wrong=false;
				break;
			}
		}
		if(wrong){
			return null;
		}
		HotelInfoVO vo=hotelinfo.checkHotelInfo(hotelid);
		ArrayList<OrderVO> ord=IndividualOrderInquiry(userid);
		ArrayList<OrderVO> n=new ArrayList<OrderVO>();
		for(OrderVO v:ord){
			if(v.getHotelID().equals(hotelid)){
				n.add(v);
			}
		}
		vo.setOrder(n);
		return vo;
	}
	/**
	 * 根据排序种类返回排好序的酒店列表
	 * @param before
	 * @param type
	 * @return
	 */
	public ArrayList<HotelInfoVO> sortHotel(ArrayList<HotelInfoVO> before,Sort type){
		HotelInfoVO temp;
		if(type==Sort.Price_DownToUp){
			for(int i=0;i<before.size();i++){
				for(int j=0;j<before.size();j++){
					if(before.get(i).getSP()>before.get(j).getSP()){
						temp=before.get(i);
						before.set(i,before.get(j));
						before.set(j,temp);
					}
				}
			}
			return before;
		}
		
		if(type==Sort.Price_UpToDown){
			for(int i=0;i<before.size();i++){
				for(int j=0;j<before.size();j++){
					if(before.get(i).getSP()<before.get(j).getSP()){
						temp=before.get(i);
						before.set(i,before.get(j));
						before.set(j,temp);
					}
				}
			}
			return before;
		}
		
		if(type==Sort.Score_DownToUp){
			for(int i=0;i<before.size();i++){
				for(int j=0;j<before.size();j++){
					if(before.get(i).getScore()>before.get(j).getScore()){
						temp=before.get(i);
						before.set(i,before.get(j));
						before.set(j,temp);
					}
				}
			}
			return before;
		}
		
		if(type==Sort.Score_UpToDown){
			for(int i=0;i<before.size();i++){
				for(int j=0;j<before.size();j++){
					if(before.get(i).getScore()<before.get(j).getScore()){
						temp=before.get(i);
						before.set(i,before.get(j));
						before.set(j,temp);
					}
				}
			}
			return before;
		}
		
		if(type==Sort.Star_DownToUp){
			for(int i=0;i<before.size();i++){
				for(int j=0;j<before.size();j++){
					if(before.get(i).getLevel()>before.get(j).getLevel()){
						temp=before.get(i);
						before.set(i,before.get(j));
						before.set(j,temp);
					}
				}
			}
			return before;
		}
		
		else{
			for(int i=0;i<before.size();i++){
				for(int j=0;j<before.size();j++){
					if(before.get(i).getLevel()<before.get(j).getLevel()){
						temp=before.get(i);
						before.set(i,before.get(j));
						before.set(j,temp);
					}
				}
			}
			return before;
		}
		
	}
	
	/**
	 * 对某一酒店生成订单
	 * @param 酒店IDVO
	 * @param 订单VO
	 *
	 */
	public ResultMsg OederCreat(String userid,OrderVO vo2)throws RemoteException{
	    ResultMsg r1=reserve.reserveHotel(vo2);
	    if(r1==ResultMsg.SUCCESS){
	    	order.createOrder(vo2);
	    	ResultMsg r2=userdataservice.addCustomerHotel(userid,vo2.getHotelID());
	        return r2;
	    }
	    return ResultMsg.FAIL;
		
	}
			

	/**
	 * 评价酒店	
	 * @param 酒店评价VO
	 */
	public void HotelEvaluate(HotelEvaluateVO vo)throws RemoteException{
		eval.inputEvaluate(vo);
	}
			
	
	
	

	/**
	 * 查询个人基本信息
	 * @param userid
	 * @return 个人基本信息
	 */
	public CustomerInfoVO IndividualBaseInfolnquiry(String userid)throws RemoteException{
		CustomerInfoPO userInfoPO = userdataservice.GetCustomerInfo(userid);
		CustomerInfoVO vo = (CustomerInfoVO)VOPOchange.POtoVO(userInfoPO);
		return vo;
	}
			
	/**
	 * 修改个人基本信息
	 * @param userid
	 * @param 客户基本信息
	 * @return 修改结果
	 */
	public ResultMsg IndividualBaseInfoModification(String userid,CustomerInfoVO vo2)throws RemoteException{
		CustomerInfoPO past= userdataservice.GetCustomerInfo(userid);
		if((past.getIsMember()!=vo2.getIsMember())||(past.getCredit()!=vo2.getCredit())||(!past.getUserID().equals(vo2.getUserID())||(past.getVipType()!=vo2.getVipType()))){
			return ResultMsg.UNAUYHORIZED;
		}
		CustomerInfoPO po2 = (CustomerInfoPO)VOPOchange.VOtoPO(vo2);
		return userdataservice.SetCustomerInfo(userid, po2);
		
	}
			
	/**
	 * 查询个人订单信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<OrderVO> IndividualOrderInquiry(String userid)throws RemoteException{
		return order.personalOrderScan(userid);
	}
	
	/**
	 * 查询个人某一类订单信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<OrderVO> SpecialOrderInquiry(String userid,OrderState state)throws RemoteException{
		ArrayList<OrderVO> all= order.personalOrderScan(userid);
		ArrayList<OrderVO> special=new ArrayList<OrderVO>();
		for(OrderVO vo:all){
			if(vo.getOrderState()==state){
				special.add(vo);
			}
		}
		return special;
	}
	
	
	
	
	/**
	 * 查询个人酒店信息
	 * @param userid
	 * @return 个人酒店信息列表
	 */
	public ArrayList<HotelInfoVO> IndividualHotelInquiry(String userid)throws RemoteException{
		ArrayList<String> hotel=userdataservice.GetCustomerHotel(userid);
		for(int i=0;i<hotel.size();i++){
			hotelInfoVOs.add(hotelinfo.checkHotelInfo(hotel.get(i)));
		}
		return hotelInfoVOs;
	}
	
	/**
	 * 查询个人某一类酒店信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<HotelInfoVO> SpecialHotelInquiry(String userid,OrderState state)throws RemoteException{
		ArrayList<OrderVO> special=SpecialOrderInquiry(userid, state);
		ArrayList<HotelInfoVO> hvo=new ArrayList<HotelInfoVO>();
		for(OrderVO vo:special){
			hvo.add(hotelinfo.checkHotelInfo(vo.getHotelID()));
		}
		return hvo;
	}
	
			
	/**
	 * 查询个人信用
	 * @param userid
	 * @return 个人信用信息
	 */
	public int IndividualCredictInquiry(String userid)throws RemoteException{
		return 	integral.getCredit((CustomerInfoVO)VOPOchange.POtoVO(userdataservice.GetCustomerInfo(userid)));
	}
	
	
	/**
	 * 查询个人信用记录
	 * @param userid
	 * @return 个人信用信息
	 */
	public ArrayList<CreditVO> IndividualCredictRecord(String userid)throws RemoteException{
		return 	integral.getCreditList(userid);
	}
	
	/**
	 * 撤销个人订单
	 * @param orderVO
	 * @return
	 */
	public ResultMsg personalOrderCancel(OrderVO orderVO)throws RemoteException{
		return order.personalOrderCancel(orderVO);
	}
	
	
	
}
