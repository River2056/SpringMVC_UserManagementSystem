package cn.tedu.spring.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.spring.bean.User;
import cn.tedu.spring.dao.IUserDao;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Resource(name="userDao")
	private IUserDao userDao;
	
	public Integer register(User user) {
		// 1. �d�߷s�Τ᪺�Τ�W�b�����ƾڪ������ƾ�
		User u = userDao.findUserByUsername(user.getUsername());
		// 2. �P�_�d�ߵ��G
		if(u == null) {
			// �d�ߵ��G��null, ��ܥΤ�W�٨S���Q�e��, �h�i�H���U
			return userDao.insert(user);
		} else {
			// �d�ߨ�ǰt���Τ�ƾ�, �Y�Τ�W�w�g�s�b, �h�����\���U
			return -1;
		}
		
	}

	public User findUserByUsername(String username) {
		return userDao.findUserByUsername(username);
	}

	public Integer login(String username, String password) {
		// look for user
		User user = userDao.findUserByUsername(username);
		if(user == null) {
			// user not found, login fail
			return -1;
		} else {
			// user found, check password
			if(password.equals(user.getPassword())) {
				// password match, login success
				return 1;
				
			} else {
				// invalid password, login fail
				return -2;
			}
		}
		
	}

}
