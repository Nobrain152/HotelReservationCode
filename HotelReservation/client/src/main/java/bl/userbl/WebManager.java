package bl.userbl;

import java.util.ArrayList;

import bl.VOPOchange;
import data.userdata.UserManagementDataServiceImpl;
import po.ContactPO;
import po.UserInfoPO;
import vo.ContactVO;
import vo.HotelInfoVO;
import vo.UserInfoVO;

public class WebManager extends User {
	private UserManagementDataServiceImpl user=new UserManagementDataServiceImpl();
	
	/**
	 * �鿴������Ϣ	
	 * @param �û�IDVO
	 * @return �û�������ϢVO
	 */
	public UserInfoVO IndividualBaseInfolnquiry(String userid){
		UserInfoPO po= user.GetUserBaseInfo(userid);
		UserInfoVO vo=new UserInfoVO(po.getUserID(),po.getUsername(),(ContactVO)VOPOchange.POtoVO(po.getContact()));
		return vo;
	}
			
	/**
	 * �޸ĸ�����Ϣ	
	 * @param �û�IDVO
	 * @param �û���ϢVO
	 * @return �޸Ľ��
	 */
	public boolean IndividualBaseInfoModification(String userid,UserInfoVO vo2){
		UserInfoPO po= new UserInfoPO(vo2.getUserID(),vo2.getUsername(),(ContactPO)VOPOchange.VOtoPO(vo2.getContact()));
		return user.SetUserBaseInfo(userid, po);
	}
		
	/**
	 * ��ӾƵ�	
	 * @param �Ƶ���ϢVO
	 */
	public void HotelAdd(HotelInfoVO vo){
		
	}
			
	/**
	 * ��ӾƵ깤����Ա
	 * @param �Ƶ�IDVO
	 * @param �û�IDVO
	 */
	public boolean StuffAdd(String hotelid,String userid){
		return user.addHotelStuff(hotelid,userid);
	}


	/**
	 * �鿴�Ƶ��б�
	 * @return �Ƶ���Ϣ�б�
	 */
	public ArrayList<HotelInfoVO> HotelScan() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * �鿴�û�������Ϣ
	 * @param �û�IDVO
	 * @return �û�������ϢVO
	 */
	public UserInfoVO UserInformationInquiry(String userid){
		UserInfoPO po=user.GetUserBaseInfo(userid);
		UserInfoVO vo=new UserInfoVO(po.getUserID(),po.getUsername(),(ContactVO)VOPOchange.POtoVO(po.getContact()));
		return vo;
	}
			
	
	/**
	 * �޸��û���Ϣ
	 * @param �û�IDVO
	 * @param �û�������ϢVO
	 * @return �޸Ľ��
	 */
	public boolean UserInformationModification(String userid,UserInfoVO vo2){
		UserInfoPO po1=new UserInfoPO(vo2.getUserID(),vo2.getUsername(),(ContactPO)VOPOchange.VOtoPO(vo2.getContact()));
		return user.SetUserBaseInfo(userid,po1);
	}
			
	/**
	 * �����վӪ����Ա
	 * @param �û�IDVO
	 */
	public boolean WebsiteStuffAdd(String userid){
		return user.addWebStuff(userid);
	}

	/**
	 * �鿴��վӪ����Ա�б�
	 * @return ��վӪ����Ա�б�
	 */
	public ArrayList<UserInfoVO> WebStuffScan() {
		// TODO Auto-generated method stub
		return null;
	}

}
