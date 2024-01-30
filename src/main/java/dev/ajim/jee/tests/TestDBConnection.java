package dev.ajim.jee.tests;

import java.sql.*;

public class TestDBConnection {

    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/animal";
        String dbUser = "root";
        String dbPass = "comodoto";

        try (Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM persons");
            while (rs.next()){
                System.out.println(rs.getString("lname"));
            }

            /*
             INSERTING DATA
             This only returns an integer*

             int rows = st.executeUpdate("INSERT INTO persons (lname, fname, password) values ('jdbc', 'mysql', 'testing#insert')");
             System.out.println("INSERT OPERATION \nRows affected: " + rows);
            */

            /*
             UPDATING DATA

             int rows = st.executeUpdate("UPDATE persons SET password='updatedpassword' WHERE lname='jdbc' AND fname='mysql'");
             System.out.println("UPDATE OPERATION \nRows affected: " + rows);
             */

            /*
             DELETE DATA

             int rows = st.executeUpdate("DELETE FROM persons WHERE lname='jdbc' AND fname='mysql'");
             System.out.println("DELETE OPERATION \nRows affected: " + rows);
             */


            /*
             PREPARED STATEMENTS: INSERTING

             PreparedStatement prs = con.prepareStatement("INSERT INTO persons (lname, fname, password) values (?, ?, ?)");
             prs.setString(1, "jdbc");
             prs.setString(2, "prepared statement");
             prs.setString(3, "testing");

             int rows = prs.executeUpdate();

             System.out.println("PREPARED STATEMENT OPERATION \nRows affected: " + rows);
             */

            PreparedStatement pst = con.prepareStatement("SELECT * FROM persons");

            System.out.println("\n PREPARED STATEMENT RUNNING \n");
            ResultSet prs = pst.executeQuery();
            while (prs.next()){
                System.out.println(prs.getString("lname"));
            }



        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
