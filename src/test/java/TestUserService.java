import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.spring.bean.User;
import cn.tedu.spring.service.IUserService;

public class TestUserService {

	@Test
	public void testRegister() {
		// �[��Spring�t�m, ���Spring�e��
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
		// ���IUserDao��H
		IUserService userService = ac.getBean("userService", IUserService.class);
		
		// ���ե\��
		User user = new User(null, "tomcat", "123456789", "0988775225", "tomcat@tedu.cn");
		Integer uid = userService.register(user);
		System.out.println("���U����, ��^: " + uid);
		
		// ����귽
		ac.close();
		
	}
}
