package edu.uniandes.hotel;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.SQLException;

public class Main {
  public static void main(String[] args) {
    final var config = new HikariConfig();
    final var jdbc = System.getenv("DB_JDBC");
    final var host = System.getenv("DB_HOSTNAME");
    final var port = System.getenv("DB_PORT");
    final var dbName = System.getenv("DB_NAME");

    config.setJdbcUrl(String.format("%s://%s:%s/%s", jdbc, host, port, dbName));

    final var user = System.getenv("DB_USER");
    config.setUsername(user);

    final var password = System.getenv("DB_PASSWORD");
    config.setPassword(password);

    try (var ds = new HikariDataSource(config)) {
      try (final var c = ds.getConnection()) {
        final var meta = c.getMetaData();
        System.out.println(meta.getDatabaseProductName());
        System.out.println(meta.getDatabaseProductVersion());
        System.out.println(meta.getDriverName());
        System.out.println(meta.getDriverVersion());
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
