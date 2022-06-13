package com.dayoung.demo.user.dao;

import com.dayoung.demo.user.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *	중첩 클래스(nested class) => 다른 클래스 내부에 정의되는 클래스
 *	1. static class(스태틱 클래스) = 독릭접으로 오브젝트 생성 가능한
 *	2. inner class(내부 클래스) = 자신이 정의된 클래스의 오브젝트 안에서만 만들어 질 수 있음
 *
 *  내부 클래스의 범위(scope)에 따른 클래스
 *  1. member inner class(멤버 내부 클래스) = 멤버 필드처럼 오브젝트 레벨에 정의
 *  2. local class(로컬 클래스) = 메서드 레벨에 정의
 *  3. anonymous inner class(익명 내부 클래스) = 이름을 갖지 않는
 */
public class UserDao {
	private RowMapper<User> userMapper =
			new RowMapper<User>() {
				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					User user = new User();
					user.setId(rs.getString("id"));
					user.setName(rs.getString("name"));
					user.setPassword(rs.getString("password"));
					return user;
				}
			};
	private JdbcTemplate jdbcTemplate;


	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	public void add(User user) {
		this.jdbcTemplate.update("insert into users(id, name, password) values (user.getId(),user.getName(),user.getPassword())");
	}

	public User get(String id) {
		return this.jdbcTemplate.queryForObject("select * from users where id = ?",
				new Object[] {id}, this.userMapper);
	}

	public List<User> getAll() {
		return this.jdbcTemplate.query("select * from users order by id",
				this.userMapper);
	}

	public void deleteAll() {
		this.jdbcTemplate.update("delete from users");
	}


	public int getCount()  {
		return this.jdbcTemplate.queryForObject("select count(*) from users", Integer.class);
	}

}
