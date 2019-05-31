package database.matchlog;

import database.ConnectionMySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddMatchlog {
    public static void main(String loginLight, String loginDark, String log) throws SQLException, ClassNotFoundException {

        Connection connection = ConnectionMySQL.getMySQLConnection();

        Statement statement = connection.createStatement();

        String sql = "INSERT INTO matchlog (light, dark, log) VALUES('" + loginLight + "', '" + loginDark+ "', '" + log + "')";

        int rowCount = statement.executeUpdate(sql);
    }
}
