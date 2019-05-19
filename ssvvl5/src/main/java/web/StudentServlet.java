package web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(urlPatterns = "/student")
public class StudentServlet extends HttpServlet {

    public StudentServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();
        writer.print("<form action=\"/addStudent\">\n" +
                "    Id: <input id=\"idStudent\"   placeholder=\"idStudent\"     type=\"text\"     name=\"idStudent\"><br>\n" +
                "    Nume: <input id=\"nume\"        placeholder=\"nume\"          type=\"text\"     name=\"nume\"><br>\n" +
                "    Grupa: <input id=\"grupa\"       placeholder=\"grupa\"         type=\"text\"     name=\"grupa\"><br>\n " +
                "    Email: <input id=\"email\"       placeholder=\"email\"         type=\"text\"     name=\"email\"><br>\n" +
                "    Prof: <input id=\"prof\"       placeholder=\"prof\"         type=\"text\"     name=\"prof\"> \n" +
                "    <button id=\"button\">Add Student</button>\n" +
                "</form>");
    }
}
