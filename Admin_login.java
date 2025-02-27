package com.jbk;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin_login")
public class Admin_login extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			
			PrintWriter out=resp.getWriter();
			 
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system","root","root");
				PreparedStatement ps=c.prepareStatement("select * from admin where email=? and password=?");
				ps.setString(1, email);
				ps.setString(2, password);
				ResultSet rs=ps.executeQuery();
				
				if(rs.next()) {
				out.print("<script>alert('Logged in successfully..!');window.location.href='home.html';</script>");
//				RequestDispatcher rd=req.getRequestDispatcher("/home.html");
//				rd.include(req, resp);
				
			}
			else {
				out.print("<script>alert('Invalid Credentials...!');window.location.href='signup.html';</script>");
//				RequestDispatcher rd=req.getRequestDispatcher("/signup.html");
//				rd.include(req, resp);
			}
			c.close();

			}catch(Exception e) {
				
			}
	
	}

}
