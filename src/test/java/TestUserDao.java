import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.spring.bean.User;
import cn.tedu.spring.dao.IUserDao;

public class TestUserDao {
	
	@Test
	public void testInsert() {
		// 加載Spring配置, 獲取Spring容器
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
		// 獲取IUserDao對象
		IUserDao userDao = ac.getBean("userDao", IUserDao.class);
		
		// 測試功能
		User user = new User(null, "Admin", "123456", "1380013800001", "admin@tedu.cn");
		Integer uid = userDao.insert(user);
		System.out.println("增加用戶完成, 返回: " + uid);
		
		// 釋放資源
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
