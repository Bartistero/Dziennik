package Model.Connection;

import java.sql.*;

public class Conect {

    Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public boolean newConection() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/students", "root", "");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean disconect() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }
}
