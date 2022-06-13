package com.dayoung.demo.user.dao.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *  전략 패턴 => 오브젝트를 둘로 분리(변하는 부분&변하지 않는 부분)하고, 클래스 레벨에서는 인터페이스를 통해서만 의존하도록
 *  1. 변하지 않는 부분 => 클래스 (아래의 인터페이스를 DI)
 *  2. 변하는 부분 => 인터페이스 생성 (기능에 따라 인터페이스를 재정의)
 */
public interface StatementStrategy {
    PreparedStatement makePreparedStatement(Connection c) throws SQLException;
}
