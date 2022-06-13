package com.dayoung.demo.user.dao.template;

import com.dayoung.demo.user.dao.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *  템플릿 메서드 패턴 => 상속을 통해 기능 확장
 *  1. 변하지 않는 부분 => 슈퍼 클래스
 *  2. 변하는 부분 => 추상메서드로 정의해서 자식 클래스에서 오버라이드
 *
 *  아래 UserDao 같은 경우, 기능마다 extends 를 해줘야 하기 때문에 템플릿 메서드 패턴은 적절치 않다.
 */
public class UserDaoDeleteAll extends UserDao {

    protected PreparedStatement makeStatement(Connection c) throws SQLException {
        PreparedStatement ps = c.prepareStatement("delete from users");
        return ps;
    }
}
