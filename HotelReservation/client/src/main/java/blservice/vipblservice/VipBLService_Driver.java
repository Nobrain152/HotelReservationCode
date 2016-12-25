package blservice.vipblservice;

import util.ResultMsg;
import vo.LevelSystemVO;

public class VipBLService_Driver {
	
	public static void main(String[] args){
		
		VipBLService_Stub a=new VipBLService_Stub();
		VipBLService_Driver b=new VipBLService_Driver();
		b.drive(a);
	
	}
	
	public void drive(VipBLService_Stub a){
		
		ResultMsg resultMsg = a.createLevelSystem(new LevelSystemVO(1, 0));
		if(resultMsg == ResultMsg.SUCCESS)
			System.out.println("�ɹ����");
		else
			System.out.println("���ʧ��");
	
	}
}