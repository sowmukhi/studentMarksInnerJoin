package com.neoteric.servlet;

import com.neoteric.dao.StudentMarkDAO;
import com.neoteric.model.StudentMark;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class StudentMarkServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            StudentMarkDAO dao = new StudentMarkDAO();
            List<StudentMark> studentMarks = dao.getAllStudentMarks();

            out.println("<html><body><h2>Student Marks</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Class</th><th>Subject</th><th>Marks</th></tr>");

            for (StudentMark sm : studentMarks) {
                out.println("<tr>");
                out.println("<td>" + sm.getStudent().getStuId() + "</td>");
                out.println("<td>" + sm.getStudent().getStuName() + "</td>");
                out.println("<td>" + sm.getStudent().getStudentClass() + "</td>");
                out.println("<td>" + sm.getMarks().getSubject() + "</td>");
                out.println("<td>" + sm.getMarks().getMarks() + "</td>");
                out.println("</tr>");
            }

            out.println("</table></body></html>");

        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }

}
