package com.jbk;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/employees")  // Ensure URL pattern is correctly mapped
public class EmployeesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String[]> employees = new ArrayList<>();

        try {
            // Load JDBC driver and establish connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system", "root", "root");

            // SQL Query to fetch all employees
            String query = "SELECT * FROM employee";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            // Fetch data and store in the list
            while (rs.next()) {
                String[] empData = new String[]{
                    String.valueOf(rs.getInt("emp_id")), // Employee ID
                    rs.getString("fname"),
                    rs.getString("lname"),
                    rs.getString("gender"),
                    rs.getString("email"),
                    rs.getString("mobno"),
                    rs.getString("dob"),
                    String.valueOf(rs.getInt("age")),
                    String.valueOf(rs.getDouble("salary")),
                    rs.getString("role"),
                    rs.getString("join_date"),
                    String.valueOf(rs.getInt("experience")),
                    rs.getString("city"),
                    rs.getString("state"),
                    rs.getString("country"),
                    rs.getString("marital_status")
                };
                employees.add(empData);
            }

            // Close resources
            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set attribute and forward to JSP
        req.setAttribute("employees", employees);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Employees.jsp");
        dispatcher.forward(req, resp);
    }
}
