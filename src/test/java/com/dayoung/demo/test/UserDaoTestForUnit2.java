package com.dayoung.demo.test;

import com.dayoung.demo.user.dao.UserDao;
import com.dayoung.demo.user.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/applicationContext.xml")
public class UserDaoTestForUnit2 {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private UserDao  dao;
    private User user1;
    private User user2;
    private User user3;

    @Before
    public void setUp() {

        this.user1 = new User("gyumee", "박성철", "springno1");
        this.user2 = new User("leegw700", "이길원", "springno2");
        this.user3 = new User("bumjin", "박범진", "springno3");
    }

    @Test
    public void addAndGet() throws Exception {

        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        User user = new User("gyumee", "박성철", "springno1");

        dao.add(user);
        assertThat(dao.getCount(), is(1));

        User user2 = dao.get(user.getId());

//        if( !user.getName().equals("테스트 실패용") ) {
//            System.out.println("테스트 실패 (name)");
//        } else if( !user.getPassword().equals(user2.getPassword()) ) {
//            System.out.println("테스트 실패 (password)");
//        } else {
//            System.out.println("조회 테스트 성공");
//        }

        assertThat(user2.getName(), is(user.getName()));
        assertThat(user2.getPassword(), is(user.getPassword()));

    }

    @Test
    public void count() throws SQLException {

        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        dao.add(user1);
        assertThat(dao.getCount(), is(1));

        dao.add(user2);
        assertThat(dao.getCount(), is(2));

        dao.add(user3);
        assertThat(dao.getCount(), is(3));
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void getUserFailure() throws SQLException {

        dao.deleteAll();
        assertThat(dao.getCount(), is(0));

        dao.get("unknown_id");
    }
}
