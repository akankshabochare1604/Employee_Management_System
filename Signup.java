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
@WebServlet("/admin_info")
public class Signup extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String name =req.getParameter("fname");
		 String email=req.getParameter("email");
		 String mobile=req.getParameter("mobno");
		 long mob_no=Long.parseLong(mobile);
		 String password=req.getParameter("password");
		 
		 PrintWriter out=resp.getWriter();
		 
		 try {
			 
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system","root","root");
			 PreparedStatement ps=c.prepareStatement("insert into admin(name,email,mobile_number,password)values(?,?,?,?)");
			 ps.setNString(1, name);
			 ps.setString(2, email);
			 ps.setLong(3,mob_no);
			 ps.setString(4, password);
			int row= ps.executeUpdate();
			 
			 if(row>0) {
				 out.print("<script>alert('ADMIN REGISTERED SUCCESSFULLY!!');window.location.href='admin_login.html';</script>");
//				 RequestDispatcher rd=req.getRequestDispatcher("/admin_login.html");
//				 rd.include(req, resp);
				 
			 }else {
				 out.print("<script>alert('FAILED TO REGISTER..PLEASE TRY AGAIN!!');window.location.href='signup.html';</script>");
//				 RequestDispatcher rd=req.getRequestDispatcher("/signup.html");
//				 rd.include(req, resp);
			 }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	}

}
