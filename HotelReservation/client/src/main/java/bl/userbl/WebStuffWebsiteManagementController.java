package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.userblservice.WebStuffWebsiteManagementBLService;
import dataservice.userdataservice.UserManagementDataService;
import net.RMIManage;
import util.DataServiceType;
import util.ResultMsg;
import vo.OrderVO;
import vo.PromotionWebVO;


/**
 * ��վӪ����Ա����վ�Ĳ���
 * @author �ܳ�
 *
 */
public class WebStuffWebsiteManagementController implements WebStuffWebsiteManagementBLService {

	private WebStuff stuff;
	private UserManagementDataService data;
	
	
	public WebStuffWebsiteManagementController(){
		data= (UserManagementDataService)RMIManage.
				getDataService(DataServiceType.UserManagementDataService);
		stuff=new WebStuff(data);
	}
	
	/**
	 * ������վ��������
	 * @param ��վ��������VO
	 */
	public void WebsiteStrategeCreate(PromotionWebVO vo){
		try {
			stuff.WebsiteStrategeCreate(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �޸���վ��������
	 * @param ��վ��������VO
	 */
	public ResultMsg WebsiteStrategeMod(PromotionWebVO vo){
		try {
			return stuff.WebsiteStrategeMod(vo);
		} catch (RemoteException e) {
			return ResultMsg.FAIL;
		}
	}
	
	/**
	 * ɾ����վ��������
	 * @param ��վ��������VO
	 */
	public ResultMsg WebsiteStrategeDelete(PromotionWebVO vo){
		try {
			return stuff.WebsiteStrategeDelete(vo);
		} catch (RemoteException e) {
			return ResultMsg.FAIL;
		}
	}
			
	/**
	 * �鿴�쳣����
	 * @return ����VO�б�
	 */
	public ArrayList<OrderVO> AbnormalOrderScan(){
		try {
			return stuff.AbnormalOrderScan();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
			
	/**
	 * �޸��û�����ֵ
	 * @param �û�IDVO
	 * @param ����ֵ
	 * @return �޸ĺ���û�����ֵVO
	 */
	public ResultMsg UserCreditModification(String userid,int n){
		try {
			return stuff.UserCreditModification(userid, n);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}


	/**
	 * �鿴��վӪ������
	 * @return ��վӪ�������б�
	 */
	public ArrayList<PromotionWebVO> WebsiteStrategeInquire(PromotionWebVO vo) {
		try {
			return stuff.WebsiteStrategeInquire(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * �鿴�û�����ֵ��Ϣ
	 * @param �û�IDVO
	 * @return �û�������ϢVO
	 */
	public int userCreditInquire(String userid) {
		try {
			return stuff.userCreditInquire(userid);
		} catch (RemoteException e) {
			e.printStackTrace();
			return -10000000;
		}
	}
	
	
	/**
	 * ���ÿ��δִ�ж���
	 * @param today
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderVO> dayUnexOrder(String today){
		try {
			return stuff.dayUnexOrder(today);
		} catch (RemoteException e) {
			return null;
		}
	}
}
