package blservice.userblservice;

import java.util.ArrayList;

import po.CustomerInfoPO;
import util.ResultMsg;
import vo.CreditVO;
import vo.CustomerInfoVO;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.UserInfoVO;

public class CustomerIndividualInformationManagementBLService_Driver {
	 public static void main(String[] args){
			
		   CustomerIndividualInformationManagementBLService a=new CustomerIndividualInformationManagementBLService_Stub();
		   CustomerIndividualInformationManagementBLService_Driver b=new CustomerIndividualInformationManagementBLService_Driver();
		   b.drive(a);
		
		}
		
		public void drive(CustomerIndividualInformationManagementBLService a){
			UserInfoVO user=a.IndividualBaseInfolnquiry("12345678");
			ResultMsg res=a.IndividualBaseInfoModification("12345678",new CustomerInfoVO());
			res=a.personalOrderCancel(new OrderVO());
			CustomerInfoPO cu=a.getCustomerInfo("12345678");
			CustomerInfoVO cu1=a.IndividualBaseInfolnquiry("12345678");
			res=a.IndividualBaseInfoModification("12345678",new CustomerInfoVO());
			ArrayList<OrderVO> o=a.IndividualOrderInquiry("12345678");
			o=a.AbnormalOrderInquiry("12345678");
			o=a.CancelOrderInquiry("12345678");
			o=a.finishedOrderInquiry("12345678");
			o=a.UnfinishedOrderInquiry("12345678");
			ArrayList<HotelInfoVO> h=a.IndividualHotelInquiry("12345678");
			o=a.AbnormalOrderInquiry("12345678");
			o=a.CancelOrderInquiry("12345678");
			o=a.finishedOrderInquiry("12345678");
			o=a.UnfinishedOrderInquiry("12345678");
			int n=a.IndividualCredictInquiry("12345678");
			ArrayList<CreditVO> c=a.IndividualCredictRecord("12345678");
			res=a.personalOrderCancel(new OrderVO());
			a.setCustomerInfo("12345678",new CustomerInfoPO());
		}
}
