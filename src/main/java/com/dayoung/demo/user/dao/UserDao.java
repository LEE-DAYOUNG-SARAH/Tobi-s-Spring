package com.dayoung.demo.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dayoung.demo.user.domain.User;

public class UserDao {
//	private static UserDao INSTANCE;
	private ConnectionMaker connectionMaker;
	
	// 매번 새로운 값으로 바뀌는 정보를 담은 인스턴스 변수
	private Connection c;
	private User user;
	
//	public UserDao(ConnectionMaker connectionMaker) {
//		this.connectionMaker = connectionMaker;
//	}
	
//	public static synchronized UserDao getInstance() {
//		if (INSTANCE == null) INSTANCE = new UseDao(???);
//		return INSTANCE;
//	}

	// setter 메서드를 통한 DI
	public void setConnectionMaker(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
	
	public void add(User user) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();
		PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		c.close();
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();
		PreparedStatement ps = c.prepareStatement("select * from users where id=?");
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
//		User user = new User();
		this.user = new User();
		this.user.setId(rs.getString("id"));
		this.user.setName(rs.getString("name"));
		this.user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		c.close();
		
		return this.user;
	}
}
