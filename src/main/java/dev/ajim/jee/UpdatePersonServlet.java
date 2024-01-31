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

@WebServlet(name="updatePersonServlet", urlPatterns = "/update")
public class UpdatePersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO: update request should query DB for specific ID and load edit.jsp
        Integer id = Integer.valueOf(req.getParameter("id"));

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection con = Con.getConnection()) {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM persons WHERE id = ? ");
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            rs.next();
            String lname = rs.getString("lname");
            String fname = rs.getString("fname");
            String pass = rs.getString("password");

            Person person = new Person(id, fname, lname, pass);

            req.setAttribute("person", person);
            getServletContext().getRequestDispatcher("/jsp/edit.jsp").forward(req, resp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.valueOf(req.getParameter("id"));
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String pass = req.getParameter("password");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection con = Con.getConnection()){
            PreparedStatement pst = con.prepareStatement("UPDATE persons SET fname = ?, lname = ?, password = ? WHERE id = ? ");
            pst.setString(1, fname);
            pst.setString(2, lname);
            pst.setString(3, pass);
            pst.setInt(4, id);

            int rows = pst.executeUpdate();
            System.out.println("The item was updated successfully, " + rows + " row(s) was affected.");


            resp.sendRedirect("/person");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


//        if(!id.isEmpty()) {
//            resp.getWriter().println("<h1> The ID " + id + " </h1> <br> <p> Has been updated </p>");
//        } else {
//            getServletContext().getRequestDispatcher("/person");
//        }
    }
}
