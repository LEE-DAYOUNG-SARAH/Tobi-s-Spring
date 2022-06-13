package com.dayoung.demo.user.dao.template;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *  JDBC의 일반적인 작업 흐름을 재사용 할 수 있도록 클래스로 분리
 */
public class JdbcContext {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;                       // DataSource 타입 빈을 DI 받을 수 있도록 준비
    }

    // try/catch/finally 수행
    public void workdWithStateStrategy(StatementStrategy stmt) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = dataSource.getConnection();

            ps = stmt.makePreparedStatement(c);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if( ps != null) { try { ps.close(); } catch (SQLException e) {} }
            if( c != null) { try { c.close(); } catch (SQLException e) {}}
        }
    }

    public void executeSql(final String query) throws SQLException {
        workdWithStateStrategy(
            new StatementStrategy() {
                @Override
                public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
                    return c.prepareStatement(query);
                }
            }
        );
    }
}
