package com.jbk;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/DeleteEmp")
public class DeleteEmp extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password= request.getParameter("password");

        PrintWriter out=response.getWriter();

        try {
            // Database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system", "root", "root");

            // SQL query to delete user
           PreparedStatement ps=c.prepareStatement("DELETE FROM employee WHERE email = ? AND password=?");
           
            ps.setString(1, email);
            ps.setString(2, password);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
               out.println("<script>alert('Profile deleted successfully!'); window.location.href='login.html';</script>");
//               RequestDispatcher rd=request.getRequestDispatcher("/login.html");
//               rd.include(request, response);
            } else {
            	out.println("<script>alert('No profile found with this email.'); window.location.href='login.html';</script>");
//                RequestDispatcher rd=request.getRequestDispatcher("/login.html");
//                rd.include(request, response);
            	}
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<script>alert('Something went wrong: " + e.getMessage().replace("'", "\\'") + "');</script>");

        
        }
    }
}

