package com.sp.DevApproachForJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDevforTryResources {
    public static void main(String[] args) throws ClassNotFoundException {
        String driverClass = "com.mysql.cj.jdbc.Driver";
        String dbUrl = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
        String dbUsername = "root";
        String dbPassword = "Rooh@#2001";
        String sqlQuery = "insert into account values (?, ?, ?, ?);";

        try {
            Class.forName(driverClass);
            try (
                    Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                    PreparedStatement pt = connection.prepareStatement(sqlQuery)
            ) {
                pt.setInt(1, 45);
                pt.setString(2, "Kalehs");
                pt.setString(3, "Choudhary");
                pt.setInt(4, 6565);

                int count = pt.executeUpdate();
                System.out.println("No of rows affected: " + count);
                if (count > 0) {
                    System.out.println("Data Inserted. No of rows affected: " + count);
                } else {
                    System.out.println("Issue in Data Insert");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
