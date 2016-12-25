package blservice.userblservice;

import java.util.ArrayList;

import util.ResultMsg;
import vo.UserInfoVO;

public class WebManagerWebsiteManagementBLService_Driver {

	 public static void main(String[] args){
			
		 WebManagerWebsiteManagementBLService a=new WebManagerWebsiteManagementBLService_Stub();
		 WebManagerWebsiteManagementBLService_Driver b=new WebManagerWebsiteManagementBLService_Driver();
		   b.drive(a);
		
		}
		
		public void drive(WebManagerWebsiteManagementBLService a){
			ArrayList<UserInfoVO> u;
			
			u=a.WebStuffScan();
			UserInfoVO uu=a.UserInformationInquiry("32345678");
			ResultMsg res=a.UserInformationModification("32345678",new UserInfoVO());
			String ss=a.AddWebStuff(new UserInfoVO());
		}
}
