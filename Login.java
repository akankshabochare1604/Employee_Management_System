package com.jbk;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//getting data from front-end with the help of request object
		String email=req.getParameter("email");    
		String password=req.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system","root","root");
			//check if email and password exists
			PreparedStatement ps=c.prepareStatement("select * from employee where email=? AND password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				req.setAttribute("fname", rs.getString("fname"));
			    req.setAttribute("lname", rs.getString("lname"));
			    req.setAttribute("gender", rs.getString("gender"));
			    req.setAttribute("email", rs.getString("email"));
			    req.setAttribute("mobno", rs.getString("mobno"));
			    req.setAttribute("dob", rs.getString("dob"));
			    req.setAttribute("age", rs.getInt("age"));
			    req.setAttribute("salary", rs.getDouble("salary"));
			    req.setAttribute("role", rs.getString("role"));
			    req.setAttribute("join_date", rs.getString("join_date"));
			    req.setAttribute("experience", rs.getInt("experience"));
			    req.setAttribute("city", rs.getString("city"));
			    req.setAttribute("state", rs.getString("state"));
			    req.setAttribute("country", rs.getString("country"));
			    req.setAttribute("marital_status", rs.getString("marital_status"));
				
				out.print("<h1 style='color:green'>"+"Logged in successfully"+"</h1>");
				RequestDispatcher rd=req.getRequestDispatcher("/profile.jsp");
				rd.include(req, resp);
				
			}
			else {
				out.print("<h1 style='color:red'>"+"Invalid Credentials...!"+"</h1>");
				RequestDispatcher rd=req.getRequestDispatcher("/EmployeesRegister.html");
				rd.include(req, resp);
			}
		}catch(Exception e) {
			
		}
	}

}
