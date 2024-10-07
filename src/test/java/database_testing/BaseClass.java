package database_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseClass {

    public Connection setUp() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
       return DriverManager.getConnection("jdbc:mysql://localhost:3306/bridgelazemployeeapi","root","root");
    }

}
