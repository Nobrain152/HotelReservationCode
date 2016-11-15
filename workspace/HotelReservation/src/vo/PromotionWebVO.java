package vo;

import businesslogic.util.PromotionWebType;


/**
 * ��վ��������VO
 * 
 * @author kevin
 *
 */

public class PromotionWebVO {
	/**
	 * ������������
	 */
	PromotionWebType WebType;
	
	
	/**
	 * ����������ֹʱ��
	 */
	String timeBegin,timeOver;
	
	/**
	 * �������Դ��۱���
	 */
	double ratio;
	
	public PromotionWebVO(PromotionWebType WebType,String timeBegin,String timeOver,double ratio) {
		// TODO Auto-generated constructor stub
		this.WebType = WebType;
		this.timeBegin = timeBegin;
		this.timeOver = timeOver;
		this.ratio = ratio;
	}
	
	public PromotionWebType getType(){
		return WebType;
	}
	
	public String getTimeBegin() {
        return timeBegin;
    }

    public String getTimeOver() {
        return timeOver;
    }
    public double getRatio() {
		return ratio;
	}
}