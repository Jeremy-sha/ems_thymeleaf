package com.jeremy.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeremy.entity.User;
import com.jeremy.service.UserService;
import com.jeremy.utils.ValidateImageCodeUtils;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

//	登陆方法
	@PostMapping("/login")
	public String login (String username,String password){
		User login = userService.login(username, password);
		if (login!=null) {

			return"redirect:/emp/findAll";//跳轉查詢所有

		}else {
			return"redirect:/index";
		}

	}


//	注册方法
	@PostMapping("/register")
	public String register(User user, String code, HttpSession session) {

		String sessionCode = (String) session.getAttribute("code");

		if (sessionCode.equalsIgnoreCase(code)) {
			userService.register(user);
			return "redirect:/index";//跳轉到登錄界面
		} else {

			return "redirect:/toRegister";
		}
	}


	@GetMapping("/code")
	public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
		//   生成验证码

		String securityCode = ValidateImageCodeUtils.getSecurityCode();
		BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
		session.setAttribute("code", securityCode); //存入session作用域

		ServletOutputStream os = response.getOutputStream();
		ImageIO.write(image, "png", os);



	}
}
