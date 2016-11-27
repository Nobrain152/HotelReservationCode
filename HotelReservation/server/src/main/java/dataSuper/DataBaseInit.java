package dataSuper;

import java.sql.Connection;

public class DataBaseInit {
	
	/**
	 * 所有数据读取使用的数据流
	 */
	private static Connection conn;
	
	/**
	 * 获得连接
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
