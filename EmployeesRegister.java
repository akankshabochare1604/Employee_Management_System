package com.jbk;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/empinfo")
public class EmployeesRegister extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// frontend backend connection
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		String gender=req.getParameter("gender");
		String email=req.getParameter("email");
		String mobno1=req.getParameter("mobno");
		long mobno=Long.parseLong(mobno1);
		String dob=req.getParameter("dob");
		String age1=req.getParameter("age");
		int age=Integer.parseInt(age1);
		String salary1=req.getParameter("salary");
		double salary=Double.parseDouble(salary1);
		
		String role=req.getParameter("role");
		String join_date=req.getParameter("join_date");
		String experience1 =req.getParameter("experience");
		int experience=Integer.parseInt(experience1);
		String city=req.getParameter("city");
		String state=req.getParameter("state");
		String country=req.getParameter("country");
		String marital_status=req.getParameter("marital_status");
		String password=req.getParameter("password");

		PrintWriter out=resp.getWriter();
		
		//database connection
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system","root","root");
			PreparedStatement ps=c.prepareStatement("insert into employee"
					+ "(fname,lname,gender,email,mobno,dob,age,salary,role,join_date,experience,city,state,country,marital_status,password)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			//executing sql query to insert data indo db
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, gender);
			ps.setString(4, email);
			ps.setLong(5, mobno);
			ps.setString(6,dob);
			ps.setInt(7, age);
			ps.setDouble(8, salary);
			ps.setString(9, role);
			ps.setString(10,join_date);
			ps.setInt(11, experience);
			ps.setString(12, city);
			ps.setString(13, state);
			ps.setString(14, country);
			ps.setString(15, marital_status);
			ps.setString(16, password);
			 ps.executeUpdate();
			c.close(); //closing resources
			// int rowsInserted = ps.executeUpdate(); // Execute SQL statement

			// if (rowsInserted > 0) {
			// 	out.print("<h1>Data successfully inserted</h1>");
			// } else {
			// 	out.print("<h1>Data insertion failed</h1>");
			// }
			
			RequestDispatcher rd= req.getRequestDispatcher("/login.html"); //afetr successfull registration directing to login page
			rd.forward(req, resp);
		}catch(Exception e) {
			
		}
		
		
		
		
		

	}
}
