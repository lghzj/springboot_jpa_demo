package com.example;

import com.example.demo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJpaDemoApplicationTests {

	@Autowired
	private UserRepository userRepository;
	@Test
	public void test() throws Exception {
		int count = userRepository.modifyByIdAndUserName("lisi", 8L);
		System.out.println(count);
	}

}
