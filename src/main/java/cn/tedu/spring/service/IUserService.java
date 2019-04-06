package cn.tedu.spring.service;

import cn.tedu.spring.bean.User;

public interface IUserService {

	/**
	 * 註冊新用戶
	 * @param user 新用戶信息
	 * @return 返回新用戶的ID, 如果註冊失敗, 則返回-1
	 */
	Integer register(User user);
	
	/**
	 * 根據用戶名查詢用戶信息
	 * @param username 用戶名
	 * @return 查詢到的用戶數據, 如果沒有查詢到匹配的紀錄, 則返回null
	 */
	User findUserByUsername(String username);
	
	/**
	 * 用戶登入
	 * @param username 用戶名
	 * @param password 密碼
	 * @return 返回: 1 -> 成功, -1 -> 失敗
	 */
	Integer login(String username, String password);
	
}
