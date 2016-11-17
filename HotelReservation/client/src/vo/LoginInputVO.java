package vo;

public class LoginInputVO{

    private String userid;
	
	private String userpassword;
	
	public LoginInputVO(String userid,String userpassword){
	    this.userid=userid;
		this.userpassword=userpassword;
	}
	
	public String getUserid(){
	    return userid;
	}
	
	public String getUserpassword(){
	    return userpassword;
	}
}