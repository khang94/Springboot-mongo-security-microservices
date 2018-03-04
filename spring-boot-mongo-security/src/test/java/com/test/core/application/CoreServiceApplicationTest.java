package com.test.core.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springboot.mongo.khang.core.application.MainApplication;

@SpringBootTest
@ContextConfiguration(classes = MainApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CoreServiceApplicationTest {

	@Test
	public void contextLoads() {
		System.out.println("Test......");
	}

}
