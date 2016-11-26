package po;

import java.io.Serializable;

/**
 * ��¼��Ϣ
 * @author lenovo
 *
 */
public class LoginInPO implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * �û���
     */
    private String username;
	
	/**
	 * ����
	 */
	private String password;
	
	public LoginInPO(String username,String password){
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