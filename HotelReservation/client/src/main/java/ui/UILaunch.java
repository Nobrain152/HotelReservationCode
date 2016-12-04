package ui;

import java.io.InputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ui.credit.creditCheckController;
import ui.credit.creditRechargeController;
import ui.customerGuide.customerGuideController;
import ui.customerInfo.customerInfoController;
import ui.customerInfo.customerInfoModifyController;
import ui.customerInfoManage.customerInfoByMController;
import ui.customerInfoManage.customerInfoInquireByMController;
import ui.customerInfoManage.customerInfoModifyByMController;
import ui.hotelAdd.hotelAddController;
import ui.hotelAdd.hotelStuffAddController;
import ui.hotelEvaluate.hotelEvaluateController;
import ui.hotelManaged.hotelInfoMaintainController;
import ui.hotelManaged.hotelManagedInfoController;
import ui.hotelReserve.hotelReserveController;
import ui.hotelSearch.hotelInfoSearchedController;
import ui.hotelSearch.hotelSearchController;
import ui.hotelSearch.hotelSearchListController;
import ui.hotelStuffGuide.hotelStuffGuideController;
import ui.login.loginController;
import ui.orderOnHotel.orderOnHotelController;
import ui.orderOnHotel.orderOnHotelInfoController;
import ui.orderOnHotel.orderOnHotelStateController;
import ui.orderOnUser.orderOnUserCancelController;
import ui.orderOnUser.orderOnUserController;
import ui.orderOnUser.orderOnUserInfoController;
import ui.orderOnWeb.abnormalOrderController;
import ui.orderOnWeb.abnormalOrderInfoController;
import ui.reservedHotel.reservedHotelInfoController;
import ui.reservedHotel.reservedHotelListController;
import ui.roomAdd.roomAddController;
import ui.roomAdd.roomListController;
import ui.vip.vipController;
import ui.webManagerGuide.webManagerGuideController;
import ui.webSalesmanGuide.webSalesmanGuideController;

public class UILaunch extends Application{
	private Stage stage;
	private final int  MINIMUM_WINDOW_WIDTH =800;
	private final int  MINIMUM_WINDOW_HEIGHT =600;
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Parent root = FXMLLoader.load(getClass().getResource("customerGuide/customerGuide.fxml"));
		
		//Scene scene= new Scene(root,MINIMUM_WINDOW_WIDTH,MINIMUM_WINDOW_HEIGHT);
		//stage.setTitle("Welcome");
		//stage.setScene(scene);
		//stage.show();
		
