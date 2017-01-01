package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;


import bl.BusinessLogicDataFactory;
import bl.VOPOchange;
import bl.creditbl.CreditController;
import bl.hotelbl.HotelEvaluateController;
import bl.hotelbl.HotelInfoCheckController;
import bl.hotelbl.HotelReserveController;
import bl.hotelbl.HotelSearchController;
import bl.orderbl.OrderOnUserController;
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
 * �ͻ���
 * @author �ܳ�
 *
 */
public class Customer extends User {
	private HotelSearchController hotel;
	private HotelEvaluateController eval;
	private ArrayList<HotelInfoVO> hotelInfoVOs;
	private CreditController integral;
	private CustomerManagementDataService userdataservice;
	private OrderOnUserController order;
	private HotelInfoCheckController hotelinfo;
	private HotelReserveController reserve;
	private BusinessLogicDataFactory factory=BusinessLogicDataFactory.getFactory();
	
	/**
	 * ���췽��
	 * @param �û�ID
	 */
	public Customer(CustomerManagementDataService userdataservice){
		super(userdataservice);
		this.userdataservice=userdataservice;
	}
	
	/**
	 * ��������ľƵ������������ط��������ľƵ���ϢVO�б�
	 * @param ɸѡ����VO
	 * @return �Ƶ���ϢVO�б�
	 */
	public ArrayList<HotelInfoVO> hotelSearch(RoomInfoVO vo1,HotelInfoVO vo,String userid)throws RemoteException{
		hotel=(HotelSearchController)factory.getHotelSearchBLService();
		ArrayList<HotelInfoVO> hotelInfoVOs= hotel.selectCondition(vo,vo1);
		ArrayList<OrderVO> ord=this.individualOrderInq(userid);
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
	 * ��������ľƵ�ID���û�ID���ط��������ľƵ���ϢVO�б�
	 * @param ɸѡ����VO
	 * @return �Ƶ���ϢVO�б�
	 */
	public HotelInfoVO hotelDetail(String hotelid,String userid)throws RemoteException{
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
		hotelinfo=(HotelInfoCheckController)factory.getHotelInfoCheckBLService();
		HotelInfoVO vo=hotelinfo.checkHotelInfo(hotelid);
		return vo;
	}
	
	/**
	 * ���ݾƵ�ID���û�ID���ض����б�
	 * @param hotelid
	 * @param userid
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderVO> getHotelOrder(String hotelid,String userid)throws RemoteException{
		ArrayList<OrderVO> ord=individualOrderInq(userid);
		ArrayList<OrderVO> n=new ArrayList<OrderVO>();
		for(OrderVO v:ord){
			if(v.getHotelID().equals(hotelid)){
				n.add(v);
			}
		}
		return n;
	}
	/**
	 * �����������෵���ź���ľƵ��б�
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
	 * ��ĳһ�Ƶ����ɶ���
	 * @param �Ƶ�IDVO
	 * @param ����VO
	 *
	 */
	public ResultMsg orderCreat(String userid,OrderVO vo2)throws RemoteException{
		reserve=(HotelReserveController)factory.getHotelReserveBLService();
		ResultMsg r1=reserve.reserveHotel(vo2);
	    if(r1==ResultMsg.SUCCESS){
	    	order=(OrderOnUserController)factory.getOrderOnUserBLService();
	    	order.createOrder(vo2);
	    	ResultMsg r2=userdataservice.addCustomerHotel(userid,vo2.getHotelID());
	        return r2;
	    }
	    return ResultMsg.FAIL;
		
	}
			

	/**
	 * ���۾Ƶ�	
	 * @param �Ƶ�����VO
	 */
	public void hotelEvaluate(HotelEvaluateVO vo)throws RemoteException{
		eval=(HotelEvaluateController)factory.getHotelEvaluateBLService();
		eval.inputEvaluate(vo);
	}
			
	
	
	

	/**
	 * ��ѯ���˻�����Ϣ
	 * @param userid
	 * @return ���˻�����Ϣ
	 */
	public CustomerInfoVO individualInfolnq(String userid)throws RemoteException{
		CustomerInfoPO userInfoPO = userdataservice.GetCustomerInfo(userid);
		CustomerInfoVO vo = (CustomerInfoVO)VOPOchange.POtoVO(userInfoPO);
		return vo;
	}
			
	/**
	 * �޸ĸ��˻�����Ϣ
	 * @param userid
	 * @param �ͻ�������Ϣ
	 * @return �޸Ľ��
	 */
	public ResultMsg individualInfoMod(String userid,CustomerInfoVO vo2)throws RemoteException{
		CustomerInfoPO past= userdataservice.GetCustomerInfo(userid);
		if((past.getIsMember()!=vo2.getIsMember())||(past.getCredit()!=vo2.getCredit())||(!past.getUserID().equals(vo2.getUserID())||(past.getVipType()!=vo2.getVipType()))){
			return ResultMsg.UNAUYHORIZED;
		}
		if(vo2.getContact()!=null){
			if(vo2.getContact().length()!=11){
				return ResultMsg.WRONG_PHONENUMBER;
			}
			past.setContact(vo2.getContact());
		}
		if(vo2.getUsername()!=null){
			past.setUsername(vo2.getUsername());
		}
		return userdataservice.SetCustomerInfo(userid,past);
		
	}
			
	/**
	 * ��ѯ���˶�����Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<OrderVO> individualOrderInq(String userid)throws RemoteException{
		order=(OrderOnUserController)factory.getOrderOnUserBLService();
		return order.personalOrderScan(userid);
	}
	
	/**
	 * ��ѯ����ĳһ�ඩ����Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<OrderVO> specialOrderInq(String userid,OrderState state)throws RemoteException{
		order=(OrderOnUserController)factory.getOrderOnUserBLService();
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
	 * ��ѯ���˾Ƶ���Ϣ
	 * @param userid
	 * @return ���˾Ƶ���Ϣ�б�
	 */
	public ArrayList<HotelInfoVO> individualHotelInq(String userid)throws RemoteException{
		ArrayList<String> hotel=userdataservice.GetCustomerHotel(userid);
		hotelinfo=(HotelInfoCheckController)factory.getHotelInfoCheckBLService();
		for(int i=0;i<hotel.size();i++){
			hotelInfoVOs.add(hotelinfo.checkHotelInfo(hotel.get(i)));
		}
		return hotelInfoVOs;
	}
	
	/**
	 * ��ѯ����ĳһ��Ƶ���Ϣ
	 * @param userid
	 * @return ���˶����б�
	 */
	public ArrayList<HotelInfoVO> specialHotelInq(String userid,OrderState state)throws RemoteException{
		ArrayList<OrderVO> special=specialOrderInq(userid, state);
		ArrayList<HotelInfoVO> hvo=new ArrayList<HotelInfoVO>();
		hotelinfo=(HotelInfoCheckController)factory.getHotelInfoCheckBLService();
		for(OrderVO vo:special){
			hvo.add(hotelinfo.checkHotelInfo(vo.getHotelID()));
		}
		return hvo;
	}
	
			
	/**
	 * ��ѯ��������
	 * @param userid
	 * @return ����������Ϣ
	 */
	public int individualCredictInq(String userid)throws RemoteException{
		integral=(CreditController)factory.getCreditBLService();
		return	integral.getCredit((CustomerInfoVO)VOPOchange.POtoVO(userdataservice.GetCustomerInfo(userid)));
	}
	
	
	/**
	 * ��ѯ�������ü�¼
	 * @param userid
	 * @return ����������Ϣ
	 */
	public ArrayList<CreditVO> individualCredictRecord(String userid)throws RemoteException{
		integral=(CreditController)factory.getCreditBLService();
		return integral.getCreditList(userid);
	}
	
	/**
	 * �������˶���
	 * @param orderVO
	 * @return
	 */
	public ResultMsg orderCancel(OrderVO orderVO)throws RemoteException{
		order=(OrderOnUserController)factory.getOrderOnUserBLService();
		return order.personalOrderCancel(orderVO);
	}
	
	
	
}
