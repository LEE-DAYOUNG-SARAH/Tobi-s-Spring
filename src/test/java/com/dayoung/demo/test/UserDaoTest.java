package com.dayoung.demo.test;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dayoung.demo.user.dao.DaoFactory;
import com.dayoung.demo.user.dao.UserDao;
import com.dayoung.demo.user.domain.User;

public class UserDaoTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		UserDao dao = context.getBean("userDao", UserDao.class);
		User user = dao.get("whiteship");
		System.out.println(user.getName());
	}
}
