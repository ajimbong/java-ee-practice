package dev.ajim.jee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="updatePersonServlet", urlPatterns = "/update")
public class UpdatePersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO: update request should query DB for specific ID and load edit.jsp
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if(!id.isEmpty()) {
            resp.getWriter().println("<h1> The ID " + id + " </h1> <br> <p> Has been updated </p>");
        } else {
            getServletContext().getRequestDispatcher("/person");
        }
    }
}
