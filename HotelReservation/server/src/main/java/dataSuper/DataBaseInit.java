package dataSuper;

import java.sql.Connection;

public class DataBaseInit {
	
	/**
	 * �������ݶ�ȡʹ�õ�������
	 */
	private static Connection conn;
	
	/**
	 * �������
	 * @return
	 */
	public static Connection getConnection()
	{	
		if(conn == null){
			connection();
		}
		return conn;
	}
	
	private static void connection() {
		
	}

}
