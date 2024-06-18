package com.sp.DevApproachForJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsingDataUitlityclass {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        PreparedStatement pt = null;
        try {


            connection = DatabaseUtilityClass.getConnection();
            String sql_query = "insert into account values(?,?,?,?);";
            pt = connection.prepareStatement(sql_query);
            pt.setInt(1, 45);
            pt.setString(2, "Kalehs");
            pt.setString(3, "Choudhary");
            pt.setInt(4, 6565);

            int count = pt.executeUpdate();
            System.out.println("No of rows affected " + count);
            if (count > 0) {
                System.out.println(" Data Inserted and No of rows affected " + count);
            } else {
                System.out.println("Issue in Data Insert");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if(pt!=null)
            {
                pt.close();
                DatabaseUtilityClass.closeConnection();
            }

        }
    }

    }
