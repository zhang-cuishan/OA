package com.shizongger.oa.base;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
	private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	// 测试SessionFactory
	@Test
	public void testSessionFactory() throws Exception {
		SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
		assertNotNull(sessionFactory);
	}
}
