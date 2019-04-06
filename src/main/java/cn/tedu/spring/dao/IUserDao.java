package cn.tedu.spring.dao;

import java.sql.SQLException;

import cn.tedu.spring.bean.User;

public interface IUserDao {
	/**
	 * �W�[�Τ�ƾ�
	 * 
	 * @param user �Τ���U�ƾ�, �H�������ʸ�
	 * @return �s�W�Τ᪺id, �p�G����, �N��^-1
	 * @throws SQLException 
	 */
	Integer insert(User user);
	
	/**
	 * �ھڥΤ�W�d�ߥΤ�H��
	 * @param username �Τ�W
	 * @return �d�ߨ쪺�Τ�ƾ�, �p�G�S���d�ߨ�ǰt������, �h��^null
	 */
	User findUserByUsername(String username);
	
}
