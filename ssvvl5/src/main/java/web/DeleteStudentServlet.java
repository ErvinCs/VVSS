package web;

import Service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteStudentServlet extends HttpServlet {

    Service service;


    public DeleteStudentServlet(Service service) {
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String id = req.getParameter("idStudent");

        int result = service.deleteStudent(id);

        PrintWriter writer = resp.getWriter();
        writer.println("<h1>Deleted status: </h1>" + (result == 0? "true":"false"));
    }
}
