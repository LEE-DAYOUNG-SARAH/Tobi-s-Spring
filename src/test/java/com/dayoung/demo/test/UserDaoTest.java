package com.dayoung.demo.test;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dayoung.demo.user.dao.DaoFactory;
import com.dayoung.demo.user.dao.UserDao;
import com.dayoung.demo.user.domain.User;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserDaoTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
//		UserDao dao1 = context.getBean("userDao", UserDao.class);
//		UserDao dao2 = context.getBean("userDao", UserDao.class);
//
//		System.out.println(dao1);
//		System.out.println(dao2);
		
//		DaoFactory factory = new DaoFactory();
//		UserDao dao1 = factory.userDao();
//		UserDao dao2 = factory.userDao();
//		
//		System.out.println(dao1);
//		System.out.println(dao2);

		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

		UserDao dao1 = context.getBean("userDao", UserDao.class);
		System.out.println(dao1);
	}
}
