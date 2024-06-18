package com.sp.DevApproachForJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtilityClass {
    static Connection con=null;

    public static Connection  getConnection() throws ClassNotFoundException, SQLException {

        String driverClass;
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false", "root", "Rooh@#2001");

        return con;
    }
    public static void closeConnection() throws SQLException {
        if(con!=null)
        {
            con.close();
        }

    }
}
