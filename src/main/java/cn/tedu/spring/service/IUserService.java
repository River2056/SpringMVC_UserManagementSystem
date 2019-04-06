package cn.tedu.spring.service;

import cn.tedu.spring.bean.User;

public interface IUserService {

	/**
	 * ���U�s�Τ�
	 * @param user �s�Τ�H��
	 * @return ��^�s�Τ᪺ID, �p�G���U����, �h��^-1
	 */
	Integer register(User user);
	
	/**
	 * �ھڥΤ�W�d�ߥΤ�H��
	 * @param username �Τ�W
	 * @return �d�ߨ쪺�Τ�ƾ�, �p�G�S���d�ߨ�ǰt������, �h��^null
	 */
	User findUserByUsername(String username);
	
	/**
	 * �Τ�n�J
	 * @param username �Τ�W
	 * @param password �K�X
	 * @return ��^: 1 -> ���\, -1 -> ����
	 */
	Integer login(String username, String password);
	
}
