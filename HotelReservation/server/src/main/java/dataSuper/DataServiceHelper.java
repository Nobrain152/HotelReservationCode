package dataSuper;

import java.util.ArrayList;

public class DataServiceHelper {
	public DataServiceHelper() {
	}

	public ArrayList<String> bulidSQL(String tableName, int num,String... paras) {
		ArrayList<String> temp = new ArrayList<String>(6);
		temp.add(String.valueOf(num));
		temp.add(bulidAddSQL(tableName, num));
		temp.add(bulidDelSQL(tableName, paras[0]));
		temp.add(bulidFindSQL(tableName, paras[0]));
		temp.add(bulidUpdateSQL(tableName, num, paras));
		// 清空表内数据，用于初始化
		temp.add("TRUNCATE TABLE " + tableName);
		return temp;
	}

	private String bulidUpdateSQL(String tableName, int num, String[] paras) {
		// TODO Auto-generated method stub
		return null;
	}

	private String bulidFindSQL(String tableName, String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private String bulidDelSQL(String tableName, String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private String bulidAddSQL(String tableName, int num) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
