package dev.ajim.jee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class Con {
//    public static void main(String[] args) {
//        Connection con = getConnection();
//        ArrayList<Person> people = new ArrayList<>();
//
//        try {
//            PreparedStatement st = con.prepareStatement("SELECT * FROM persons");
//            ResultSet rs = st.executeQuery();
//            while (rs.next()){
//                int id = rs.getInt("id");
//                String lname = rs.getString("lname");
//                String fname = rs.getString("fname");
//                String pass = rs.getString("password");
//
//                people.add(new Person(id, fname, lname, pass));
//            }
//
//            System.out.println(people);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
    static Properties props = new Properties();
    public static Connection getConnection() {
        ClassLoader classLoader = Con.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("data.properties");
        try {
            props.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String dbUrl = props.getProperty("dbUrl");
        String user = props.getProperty("user");
        String pass = props.getProperty("pass");


        try {
            Connection con = DriverManager.getConnection(dbUrl, user, pass);
            System.out.println("DB Connected Successfully");
            return con;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
