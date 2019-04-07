import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import cn.tedu.spring.bean.User;
import cn.tedu.spring.service.IUserService;

public class TestUserService {
	CharacterEncodingFilter f;

	@Test
	public void testRegister() {
		// 加載Spring配置, 獲取Spring容器
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
		// 獲取IUserDao對象
		IUserService userService = ac.getBean("userService", IUserService.class);
		
		// 測試功能
		User user = new User(null, "tomcat", "123456789", "0988775225", "tomcat@tedu.cn");
		Integer uid = userService.register(user);
		System.out.println("註冊完成, 返回: " + uid);
		
		// 釋放資源
		ac.close();
		
	}
	
	@Test
	public void testLogin() {
		// 加載Spring配置, 獲取Spring容器
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
		// 獲取IUserDao對象
		IUserService userService = ac.getBean("userService", IUserService.class);
			
		// 測試功能
		User user = new User(null, "tomcat", "12345679", "0988775225", "tomcat@tedu.cn");
		Integer uid = userService.login(user.getUsername(), user.getPassword());
		System.out.println("測試登入, 返回: " + uid);
			
		// 釋放資源
		ac.close();
	}
	
}
