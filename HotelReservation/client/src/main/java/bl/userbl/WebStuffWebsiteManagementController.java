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
 * 网站营销人员对网站的操作
 * @author 曹畅
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
	 * 创建网站促销策略
	 * @param 网站促销策略VO
	 */
	public void WebsiteStrategeCreate(PromotionWebVO vo){
		try {
			stuff.WebsiteStrategeCreate(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
			
	/**
	 * 查看异常订单
	 * @return 订单VO列表
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
	 * 修改用户信用值
	 * @param 用户IDVO
	 * @param 增加值
	 * @return 修改后的用户信用值VO
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
	 * 查看网站营销策略
	 * @return 网站营销策略列表
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
	 * 查看用户信用值信息
	 * @param 用户IDVO
	 * @return 用户信用信息VO
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
	 * 网站营销人员查看申诉列表
	 *
	 * @param void
	 * @return 申诉列表
	 * @throws RemoteException 
	 */
	public ArrayList<OrderVO> complaintListScan(){
		try {
			return stuff.complaintListScan();
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * 网站营销人员处理申诉
	 *
	 * @param orderVO 订单VO
	 * @return 系统提示消息
	 * @throws RemoteException 
	 */
	public ResultMsg complaintHandle(OrderVO orderVO,double rate){
		try {
			return stuff.complaintHandle(orderVO, rate);
		} catch (RemoteException e) {
			return ResultMsg.FAIL;
		}
	}
	
	/**
	 * 浏览每日未执行订单
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
