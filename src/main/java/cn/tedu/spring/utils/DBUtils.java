package cn.tedu.spring.utils;

import java.sql.SQLException;

public class DBUtils {
	/**
	 * 釋放資源
	 * @param objects 需要關閉的資源對象, 可以是Connection, Statement, ResultSet
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
