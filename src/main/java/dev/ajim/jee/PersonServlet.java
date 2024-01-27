package dev.ajim.jee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "personServlet", urlPatterns = "/person")
public class PersonServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String lName = req.getParameter("lname");
//        String fName = req.getParameter("fname");
//        String pass = req.getParameter("password");
//        String cPass = req.getParameter("cpassword");
        String[] names = {"Jimmy", "Lilly", "Rita", "Nagel"};

        req.setAttribute("names", names);

        getServletContext().getRequestDispatcher("/jsp/yo.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.getWriter().println("Yo Brody");

        doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String id = req.getParameter("id");
       resp.getWriter().println("<h1> The ID " + id + " </h1> <br> <p> Has been delete </p>");
    }
}
