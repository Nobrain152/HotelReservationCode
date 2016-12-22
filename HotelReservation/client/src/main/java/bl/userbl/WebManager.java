package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessLogicDataFactory;
import bl.VOPOchange;
import blservice.hotelblservice.HotelInfoCheckBLService;
import blservice.hotelblservice.HotelInfoMaintainBLService;
import dataservice.userdataservice.UserManagementDataService;
import po.CustomerInfoPO;
import po.StuffInfoPO;
import po.UserInfoPO;
import util.ResultMsg;
import util.UserType;
import vo.HotelInfoVO;
import vo.StuffInfoVO;
import vo.UserInfoVO;

/**
 * ��վ������Ա��
 * @author �ܳ�
 * 
 *
 */
public class WebManager extends User {
	private UserManagementDataService data;
	private HotelInfoCheckBLService check;
	private HotelInfoMaintainBLService main;
	private BusinessLogicDataFactory factory;
	
	public WebManager(UserManagementDataService data){
		super(data);
		factory=BusinessLogicDataFactory.getFactory();
		this.data=data;
		check=factory.getHotelInfoCheckBLService();
		main=factory.getHotelInfoMaintainBLService();
	}
	/**
	 * �鿴������Ϣ	
	 * @param �û�IDVO
	 * @return �û�������ϢVO
	 */
	public UserInfoVO IndividualBaseInfolnquiry(String userid)throws RemoteException{
		UserInfoPO po= data.GetWebManagerInfo(userid);
		UserInfoVO vo=(UserInfoVO)VOPOchange.POtoVO(po);
		return vo;
	}
			
	/**
	 * �޸ĸ�����Ϣ	
	 * @param �û�IDVO
	 * @param �û���ϢVO
	 * @return �޸Ľ��
	 */
	public ResultMsg IndividualBaseInfoModification(String userid,UserInfoVO vo2)throws RemoteException{
		UserInfoPO past= data.GetWebManagerInfo(userid);
		past.setType(UserType.WebManager);
		if(vo2.getContact()!=null){
			if(vo2.getContact().length()!=11){
				return ResultMsg.WRONG_PHONENUMBER;
			}
			past.setContact(vo2.getContact());
		}
		if(vo2.getUsername()!=null){
			past.setUsername(vo2.getUsername());
		}
		return data.SetWebManagerInfo(userid, past);
	}
		
	/**
	 * ��ӾƵ�	
	 * @param �Ƶ���ϢVO
	 */
	public String HotelAdd(HotelInfoVO vo)throws RemoteException{
		return main.addHotel(vo);
	}
			
	/**
	 * ��ӾƵ깤����Ա
	 * @param �Ƶ�IDVO
	 * @param �û�IDVO
	 */
	public String StuffAdd(StuffInfoVO vo)throws RemoteException{
		ArrayList<StuffInfoPO> already=data.HotelStuffScan();
		for(StuffInfoPO p:already){
			if(p.getHotel().equals(vo.getHotel()))
				return null;
		}
		StuffInfoPO po=(StuffInfoPO)VOPOchange.VOtoPO(vo);
		po.setPassword(MD5Util.md5Encode(po.getPassword()));
		String id= data.AddHotelStuff(po);
		return id;
	}


	/**
	 * �鿴�Ƶ��б�
	 * @return �Ƶ���Ϣ�б�
	 */
	public ArrayList<HotelInfoVO> HotelScan()throws RemoteException {
		return check.hotelScan();
	}
	
	/**
	 * �鿴�û�������Ϣ
	 * @param �û�IDVO
	 * @return �û�������ϢVO
	 */
	public UserInfoVO UserInformationInquiry(String userid)throws RemoteException{
		char c=userid.charAt(0);
		UserInfoPO po;
		switch(c){
		case'1': po=data.GetCustomerInfo(userid);break;
		case'2': po=data.GetHotelStuffInfo(userid);break;
		case'3': po=data.GetWebStuffInfo(userid);break;
		case'4': po=data.GetWebManagerInfo(userid);break;
		default: po=null;
		}
		UserInfoVO vo=(UserInfoVO)VOPOchange.POtoVO(po);
		return vo;
	}
			
	
	/**
	 * �޸��û���Ϣ
	 * @param �û�IDVO
	 * @param �û�������ϢVO
	 * @return �޸Ľ��
	 */
	public ResultMsg UserInformationModification(String userid,UserInfoVO vo2)throws RemoteException{
		UserInfoPO po1=(UserInfoPO)VOPOchange.VOtoPO(vo2);
		char c=userid.charAt(0);
		CustomerInfoPO cu;
		StuffInfoPO stuff;
		UserInfoPO user;
		if(c=='1'){
			cu=data.GetCustomerInfo(userid);
			cu.setType(UserType.Customer);
			if(po1.getContact()!=null){
				if(po1.getContact().length()!=11){
					return ResultMsg.WRONG_PHONENUMBER;
				}
				cu.setContact(po1.getContact());
			}
			if(po1.getUsername()!=null){
				cu.setUsername(po1.getUsername());
			}
			return data.SetCustomerInfo(userid,cu);
		}
		if(c=='2'){
			stuff=data.GetHotelStuffInfo(userid);
			stuff.setType(UserType.HotelStuff);
			if(po1.getContact()!=null){
				if(po1.getContact().length()!=11){
					return ResultMsg.WRONG_PHONENUMBER;
				}
				stuff.setContact(po1.getContact());
			}
			if(po1.getUsername()!=null){
				stuff.setUsername(po1.getUsername());
			}
			return data.SetHotelStuffInfo(userid, stuff);
		}
		if(c=='3'){
			user=data.GetWebStuffInfo(userid);
			user.setType(UserType.WebStuff);
			if(po1.getContact()!=null){
				if(po1.getContact().length()!=11){
					return ResultMsg.WRONG_PHONENUMBER;
				}
				user.setContact(po1.getContact());
			}
			if(po1.getUsername()!=null){
				user.setUsername(po1.getUsername());
			}
			//return ResultMsg.SUCCESS;
			return data.SetWebStuffInfo(userid, user);
		}
		if(c=='4'){
			user=data.GetWebManagerInfo(userid);
			user.setType(UserType.WebManager);
			if(po1.getContact()!=null){
				if(po1.getContact().length()!=11){
					return ResultMsg.WRONG_PHONENUMBER;
				}
				user.setContact(po1.getContact());
			}
			if(po1.getUsername()!=null){
				user.setUsername(po1.getUsername());
			}
			return data.SetWebManagerInfo(userid, user);
		}
		
		return ResultMsg.FAIL;
		
		
	}
			
	/**
	 * �����վӪ����Ա
	 * @param vo
	 * @return
	 */
	public String AddWebStuff(UserInfoVO vo)throws RemoteException{
		vo.setType(UserType.WebStuff);
		UserInfoPO po=(UserInfoPO)VOPOchange.VOtoPO(vo);
		po.setPassword(MD5Util.md5Encode(po.getPassword()));
		String id= data.AddWebStuff(po);
		return id;
	}
	

	/**
	 * �鿴��վӪ����Ա�б�
	 * @return ��վӪ����Ա�б�
	 */
	public ArrayList<UserInfoVO> WebStuffScan() throws RemoteException{
		ArrayList<UserInfoPO> pos=data.WebStuffScan();
		ArrayList<UserInfoVO> vos=new ArrayList<UserInfoVO>();
		for(int i=0;i<pos.size();i++){
			vos.add((UserInfoVO)VOPOchange.POtoVO(pos.get(i)));
		}
		return vos;
	}

}
