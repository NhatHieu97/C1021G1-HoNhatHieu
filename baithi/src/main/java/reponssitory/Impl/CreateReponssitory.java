package reponssitory.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateReponssitory {

    private String jdbcURL = "jdbc:mysql://localhost:3306/de_thi-_010";
    private String jdbcUsername = "root";
    private String jdbcPassword = "nhathieu123";
    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
