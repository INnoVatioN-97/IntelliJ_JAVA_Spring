package kr.mjc.youngil.java.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ResultSet을 처리하는 functional interface
 */
@FunctionalInterface
public interface ResultSetHandler<T> {
  T handle(ResultSet rs) throws SQLException;
}
