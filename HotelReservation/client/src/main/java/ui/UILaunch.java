package ui;

import java.io.InputStream;

import bl.Update;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ui.credit.creditCheckViewController;
import ui.credit.creditRechargeViewController;
import ui.customerGuide.customerGuideViewController;
import ui.customerInfo.customerInfoModifyViewController;
import ui.customerInfo.customerInfoViewController;
import ui.customerInfoManage.customerInfoByMViewController;
import ui.customerInfoManage.customerInfoInquireByMViewController;
import ui.customerInfoManage.customerInfoModifyByMViewController;
import ui.hotelAdd.hotelAddViewController;
import ui.hotelAdd.hotelStuffAddViewController;
import ui.hotelAdd.hotelStuffInquireViewController;
import ui.hotelAdd.hotelStuffModifyViewController;
import ui.hotelEvaluate.hotelEvaluateViewController;
import ui.hotelManaged.hotelInfoMaintainViewController;
import ui.hotelManaged.hotelManagedInfoViewController;
import ui.hotelReserve.hotelReserveViewController;
import ui.hotelSearch.hotelInfoSearchedViewController;
import ui.hotelSearch.hotelSearchListViewController;
import ui.hotelSearch.hotelSearchViewController;
import ui.hotelStuffGuide.hotelStuffGuideViewController;
import ui.login.loginViewController;
import ui.login.registerViewController;
import ui.orderOnHotel.orderOnHotelInfoViewController;
import ui.orderOnHotel.orderOnHotelStateViewController;
import ui.orderOnHotel.orderOnHotelViewController;
import ui.orderOnUser.orderOnUserCancelViewController;
import ui.orderOnUser.orderOnUserInfoViewController;
import ui.orderOnUser.orderOnUserViewController;
import ui.orderOnWeb.abnormalOrderInfoViewController;
import ui.orderOnWeb.abnormalOrderViewController;
import ui.promotionHotel.promotionHotelBirthdayViewController;
import ui.promotionHotel.promotionHotelDIYViewController;
import ui.promotionHotel.promotionHotelEnterpriseViewController;
import ui.promotionHotel.promotionHotelRoomViewController;
import ui.promotionHotel.promotionHotelViewController;
import ui.promotionWeb.promotionWebAreaViewController;
import ui.promotionWeb.promotionWebDIYViewController;
import ui.promotionWeb.promotionWebVIPViewController;
import ui.promotionWeb.promotionWebViewController;
import ui.reservedHotel.reservedHotelInfoViewController;
import ui.reservedHotel.reservedHotelListViewController;
import ui.roomAdd.roomAddViewController;
import ui.roomAdd.roomListViewController;
import ui.roomAdd.roomModifyViewController;
import ui.vip.vipInfoViewController;
import ui.vip.vipRegisterViewController;
import ui.webManagerGuide.webManagerGuideViewController;
import ui.webSalesman.webSalesmanAddViewController;
import ui.webSalesman.webSalesmanInquireViewController;
import ui.webSalesman.webSalesmanModifyViewController;
import ui.webSalesmanGuide.webSalesmanGuideViewController;

public class UILaunch extends Application{
	private Stage stage;
	private final int  MINIMUM_WINDOW_WIDTH =800;
	private final int  MINIMUM_WINDOW_HEIGHT =600;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//Update update=new Update();
		//update.run();
		
