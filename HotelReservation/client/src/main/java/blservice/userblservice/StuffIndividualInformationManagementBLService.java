package blservice.userblservice;

import vo.StuffInfoVO;


/**
 * 酒店管理人员管理个人信息
 * @author Administrator
 *
 */
public interface StuffIndividualInformationManagementBLService{
        
	/**
	 * 查看个人基本信息
	 * @param 用户IDVO
	 * @return 酒店管理人员信息VO
	 */
	public StuffInfoVO IndividualBaseInfolnquiry(String userid);
		
	/**
	 * 修改个人信息
	 * @param 用户IDVO
	 * @param 酒店管理人员信息VO
	 * @return 修改结果
	 */
	public boolean IndividualBaseInfoModification(String userid,StuffInfoVO vo2);
		
}