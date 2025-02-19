package com.jbk;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/empinfo")
public class Employees extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		String salary=req.getParameter("salary");
		String role=req.getParameter("role");
		String join_date=req.getParameter("join_date");
		String experience =req.getParameter("experience");
		String city=req.getParameter("city");
		String country=req.getParameter("country");
		String email=req.getParameter("email");
		String mobno=req.getParameter("mobno");
		String age=req.getParameter("age");
		String marital_status=req.getParameter("marital_status");
		String dob=req.getParameter("dob");
		String password=req.getParameter("password");
		
		PrintWriter out=resp.getWriter();
		out.println(fname);
		out.println(lname);
		out.println(salary);
		out.println(role);
		out.println(join_date);
		out.println(experience);
		out.println(city);
		out.println(country);
		out.println(email);
		out.println(mobno);
		out.println(age);
		out.println(marital_status);
		out.println(dob);
		out.println(password);
	}

}
