import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.spring.bean.User;
import cn.tedu.spring.dao.IUserDao;

public class TestUserDao {
	
	@Test
	public void testInsert() {
		// �[��Spring�t�m, ���Spring�e��
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
		// ���IUserDao��H
		IUserDao userDao = ac.getBean("userDao", IUserDao.class);
		
		// ���ե\��
		User user = new User(null, "Admin", "123456", "1380013800001", "admin@tedu.cn");
		Integer uid = userDao.insert(user);
		System.out.println("�W�[�Τ᧹��, ��^: " + uid);
		
		// ����귽
		ac.close();
		
	}
	
	@Test
	public void testFindUserByUserName() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
		IUserDao userDao = ac.getBean("userDao", IUserDao.class);
		
		String username = "tomcat";
		User user = userDao.findUserByUsername(username);
		System.out.println(user);
		
		ac.close();
		
	}
	
}
