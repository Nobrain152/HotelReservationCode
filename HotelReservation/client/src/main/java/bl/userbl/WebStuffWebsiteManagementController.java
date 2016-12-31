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
	public boolean websiteStrategeCreate(PromotionWebVO vo){
		try {
			ResultMsg msg=stuff.websiteStrategeCreate(vo);
			if(msg==ResultMsg.SUCCESS){
				return  true;
			}
			return false;
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
			
		}
	}
	
	/**
	 * �޸���վ��������
	 * @param ��վ��������VO
	 */
	public ResultMsg websiteStrategeMod(PromotionWebVO vo){
		try {
			return stuff.websiteStrategeMod(vo);
		} catch (RemoteException e) {
			return ResultMsg.FAIL;
		}
	}
	
	/**
	 * ɾ����վ��������
	 * @param ��վ��������VO
	 */
	public ResultMsg websiteStrategeDelete(PromotionWebVO vo){
		try {
			return stuff.websiteStrategeDelete(vo);
		} catch (RemoteException e) {
			return ResultMsg.FAIL;
		}
	}
			
	/**
	 * �鿴�쳣����
	 * @return ����VO�б�
	 */
	public ArrayList<OrderVO> abnormalOrderScan(){
		try {
			return stuff.abnormalOrderScan();
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
	public ResultMsg userCreditMod(String userid,int n){
		try {
			return stuff.userCreditMod(userid, n);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}


	/**
	 * �鿴��վӪ������
	 * @return ��վӪ�������б�
	 */
	public ArrayList<PromotionWebVO> websiteStrategeInq(PromotionWebVO vo) {
		try {
			return stuff.websiteStrategeInq(vo);
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
	public int userCreditInq(String userid) {
		try {
			return stuff.userCreditInq(userid);
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
