package dev.ajim.jee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name="deletePersonServlet", urlPatterns = "/delete")
public class DeletePersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));

        try (Connection con = Con.getConnection()) {
            PreparedStatement pst = con.prepareStatement("DELETE FROM persons WHERE id = ? ");
            pst.setInt(1, id);

            int rows = pst.executeUpdate();

            System.out.println("Item deleted successfully, " + rows + " was affected.");

            getServletContext().getRequestDispatcher("/person").forward(req, resp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
