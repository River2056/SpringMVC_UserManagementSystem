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
		// 執行註冊, 並獲取返回值
		Integer id = userService.register(user);
		// 判斷返回值
		if(id == -1) {
			// 註冊失敗, 則先封裝需要轉發的數據
			modelMap.addAttribute("errorMessage", "用戶名已經存在, 註冊失敗!");
			return "error";
		} else {
			// 註冊成功, 則重定向
			return "redirect:login.do";
		}
		
	}
	
	@RequestMapping("/handleLogin.do")
	public String handleLogin(@RequestParam("username") String username, @RequestParam("password") String password, ModelMap modelMap) {
		Integer result = userService.login(username, password);
		if(result == 1) {
			// login success
			modelMap.addAttribute("status", "將跳轉至首頁...");
			return "login_result";
		} else if(result == -1) {
			// user not found
			modelMap.addAttribute("errorMessage", "用戶名不存在! 請確認或註冊後登入!");
			return "error";
		} else {
			// invalid password
			modelMap.addAttribute("errorMessage", "密碼錯誤! 請重新確認密碼!");
			return "error";
		}
		
	}
	
}
