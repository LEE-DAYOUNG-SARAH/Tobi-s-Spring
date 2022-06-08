package com.dayoung.demo.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
public class DaoFactory {
//	@Bean
//	public UserDao userDao() {
//		// setter를 통한 DI 주입
//		UserDao userDao = new UserDao();
//		userDao.setConnectionMaker(connectionMaker());
//		return userDao;
//	}
//
//	@Bean
//	public ConnectionMaker connectionMaker() {
//		return new DConnectionMaker();
//	}

    /** 자바 코드 설정 방식 */
//    @Bean
//    public DataSource dataSource() {
//        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
//
//        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
//        dataSource.setUrl("jdbc:mysql://localhost:3306/TOBIS");
//        dataSource.setUsername("TOBIS");
//        dataSource.setPassword("1234");
//
//        return dataSource;
//    }
//
//    @Bean
//	public UserDao userDao() {
//		// setter를 통한 DI 주입
//		UserDao userDao = new UserDao();
//		userDao.setDataSource(dataSource());
//		return userDao;
//	}
}
