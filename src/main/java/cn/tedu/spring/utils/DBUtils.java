package cn.tedu.spring.utils;

import java.sql.SQLException;

public class DBUtils {
	/**
	 * ����귽
	 * @param objects �ݭn�������귽��H, �i�H�OConnection, Statement, ResultSet
	 */
	public static void close(AutoCloseable... objects) {
		for(AutoCloseable obj : objects) {
			if(obj != null) {
				try {
					obj.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
