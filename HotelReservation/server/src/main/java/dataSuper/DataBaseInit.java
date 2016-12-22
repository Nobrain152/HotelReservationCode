package dataSuper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import util.RoomState;

/**
 * ���ݿ�������
 * @author T5-SK
 *
 */

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
	
	
	/**
	 * ÿ�γ����һ������ʱ��ȡ����
	 * ���ö�ķ��裬ע����룬̫���ˣ�������
	 */
	private static void connection() {
		  try {			  
			  //ʹ��JDBC
			  Class.forName("com.mysql.cj.jdbc.Driver");        

		    }
		    catch (Exception e) {
		    	e.printStackTrace();
		    }
		  
		  try {
			  //����URLΪ'jdbc:mysql//��������ַ/���ݿ��� ' �������2�������ֱ��ǵ�½�û���������
			  conn = DriverManager.getConnection(
					  "jdbc:mysql://localhost/withoutbrain?serverTimezone=UTC","root","hkw19970717");
		  } catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�������ݿ����");
		  }
	}
	
	
	/**
	 * �������ʱ����
	 */
	public static void disconnect(){
		try {
			conn.close();
			conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
