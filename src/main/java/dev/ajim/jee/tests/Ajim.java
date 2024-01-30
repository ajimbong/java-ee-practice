package dev.ajim.jee.tests;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "ajimServlet", urlPatterns = "/ajim")
public class Ajim extends HttpServlet {
    private String message;

    public void init() {
        message = "Yo Ajim";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

        //redirect a user
        //getServletContext().getRequestDispatcher("/hello-servlet").forward(request, response)

        String name = request.getParameter("name");
        if (name != null){
            out.println("<h2> Hello " + name + "</h2>");
        }
    }

    public void destroy() {
    }
}