		stage = primaryStage;
		stage.setTitle("DIMENSION");
		stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
		stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
		gotologin();	
		stage.show();
	}
	
	/**
	 * ��ת����¼����
	 */
	public void gotologin(){
		try{
			loginViewController login=(loginViewController) replaceSceneContent("login/login.fxml");
			login.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת��ע�����
	 */
	public void gotoregister(){
		try{
			registerViewController register=(registerViewController) replaceSceneContent("login/register.fxml");
			register.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת���ͻ���������
	 */
	public void gotocustomerGuide(){
		try{
			customerGuideViewController customerGuide=(customerGuideViewController) replaceSceneContent("customerGuide/customerGuide.fxml");
			customerGuide.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת�������鿴����
	 */
	public void gotocreditCheck(){
		try{
			creditCheckViewController creditCheck=(creditCheckViewController) replaceSceneContent("credit/creditCheck.fxml");
			creditCheck.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת��������ֵ����
	 */
	public void gotocreditRecharge(){
		try{
			creditRechargeViewController creditRecharge=(creditRechargeViewController) replaceSceneContent("credit/creditRecharge.fxml");
			creditRecharge.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת���ͻ���Ϣ����
	 */
	public void gotocustomerInfo(){
		try{
			customerInfoViewController customerInfo=(customerInfoViewController) replaceSceneContent("customerInfo/customerInfo.fxml");
			customerInfo.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	/**
	 * ��ת���ͻ���Ϣ�޸Ľ���
	 */
	public void gotocustomerInfoModify(){
		try{
			customerInfoModifyViewController customerInfoModify=(customerInfoModifyViewController) replaceSceneContent("customerInfo/customerInfoModify.fxml");
			customerInfoModify.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת����վ������Ա�ӽ��µĿͻ���Ϣ����
	 */
	public void gotocustomerInfoByM(){
		try{
			customerInfoByMViewController customerInfoByM=(customerInfoByMViewController) replaceSceneContent("customerInfoManage/customerInfoByM.fxml");
			customerInfoByM.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת����վ������Ա�ӽ��µĿͻ���Ϣ��ѯ����
	 */
	public void gotocustomerInfoInquireByM(){
		try{
			customerInfoInquireByMViewController customerInfoInquireByM=(customerInfoInquireByMViewController) replaceSceneContent("customerInfoManage/customerInfoInquireByM.fxml");
			customerInfoInquireByM.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת����վ������Ա�ӽ��µĿͻ���Ϣ�޸Ľ���
	 */
	public void gotocustomerInfoModifyByM(){
		try{
			customerInfoModifyByMViewController customerInfoModifyByM=(customerInfoModifyByMViewController) replaceSceneContent("customerInfoManage/customerInfoModifyByM.fxml");
			customerInfoModifyByM.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת���Ƶ���ӽ���
	 */
	public void gotohotelAdd(){
		try{
			hotelAddViewController hotelAdd=(hotelAddViewController) replaceSceneContent("hotelAdd/hotelAdd.fxml");
			hotelAdd.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת���Ƶ깤����Ա��ӽ���
	 */
	public void gotohotelStuffAdd(){
		try{
			hotelStuffAddViewController hotelStuffAdd=(hotelStuffAddViewController) replaceSceneContent("hotelAdd/hotelStuffAdd.fxml");
			hotelStuffAdd.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת���Ƶ깤����Ա��ѯ����
	 */
	public void gotohotelStuffInquire(){
		try{
			hotelStuffInquireViewController hotelStuffInquire=(hotelStuffInquireViewController) replaceSceneContent("hotelAdd/hotelStuffInquire.fxml");
			hotelStuffInquire.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת���Ƶ깤����Ա�޸Ľ���
	 */
	public void gotohotelStuffModify(){
		try{
			hotelStuffModifyViewController hotelStuffModify=(hotelStuffModifyViewController) replaceSceneContent("hotelAdd/hotelStuffModify.fxml");
			hotelStuffModify.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת����վӪ����Ա��ӽ���
	 */
	public void gotowebSalesmanAdd(){
		try{
			webSalesmanAddViewController webSalesmanAdd=(webSalesmanAddViewController) replaceSceneContent("webSalesman/webSalesmanAdd.fxml");
			webSalesmanAdd.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת����վӪ����Ա��ѯ����
	 */
	public void gotowebSalesmanInquire(){
		try{
			webSalesmanInquireViewController webSalesmanInquire=(webSalesmanInquireViewController) replaceSceneContent("webSalesman/webSalesmanInquire.fxml");
			webSalesmanInquire.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת����վӪ����Ա�޸Ľ���
	 */
	public void gotowebSalesmanModify(){
		try{
			webSalesmanModifyViewController webSalesmanModify=(webSalesmanModifyViewController) replaceSceneContent("webSalesman/webSalesmanModify.fxml");
			webSalesmanModify.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת���Ƶ����۽���
	 */
	public void gotohotelEvaluate(){
		try{
			hotelEvaluateViewController hotelEvaluate=(hotelEvaluateViewController) replaceSceneContent("hotelEvaluate/hotelEvaluate.fxml");
			hotelEvaluate.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת��ά���Ƶ������Ϣ����
	 */
	public void gotohotelInfoMaintain(){
		try{
			hotelInfoMaintainViewController hotelInfoMaintain=(hotelInfoMaintainViewController) replaceSceneContent("hotelManaged/hotelInfoMaintain.fxml");
			hotelInfoMaintain.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת������ľƵ����
	 */
	public void gotohotelManagedInfo(){
		try{
			hotelManagedInfoViewController hotelManagedInfo=(hotelManagedInfoViewController) replaceSceneContent("hotelManaged/hotelManagedInfo.fxml");
			hotelManagedInfo.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת���Ƶ�Ԥ������
	 */
	public void gotohotelReserve(){
		try{
			hotelReserveViewController hotelReserve=(hotelReserveViewController) replaceSceneContent("hotelReserve/hotelReserve.fxml");
			hotelReserve.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת���������ľƵ���Ϣ����
	 */
	public void gotohotelInfoSearched(){
		try{
			hotelInfoSearchedViewController hotelInfoSearched=(hotelInfoSearchedViewController) replaceSceneContent("hotelSearch/hotelInfoSearched.fxml");
			hotelInfoSearched.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת���Ƶ���������
	 */
	public void gotohotelSearch(){
		try{
			hotelSearchViewController hotelSearch=(hotelSearchViewController) replaceSceneContent("hotelSearch/hotelSearch.fxml");
			hotelSearch.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת���������ľƵ��б����
	 */
	public void gotohotelSearchList(){
		try{
			hotelSearchListViewController hotelSearchList=(hotelSearchListViewController) replaceSceneContent("hotelSearch/hotelSearchList.fxml");
			hotelSearchList.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת���Ƶ깤����Ա��������
	 */
	public void gotohotelStuffGuide(){
		try{
			hotelStuffGuideViewController hotelStuffGuide=(hotelStuffGuideViewController) replaceSceneContent("hotelStuffGuide/hotelStuffGuide.fxml");
			hotelStuffGuide.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת���Ƶ궩������
	 */
	public void gotoorderOnHotel(){
		try{
			orderOnHotelViewController orderOnHotel=(orderOnHotelViewController) replaceSceneContent("orderOnHotel/orderOnHotel.fxml");
			orderOnHotel.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת���Ƶ궩���������
	 */
	public void gotoorderOnHotelInfo(){
		try{
			orderOnHotelInfoViewController orderOnHotelInfo=(orderOnHotelInfoViewController) replaceSceneContent("orderOnHotel/orderOnHotelInfo.fxml");
			orderOnHotelInfo.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת���Ƶ궩��״̬�޸Ľ���
	 */
	public void gotoorderOnHotelState(){
		try{
			orderOnHotelStateViewController orderOnHotelState=(orderOnHotelStateViewController) replaceSceneContent("orderOnHotel/orderOnHotelState.fxml");
			orderOnHotelState.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
		
	/**
	 * ��ת���û���������
	 */
	public void gotoorderOnUser(){
		try{
			orderOnUserViewController orderOnUser=(orderOnUserViewController) replaceSceneContent("orderOnUser/orderOnUser.fxml");
			orderOnUser.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת���û������������
	 */
	public void gotoorderOnUserInfo(){
		try{
			orderOnUserInfoViewController orderOnUserInfo=(orderOnUserInfoViewController) replaceSceneContent("orderOnUser/orderOnUserInfo.fxml");
			orderOnUserInfo.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת���û�������������
	 */
	public void gotoorderOnUserCancel(){
		try{
			orderOnUserCancelViewController orderOnUserCancel=(orderOnUserCancelViewController) replaceSceneContent("orderOnUser/orderOnUserCancel.fxml");
			orderOnUserCancel.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת���쳣��������������
	 */
	public void gotoabnormalOrder(){
		try{
			abnormalOrderViewController abnormalOrder=(abnormalOrderViewController) replaceSceneContent("orderOnWeb/abnormalOrder.fxml");
			abnormalOrder.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת���쳣������Ϣ����
	 */
	public void gotoabnormalOrderInfo(){
		try{
			abnormalOrderInfoViewController abnormalOrderInfo=(abnormalOrderInfoViewController) replaceSceneContent("orderOnWeb/abnormalOrderInfo.fxml");
			abnormalOrderInfo.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת��Ԥ�����ľƵ���Ϣ����
	 */
	public void gotoreservedHotelInfo(){
		try{
			reservedHotelInfoViewController reservedHotelInfo=(reservedHotelInfoViewController) replaceSceneContent("reservedHotel/reservedHotelInfo.fxml");
			reservedHotelInfo.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת��Ԥ�����ľƵ��б����
	 */
	public void gotoreservedHotelList(){
		try{
			reservedHotelListViewController reservedHotelList=(reservedHotelListViewController) replaceSceneContent("reservedHotel/reservedHotelList.fxml");
			reservedHotelList.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת����ӿ��ÿͷ�����
	 */
	public void gotoroomAdd(){
		try{
			roomAddViewController roomAdd=(roomAddViewController) replaceSceneContent("roomAdd/roomAdd.fxml");
			roomAdd.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת���޸Ŀͷ���Ϣ����
	 */
	public void gotoroomModify(){
		try{
			roomModifyViewController roomModify=(roomModifyViewController) replaceSceneContent("roomAdd/roomModify.fxml");
			roomModify.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	/**
	 * ��ת����ӿ��ÿͷ��б����
	 */
	public void gotoroomList(){
		try{
			roomListViewController roomList=(roomListViewController) replaceSceneContent("roomAdd/roomList.fxml");
			roomList.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת��ע���Ա����
	 */
	public void gotovipRegister(){
		try{
			vipRegisterViewController vip=(vipRegisterViewController) replaceSceneContent("vip/vipRegister.fxml");
			vip.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת����Ա��Ϣ����
	 */
	public void gotovipInfo(){
		try{
			vipInfoViewController vip=(vipInfoViewController) replaceSceneContent("vip/vipInfo.fxml");
			vip.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת����վ������Ա��������
	 */
	public void gotowebManagerGuide(){
		try{
			webManagerGuideViewController webManagerGuide=(webManagerGuideViewController) replaceSceneContent("webManagerGuide/webManagerGuide.fxml");
			webManagerGuide.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת����վӪ����Ա��������
	 */
	public void gotowebSalesmanGuide(){
		try{
			webSalesmanGuideViewController webSalesmanGuide=(webSalesmanGuideViewController) replaceSceneContent("webSalesmanGuide/webSalesmanGuide.fxml");
			webSalesmanGuide.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת���Ƶ��Żݲ��Խ���
	 */
	public void gotopromotionHotel(){
		try{
			promotionHotelViewController promotionHotel=(promotionHotelViewController) replaceSceneContent("promotionHotel/promotionHotel.fxml");
			promotionHotel.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת����վ�Żݲ��Խ���
	 */
	public void gotopromotionWeb(){
		try{
			promotionWebViewController promotionWeb=(promotionWebViewController) replaceSceneContent("promotionWeb/promotionWeb.fxml");
			promotionWeb.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void gotopromotionHotelBirthday(){
		try{
			promotionHotelBirthdayViewController promotionHotelBirthday=(promotionHotelBirthdayViewController) replaceSceneContent("promotionHotel/promotionHotelBirthday.fxml");
			promotionHotelBirthday.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void gotopromotionHotelDIY(){
		try{
			promotionHotelDIYViewController promotionHotelDIY=(promotionHotelDIYViewController) replaceSceneContent("promotionHotel/promotionHotelDIY.fxml");
			promotionHotelDIY.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void gotopromotionHotelEnterprise(){
		try{
			promotionHotelEnterpriseViewController promotionHotelEnterprise=(promotionHotelEnterpriseViewController) replaceSceneContent("promotionHotel/promotionHotelEnterprise.fxml");
			promotionHotelEnterprise.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void gotopromotionHotelRoom(){
		try{
			promotionHotelRoomViewController promotionHotelRoom=(promotionHotelRoomViewController) replaceSceneContent("promotionHotel/promotionHotelRoom.fxml");
			promotionHotelRoom.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void gotopromotionWebArea(){
		try{
			promotionWebAreaViewController promotionWebArea=(promotionWebAreaViewController) replaceSceneContent("promotionWeb/promotionWebArea.fxml");
			promotionWebArea.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void gotopromotionWebDIY(){
		try{
			promotionWebDIYViewController promotionWebDIY=(promotionWebDIYViewController) replaceSceneContent("promotionWeb/promotionWebDIY.fxml");
			promotionWebDIY.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void gotopromotionWebVIP(){
		try{
			promotionWebVIPViewController promotionWebVIP=(promotionWebVIPViewController) replaceSceneContent("promotionWeb/promotionWebVIP.fxml");
			promotionWebVIP.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
    private Initializable replaceSceneContent(String fxml) throws Exception{
    	FXMLLoader loader = new FXMLLoader();
		InputStream in = UILaunch.class.getResourceAsStream(fxml);
		loader.setBuilderFactory(new JavaFXBuilderFactory());
		loader.setLocation(UILaunch.class.getResource(fxml));
		AnchorPane page;
		try{
			page = (AnchorPane) loader.load(in);
		} finally {
			in.close();
		}
		Scene scene = new Scene(page,MINIMUM_WINDOW_WIDTH,MINIMUM_WINDOW_HEIGHT);
		stage.setScene(scene);
		stage.sizeToScene();
		return (Initializable)loader.getController();
	}
    
	public static void main(String[] args){
		launch(args);
	}
	

}