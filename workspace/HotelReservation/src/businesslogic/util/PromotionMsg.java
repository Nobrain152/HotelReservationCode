package businesslogic.util;

/**
* 输入促销策略的返回值
*/

public class PromotionMsg {
	/**
	*是否通过该阶段的检查
	*/
	private boolean pass;
	
	/**
	 * 返回的信息
	 */
	private String message;
	
	public PromotionMsg(boolean pass, String message) {
		//这个位置的super不知道有什么用
		this.pass = pass;
		this.message = message;
	}
	
	@Override
	public String toString(){
		return message;
	}
	
    public boolean isPass() {
        return pass;
    }

    public String getMessage() {
        return message;
    }
	
}