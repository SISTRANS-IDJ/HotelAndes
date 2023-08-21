package edu.uniandes.hotel;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.SQLException;
import javax.sql.DataSource;

public class Main {
  public static boolean login(DataSource ds ,String username, String password) throws SQLException {
  // query for password
  try (final var c = ds.getConnection()) {
        var queryStmt = c.prepareStatement("SELECT password FROM hotel.user WHERE username = ?;");
        queryStmt.setString(1, username);

        var rs = queryStmt.executeQuery();

        rs.next();

        var dbPassword = rs.getString(1);

        if (password.equals(dbPassword))
        {
          return true;
        }
        else
        {
          return false;
        }
      }
  }

  public static void main(String[] args) {
    final var config = new HikariConfig();
    final var jdbc = System.getenv("DB_JDBC");
    final var host = System.getenv("DB_HOSTNAME");
    final var port = System.getenv("DB_PORT");
    final var dbName = System.getenv("DB_NAME");

    var jdbcUrl = String.format("%s://%s:%s/%s", jdbc, host, port, dbName);
    System.out.println(jdbcUrl);

    config.setJdbcUrl(jdbcUrl);

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

        var testname = "testuser";

        // insert
     
        var testpassword = "passworda";   var insertStmt = c.prepareStatement("INSERT INTO hotel.user(username, password) VALUES( ?, ?);");
        insertStmt.setString(1, testname);
        insertStmt.setString(2, testpassword);

        insertStmt.executeUpdate();

        var r = login( ds, testname, testpassword);

        if (r) {
          System.out.println("Login succesful!");
        } else {
          System.out.println("Login failed...");
        }

        // delete
        var deleteStmt = c.prepareStatement("DELETE FROM hotel.user WHERE user = ?;");
        deleteStmt.setString(1, testname);

        deleteStmt.executeUpdate();

      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
