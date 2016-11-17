package util;



public class PromotionMsg {
	
	private boolean pass;
	
	
	private String message;
	
	public PromotionMsg(boolean pass, String message) {
		
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