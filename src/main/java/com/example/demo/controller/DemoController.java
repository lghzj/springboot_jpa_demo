package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lgh
 * @create 2018/04/04
 **/
@Controller
@RequestMapping("/hello")
public class DemoController {

	@RequestMapping
	public String hello(ModelMap map) {
		map.put("message", "hello world");
		List<User> users = new ArrayList<User>(){{
			add(new User("lisi", "123456", "1qq.com", "si", LocalDate.now().toString()));
			add(new User("wangwu", "123456", "2qq.com", "wu", LocalDate.now().toString()));
			add(new User("zhaoliu", "123456", "3qq.com", "liu", LocalDate.now().toString()));
		}};
		map.put("users", users);
		return "demo/hello";
	}
}
