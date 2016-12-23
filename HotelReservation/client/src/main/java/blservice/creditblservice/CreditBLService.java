package blservice.creditblservice;

import java.util.ArrayList;

import po.CreditPO;
import util.ResultMsg;
import vo.CreditVO;
import vo.CustomerInfoVO;

/**
 * ����ҵ���߼��ӿ�
 * @author kevin
 *
 */
public interface CreditBLService{
	/**
	 * �������ֵ
	 * 
	 */
	public int getCredit(CustomerInfoVO client);
	
	/**
	 * ��������ֵ
	 */
	public ResultMsg addCredit(CustomerInfoVO client,int value);
	
	/**
	 * ��������ֵ
	 */
	public ResultMsg subCredit(CustomerInfoVO client,int value);
	
	/**
	 * �޸�����ֵ
	 */
	public ResultMsg changeCredit(CustomerInfoVO client,int value);

	/**
	 * ��ȡ����ֵ�б�
	 * @param userID
	 * @return
	 */
	public ArrayList<CreditVO> getCreditList(String userID);
	
	public ResultMsg insert(CreditPO creditPO);
	
	public CreditPO get(String userID);

	public ArrayList<CreditPO> getListByUserID(String userID);
	
}
