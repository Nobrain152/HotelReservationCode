package vo;

/**
 * ��¼��Ϣ
 * @author �ܳ�
 *
 */
public class LoginInVO {

    /**
     * �û���
     */
    private String username;
	
	/**
	 * ����
	 */
	private String password;
	
	public LoginInVO() {}
	
	public LoginInVO(String username,String password){
	    this.username = username;
		this.password = password;
	}
	
	public String getUsername(){
	    return username;
	}
	
	public String getPassword(){
	    return password;
	}
}