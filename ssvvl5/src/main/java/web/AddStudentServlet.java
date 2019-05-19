package web;


import Domain.Student;
import Service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddStudentServlet extends HttpServlet {

    Service service;


    public AddStudentServlet(Service service) {
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String name = req.getParameter("nume");
        String id = req.getParameter("idStudent");
        int grupa = Integer.parseInt(req.getParameter("grupa"));
        String em  = req.getParameter("email");
        String prof = req.getParameter("prof");

        int result = service.saveStudent(id, name, grupa,em,prof);

        PrintWriter writer = resp.getWriter();
        writer.println("<h1>Posted status: </h1>" + (result == 0? "true":"false"));
    }
}
