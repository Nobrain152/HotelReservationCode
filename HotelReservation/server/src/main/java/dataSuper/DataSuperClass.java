package dataSuper;

import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * �������ݲ�ʵ�ֵĸ���
 * @author T5-SK
 *
 */

public class DataSuperClass extends UnicastRemoteObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * �����ݿ������
	 */
	protected Connection conn;
	/**
	 * 
	 */
	protected PreparedStatement preState;
	/**
	 * ���ݿ����
	 */
	protected String sql;
	/**
	 * ���ݿ����Ӱ������
	 */
	protected ResultSet result;
	/**
	 * ���ҷ��ص���Ϣ
	 */
	protected ArrayList<String> findMes;
	/**
	 * �����ݿ������Ӱ�쵽����������Ϣ������
	 */
	protected int affectRows;
	/**
	 * 
	 */
	protected static DataServiceHelper helper = new DataServiceHelper();
	
	private static final Map<String, ArrayList<String>> SQLmap = new HashMap<String, ArrayList<String>>(50);
	
	
}
