package bl.hotelbl;

/**
 * 入住日期判断类
 * @author 曹畅
 *
 */
public class Date {

	private String intime;
	private String outtime;
	private int inYear;
	private int inMonth;
	private int inDay;
	private int outYear;
	private int outMonth;
	private int outDay;
	
	public Date(String in,String out){
		intime=in;
		outtime=out;
		makeNumber();
	}
	
	public void makeNumber(){
		String[] in={intime.substring(0,4),intime.substring(5,7),intime.substring(8,10)};
		String[] out={outtime.substring(0,4),outtime.substring(5,7),outtime.substring(8,10)};
		inYear=Integer.parseInt(in[0]);
		inMonth=Integer.parseInt(in[1]);
		inDay=Integer.parseInt(in[2]);
		outYear=Integer.parseInt(out[0]);
		outMonth=Integer.parseInt(out[1]);
		outDay=Integer.parseInt(out[3]);
	}
	
	public String getInTime(){
		return intime;
	}
	
	public String getOutTime(){
		return outtime;
	}
	
	public void setInTime(String in){
		intime=in;
	}
	
	public void setOUtTime(String out){
		outtime=out;
	}
	
	public int getInYear(){
		return inYear;
	}
	
	
	public int getInMonth(){
		return inMonth;
	}
	
	public int getInDay(){
		return inDay;
	}
	
	public int getOutYear(){
		return outYear;
	}
	
	public int getOutMonth(){
		return outMonth;
	}
	
	public int getOutDay(){
		return outDay;
	}
	
	
	public boolean isEarlier(int i1,int i2,int i3,int o1,int o2,int o3){
		
		if(i1<o1){
			return true;
		}
		if(i1>o1){
			return false;
		}
		if(i2<o2){
			return true;
		}
		if(i2>o2){
			return false;
		}
		if(i3<o3){
			return true;
		}
		return false;
	}
	
	public boolean isConflict(Date date){
		if(intime.equals(date.getInTime())){
			return true;
		}
		if(isEarlier(inYear,inMonth,inDay,date.getInYear(),date.getInMonth(),date.getInDay())){
			if(isEarlier(outYear, outMonth, outDay,date.getInYear(),date.getInMonth(),date.getInDay())){
				return false;
			}
			else{
				return true;
			}
		}
		else{
			if(isEarlier(date.getOutYear(),date.getOutMonth(),date.getOutDay(),inYear,inMonth,inDay)){
				return false;
			}
			else{
				return true;
			}
		}
	}
}
