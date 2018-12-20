package com.whizen.web.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.whizen.entity.Email;
import com.whizen.entity.User;
import com.whizen.service.EmailService;
import com.whizen.service.UserService;

@Controller
@RequestMapping(value = "/email")
public class EmailController {
	@Autowired
	private EmailService emailService;
	@Autowired
	private UserService userService;
	
	@GetMapping(value ="/get/{id}")
	public Email get(@PathVariable Integer id) {
		return this.emailService.get(id);
	}
	@RequestMapping("/")
	@ResponseBody
	String home() {
		System.out.println("xxxxxxxxxxxxx");
		return "Hello 22!";
	}

	@RequestMapping("/hello")
    public String helloHtml(HashMap<String, Object> map, HttpServletRequest request, HttpServletResponse response ) {
		response.setContentType("text/html;charset=utf-8");
		map.put("hello", "欢迎进入HTML页面");
        map.put("woshi","My name is "+this.userService.get(1).getUsername());
        return "/index";
    }
	
	@RequestMapping("/login")
    public String loginHtml(HashMap<String, Object> map, HttpServletRequest request, HttpServletResponse response ) {
		String ss="";
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("text");
        try {
			if (username != null && username.equals(userService.getUserByName(username).getUsername())){
				Writer out = response.getWriter();
				out.write("用户名已存在..");
				request.setAttribute("username",username);
				ss = "/index";
			}
			else {
				ss = "/login";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return ss;
    }
	
	@RequestMapping("/register")
    public String registerHtml(HashMap<String, Object> map, HttpServletRequest request, HttpServletResponse response ) {
		String ss="";int count = 0;
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("user_name");
		String password = request.getParameter("user_password");
		System.out.println(username);
		try {
			if (username != null){
				if(username.equals(userService.getUserByName(username).getUsername())){
					Writer out = response.getWriter();
					out.write("用户名已存在");
					ss = "/register";
				}
				else{
					User user = new User();
					user.setUsername(username);
					user.setPassword(password);
					count = userService.insert(user);
					if(count>0){
						request.setAttribute("username",username);
						ss = "/index";
					}
					else{
						Writer out = response.getWriter();
						out.write("注册失败，请重新注册！");
						ss = "/register";
					}
				}
			}
			else {
				ss = "/register";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ss;
    }
	
	@RequestMapping("/presonal")
    public String presonalHtml(HashMap<String, Object> map, HttpServletRequest request, HttpServletResponse response ) {
        return "/presonal";
    }
	
}
