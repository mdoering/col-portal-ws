package org.col.db.type;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Abstract base handler for all enums.
 *
 * @param <T> the enumeration to be handled
 * @param <D> the db storage value type
 */
abstract class BaseEnumTypeHandler<D, T extends Enum<?>> implements TypeHandler<T> {

  @Override
  public void setParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
    ps.setObject(i, fromEnum(parameter));
  }

  @Override
  public T getResult(ResultSet rs, String columnName) throws SQLException {
    return toEnum((D) rs.getObject(columnName));
  }

  @Override
  public T getResult(ResultSet rs, int columnIndex) throws SQLException {
    return toEnum((D) rs.getObject(columnIndex));
  }

  @Override
  public T getResult(CallableStatement cs, int columnIndex) throws SQLException {
    return toEnum((D) cs.getObject(columnIndex));
  }

  abstract T toEnum(D dbValue);

  abstract D fromEnum(T enumValue);
}
