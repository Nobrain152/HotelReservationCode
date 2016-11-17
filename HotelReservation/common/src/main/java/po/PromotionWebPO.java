package po;

import java.io.Serializable;

import util.PromotionWebType;

/**
 * ��ʾ�Ƶ�Ӫ�����Ե�PO
 * @author kevin
 *
 */

public class PromotionWebPO implements Serializable {
	private static final long serialVersionUID = 5894748451667870139L;
	
	public PromotionWebPO(String hotel,PromotionWebType type,String customType,String timeBegin,String timeOver,String ratio) {
		// TODO Auto-generated constructor stub
		super();
		this.type = type;
		this.customType = customType;
		this.timeBegin = timeBegin;
		this.timeOver = timeOver;
		this.ratio = ratio;
	}
	
	/**
	 * �Ƶ�����
	 */
	String hotel;
	
	/**
	 * ������������
	 */
	PromotionWebType type ;
	
	/**
	 * ��������������Ⱥ����
	 */
	String customType = null;
	
	/**
	 * �������Կ�ʼʱ��
	 */
	String timeBegin = null;
	
	/**
	 * �������Խ���ʱ��
	 */
	String timeOver = null;
	
	/**
	 * �������Դ��۱���
	 */
	String ratio = null;
	
	public PromotionWebType getType() {
		return type;
	}
	
	public String getCustomType() {
		return customType;
	}
	
	public String getTimeBegin() {
		return timeBegin;
	}
	
	public String getTimeOver() {
		return timeOver;
	}
	
	public String getRatio() {
		return ratio;
	}
	
}
