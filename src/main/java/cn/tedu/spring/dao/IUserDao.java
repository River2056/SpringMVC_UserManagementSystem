package cn.tedu.spring.dao;

import java.sql.SQLException;

import cn.tedu.spring.bean.User;

public interface IUserDao {
	/**
	 * 增加用戶數據
	 * 
	 * @param user 用戶註冊數據, 以實體類封裝
	 * @return 新增用戶的id, 如果失敗, 將返回-1
	 * @throws SQLException 
	 */
	Integer insert(User user);
	
	/**
	 * 根據用戶名查詢用戶信息
	 * @param username 用戶名
	 * @return 查詢到的用戶數據, 如果沒有查詢到匹配的紀錄, 則返回null
	 */
	User findUserByUsername(String username);
	
}
