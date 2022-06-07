package com.dayoung.demo.test;

import com.dayoung.demo.user.dao.CountingConnectionMaker;
import com.dayoung.demo.user.dao.CountingDaoFactory;
import com.dayoung.demo.user.dao.UserDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class UserDaoConnectionCountingTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(CountingDaoFactory.class);

        UserDao dao = context.getBean("userDao", UserDao.class);

        // DAO 사용 코드
        CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
        System.out.println("Connection counter : " + ccm.getCounter());
    }
}
