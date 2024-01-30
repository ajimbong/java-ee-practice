package dev.ajim.jee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "personServlet", urlPatterns = "/person")
public class PersonServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lName = req.getParameter("lname");
        String fName = req.getParameter("fname");
        String pass = req.getParameter("password");
        String cPass = req.getParameter("cpassword");

        System.out.println("fName: " + fName + ", lName: " + lName + ", pass: " + pass);

        // TODO: Validate that the right data was passed
        // TODO: Check if pass == cPass

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try (Connection con = Con.getConnection()) {

            PreparedStatement st = con.prepareStatement("INSERT INTO persons (fname, lname, password) VALUES (?, ?, ?)");
            st.setString(1, fName);
            st.setString(2, lName);
            st.setString(3, pass);

            int rows = st.executeUpdate();
            System.out.println("Row count: " + rows);
            doGet(req, resp);

        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try (Connection con = Con.getConnection()) {

            ArrayList<Person> people = new ArrayList<>();

            PreparedStatement st = con.prepareStatement("SELECT * FROM persons");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String lname = rs.getString("lname");
                String fname = rs.getString("fname");
                String pass = rs.getString("password");

                    people.add(new Person(id, fname, lname, pass));
                }

                req.setAttribute("people", people);
                req.getServletContext().getRequestDispatcher("/jsp/result.jsp").forward(req, resp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

