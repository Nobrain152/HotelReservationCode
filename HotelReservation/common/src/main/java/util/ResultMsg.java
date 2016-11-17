package util;

/**
 * ���붩���ȵķ�����Ϣ
 * 
 * @author txin
 *
 */
public class ResultMsg {
	/**
	 * �Ƿ�ͨ���ý׶εļ��
	 */
	private boolean pass;
	
	/**
	 * ���ص���Ϣ
	 */
	private String message;
	
	public ResultMsg(boolean pass, String message) {
		super();
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
