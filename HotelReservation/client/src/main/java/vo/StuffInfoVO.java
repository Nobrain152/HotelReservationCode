package vo;


/**
 * �Ƶ������Ա����վ������Ա����վӪ����Ա����Ϣ
 * @author �ܳ�
 *
 */
public class StuffInfoVO extends UserInfoVO{
	
	private String hotel;
	
	public StuffInfoVO() {}
	
	public StuffInfoVO(String userid,String username,ContactVO contact,String hotelid){
	    super(userid, username, contact);
		this.hotel =hotelid;
	}
	
	public String getHotel(){
		return hotel;
	}	
	
	public void setHotel(String id){
		hotel = id;
	}
}