		stage = primaryStage;
		stage.setTitle("DIMENSION");
		stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
		stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
		gotowebManagerGuide();	
		stage.show();
	}
	
	/**
	 * ��ת����¼����
	 */
	public void gotologin(){
		try{
			loginController login=(loginController) replaceSceneContent("login/login.fxml");
			login.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת���ͻ���������
	 */
	public void gotocustomerGuide(){
		try{
			customerGuideController customerGuide=(customerGuideController) replaceSceneContent("customerGuide/customerGuide.fxml");
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
			creditCheckController creditCheck=(creditCheckController) replaceSceneContent("credit/creditCheck.fxml");
			creditCheck.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת��������ֵ����
	 */
	public void gotocreditRechargge(){
		try{
			creditRechargeController creditRecharge=(creditRechargeController) replaceSceneContent("credit/creditRecharge.fxml");
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
			customerInfoController customerInfo=(customerInfoController) replaceSceneContent("customerInfo/customerInfo.fxml");
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
			customerInfoModifyController customerInfoModify=(customerInfoModifyController) replaceSceneContent("customerInfo/customerInfoModify.fxml");
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
			customerInfoByMController customerInfoByM=(customerInfoByMController) replaceSceneContent("customerInfoManage/customerInfoByM.fxml");
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
			customerInfoInquireByMController customerInfoInquireByM=(customerInfoInquireByMController) replaceSceneContent("customerInfoManage/customerInfoInquireByM.fxml");
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
			customerInfoModifyByMController customerInfoModifyByM=(customerInfoModifyByMController) replaceSceneContent("customerInfoManage/customerInfoModifyByM.fxml");
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
			hotelAddController hotelAdd=(hotelAddController) replaceSceneContent("hotelAdd/hotelAdd.fxml");
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
			hotelStuffAddController hotelStuffAdd=(hotelStuffAddController) replaceSceneContent("hotelAdd/hotelStuffAdd.fxml");
			hotelStuffAdd.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת���Ƶ����۽���
	 */
	public void gotohotelEvaluate(){
		try{
			hotelEvaluateController hotelEvaluate=(hotelEvaluateController) replaceSceneContent("hotelEvaluate/hotelEvaluate.fxml");
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
			hotelInfoMaintainController hotelInfoMaintain=(hotelInfoMaintainController) replaceSceneContent("hotelManaged/hotelInfoMaintain.fxml");
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
			hotelManagedInfoController hotelManagedInfo=(hotelManagedInfoController) replaceSceneContent("hotelManaged/hotelManagedInfo.fxml");
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
			hotelReserveController hotelReserve=(hotelReserveController) replaceSceneContent("hotelReserve/hotelReserve.fxml");
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
			hotelInfoSearchedController hotelInfoSearched=(hotelInfoSearchedController) replaceSceneContent("hotelSearch/hotelInfoSearched.fxml");
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
			hotelSearchController hotelSearch=(hotelSearchController) replaceSceneContent("hotelSearch/hotelSearch.fxml");
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
			hotelSearchListController hotelSearchList=(hotelSearchListController) replaceSceneContent("hotelSearch/hotelSearchList.fxml");
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
			hotelStuffGuideController hotelStuffGuide=(hotelStuffGuideController) replaceSceneContent("hotelStuffGuide/hotelStuffGuide.fxml");
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
			orderOnHotelController orderOnHotel=(orderOnHotelController) replaceSceneContent("orderOnHotel/orderOnHotel.fxml");
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
			orderOnHotelInfoController orderOnHotelInfo=(orderOnHotelInfoController) replaceSceneContent("orderOnHotel/orderOnHotelInfo.fxml");
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
			orderOnHotelStateController orderOnHotelState=(orderOnHotelStateController) replaceSceneContent("orderOnHotel/orderOnHotelState.fxml");
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
			orderOnUserController orderOnUser=(orderOnUserController) replaceSceneContent("orderOnUser/orderOnUser.fxml");
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
			orderOnUserInfoController orderOnUserInfo=(orderOnUserInfoController) replaceSceneContent("orderOnUser/orderOnUserInfo.fxml");
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
			orderOnUserCancelController orderOnUserCancel=(orderOnUserCancelController) replaceSceneContent("orderOnUser/orderOnUserCancel.fxml");
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
			abnormalOrderController abnormalOrder=(abnormalOrderController) replaceSceneContent("orderOnWeb/abnormalOrder.fxml");
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
			abnormalOrderInfoController abnormalOrderInfo=(abnormalOrderInfoController) replaceSceneContent("orderOnWeb/abnormalOrderInfo.fxml");
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
			reservedHotelInfoController reservedHotelInfo=(reservedHotelInfoController) replaceSceneContent("reservedHotel/reservedHotelInfo.fxml");
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
			reservedHotelListController reservedHotelList=(reservedHotelListController) replaceSceneContent("reservedHotel/reservedHotelList.fxml");
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
			roomAddController roomAdd=(roomAddController) replaceSceneContent("roomAdd/roomAdd.fxml");
			roomAdd.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת����ӿ��ÿͷ��б����
	 */
	public void gotoroomList(){
		try{
			roomListController roomList=(roomListController) replaceSceneContent("roomAdd/roomList.fxml");
			roomList.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * ��ת��ע���Ա����
	 */
	public void gotovip(){
		try{
			vipController vip=(vipController) replaceSceneContent("vip/vip.fxml");
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
			webManagerGuideController webManagerGuide=(webManagerGuideController) replaceSceneContent("webManagerGuide/webManagerGuide.fxml");
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
			webSalesmanGuideController webSalesmanGuide=(webSalesmanGuideController) replaceSceneContent("webSalesmanGuide/webSalesmanGuide.fxml");
			webSalesmanGuide.setApp(this);
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