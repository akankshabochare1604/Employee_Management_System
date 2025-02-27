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

@WebServlet("/edit")
public class Update extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Frontend to Backend connection
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String gender = req.getParameter("gender");
        String email = req.getParameter("email");
        String mobno1 = req.getParameter("mobno");
        String dob = req.getParameter("dob");
        String age1 = req.getParameter("age");
        String salary1 = req.getParameter("salary");
        String role = req.getParameter("role");
        String join_date = req.getParameter("join_date");
        String experience1 = req.getParameter("experience");
        String city = req.getParameter("city");
        String state = req.getParameter("state");
        String country = req.getParameter("country");
        String marital_status = req.getParameter("marital_status");
        String password = req.getParameter("password");

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        try {
            // Validate and Parse Numeric Values
            long mobno = Long.parseLong(mobno1);
            int age = Integer.parseInt(age1);
            double salary = Double.parseDouble(salary1);
            int experience = Integer.parseInt(experience1);

            // Database Connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system", "root", "root");
            
            String query = "UPDATE employee SET fname=?, lname=?, gender=?, mobno=?, dob=?, age=?, salary=?, role=?, join_date=?, experience=?, city=?, state=?, country=?, marital_status=?, password=? WHERE email=?";
            PreparedStatement ps = c.prepareStatement(query);

            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, gender);
            ps.setLong(4, mobno);
            ps.setString(5, dob);
            ps.setInt(6, age);
            ps.setDouble(7, salary);
            ps.setString(8, role);
            ps.setString(9, join_date);
            ps.setInt(10, experience);
            ps.setString(11, city);
            ps.setString(12, state);
            ps.setString(13, country);
            ps.setString(14, marital_status);
            ps.setString(15, password);
            ps.setString(16, email); // Ensure WHERE clause works properly

            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                out.println("<script>alert('Profile Updated successfully!!');window.location.href='profile.jsp';</script>");
//                RequestDispatcher rd = req.getRequestDispatcher("profile.jsp");
//                rd.include(req, resp);
            } else {
                out.println("<script>alert('Failed to update data. User not found.');window.location.href='profile.jsp';</script>");
//                RequestDispatcher rd = req.getRequestDispatcher("profile.jsp");
//                rd.include(req, resp);
            }

        } catch (Exception e) {
        	out.println("<script>alert('Something went wrong: " + e.getMessage().replace("'", "\\'") + "');</script>");

            e.printStackTrace();
        }
    }
}
