package web;

import Domain.Student;
import Service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ListStudentServlet extends HttpServlet {

    Service service;


    public ListStudentServlet(Service service) {
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();

        for(Student student : service.findAllStudents()) {
            writer.println(student);
            writer.print("<br>");
        }

//        writer.println("<h1>Posted status: </h1>" + (result == 0? "true":"false"));
    }
}
