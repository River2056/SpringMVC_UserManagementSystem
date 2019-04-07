package cn.tedu.spring.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tedu.spring.bean.User;
import cn.tedu.spring.service.IUserService;

@Controller
public class UserController {
	
	@Resource(name="userService")
	private IUserService userService;
	
	@RequestMapping("/register.do")
	public String showRegister() {
		return "register";
	}
	
	@RequestMapping("/login.do")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/handleRegister.do")
	public String handleRegister(User user, ModelMap modelMap) {
		// ������U, �������^��
		Integer id = userService.register(user);
		// �P�_��^��
		if(id == -1) {
			// ���U����, �h���ʸ˻ݭn��o���ƾ�
			modelMap.addAttribute("errorMessage", "�Τ�W�w�g�s�b, ���U����!");
			return "error";
		} else {
			// ���U���\, �h���w�V
			return "redirect:login.do";
		}
		
	}
	
	@RequestMapping("/handleLogin.do")
	public String handleLogin(@RequestParam("username") String username, @RequestParam("password") String password, ModelMap modelMap) {
		Integer result = userService.login(username, password);
		if(result == 1) {
			// login success
			modelMap.addAttribute("status", "�N����ܭ���...");
			return "login_result";
		} else if(result == -1) {
			// user not found
			modelMap.addAttribute("errorMessage", "�Τ�W���s�b! �нT�{�ε��U��n�J!");
			return "error";
		} else {
			// invalid password
			modelMap.addAttribute("errorMessage", "�K�X���~! �Э��s�T�{�K�X!");
			return "error";
		}
		
	}
	
}
