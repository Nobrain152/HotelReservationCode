package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import bl.hotelbl.HotelInfoCheckController;
import bl.hotelbl.HotelInfoMaintainController;
import dataservice.userdataservice.UserManagementDataService;
import po.ContactPO;
import po.UserInfoPO;
import util.ResultMsg;
import vo.ContactVO;
import vo.HotelInfoVO;
import vo.UserInfoVO;

/**
 * ��վ������Ա��
 * @author �ܳ�
 * 
 *
 */
public class WebManager extends User {
	private UserManagementDataService data;
	private HotelInfoCheckController check;
	private HotelInfoMaintainController main;
	
	public WebManager(UserManagementDataService data){
		super(data);
		this.data=data;
		check=new HotelInfoCheckController();
		main=new HotelInfoMaintainController();
	}
	/**
	 * �鿴������Ϣ	
	 * @param �û�IDVO
	 * @return �û�������ϢVO
	 */
	public UserInfoVO IndividualBaseInfolnquiry(String userid)throws RemoteException{
		UserInfoPO po= data.GetUserBaseInfo(userid);
		UserInfoVO vo=new UserInfoVO(po.getUserID(),po.getUsername(),(ContactVO)VOPOchange.POtoVO(po.getContact()));
		return vo;
	}
			
	/**
	 * �޸ĸ�����Ϣ	
	 * @param �û�IDVO
	 * @param �û���ϢVO
	 * @return �޸Ľ��
	 */
	public ResultMsg IndividualBaseInfoModification(String userid,UserInfoVO vo2)throws RemoteException{
		UserInfoPO po= new UserInfoPO(vo2.getUserID(),vo2.getUsername(),(ContactPO)VOPOchange.VOtoPO(vo2.getContact()));
		return data.SetUserBaseInfo(userid, po);
	}
		
	/**
	 * ��ӾƵ�	
	 * @param �Ƶ���ϢVO
	 */
	public ResultMsg HotelAdd(HotelInfoVO vo)throws RemoteException{
		return main.addHotel(vo);
	}
			
	/**
	 * ��ӾƵ깤����Ա
	 * @param �Ƶ�IDVO
	 * @param �û�IDVO
	 */
	public boolean StuffAdd(String hotelid,String userid)throws RemoteException{
		return data.addHotelStuff(hotelid,userid);
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
		UserInfoPO po=data.GetUserBaseInfo(userid);
		UserInfoVO vo=new UserInfoVO(po.getUserID(),po.getUsername(),(ContactVO)VOPOchange.POtoVO(po.getContact()));
		return vo;
	}
			
	
	/**
	 * �޸��û���Ϣ
	 * @param �û�IDVO
	 * @param �û�������ϢVO
	 * @return �޸Ľ��
	 */
	public ResultMsg UserInformationModification(String userid,UserInfoVO vo2)throws RemoteException{
		UserInfoPO po1=new UserInfoPO(vo2.getUserID(),vo2.getUsername(),(ContactPO)VOPOchange.VOtoPO(vo2.getContact()));
		return data.SetUserBaseInfo(userid,po1);
	}
			
	/**
	 * �����վӪ����Ա
	 * @param �û�IDVO
	 */
	public boolean WebsiteStuffAdd(String userid)throws RemoteException{
		return data.addWebStuff(userid);
	}

	/**
	 * �鿴��վӪ����Ա�б�
	 * @return ��վӪ����Ա�б�
	 */
	public ArrayList<UserInfoVO> WebStuffScan() throws RemoteException{
		ArrayList<UserInfoPO> pos=data.WebStuffScan();
		ArrayList<UserInfoVO> vos=new ArrayList<UserInfoVO>();
		for(int i=0;i<pos.size();i++){
			vos.add(new UserInfoVO(pos.get(i).getUserID(),pos.get(i).getUsername(),new ContactVO(pos.get(i).getContact().phoneNumber,pos.get(i).getContact().emailAddress)));
		}
		return vos;
	}

}
