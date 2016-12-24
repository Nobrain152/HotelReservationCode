package blservice.creditblservice;

import java.util.ArrayList;

import po.CreditPO;
import util.ResultMsg;
import vo.CreditVO;
import vo.CustomerInfoVO;

/**
 * ����ҵ���߼��ӿ�
 * @author txin
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
	
	/**
	 * ��������ֵ
	 * @param creditPO
	 * @return
	 */
	public ResultMsg insert(CreditPO creditPO);
	
	/**
	 * ��ȡ�û���һ������ֵ��¼
	 * @param userID
	 * @return
	 */
	public CreditPO get(String userID);

	/**
	 * ��ȡ�û�������ֵ�б�
	 * @param userID
	 * @return
	 */
	public ArrayList<CreditPO> getListByUserID(String userID);
	
}
