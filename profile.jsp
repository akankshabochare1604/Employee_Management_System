<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
body {
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
    display: flex;
    background-image: radial-gradient(circle, #edeeea, #eff0eb, #f0f1ec, #f2f3ec, #f4f4ed);
    overflow: hidden; /* Prevent full-page scrolling */
}

/* Sidebar Styling */
.sidebar {
    width: 350px;
    height: 100vh;
    background-image: linear-gradient(to right top, #b6eb38, #febc03, #ff834c, #ff558f, #e458ce);
    color: black;
    font-weight: bold;
    padding-top: 20px;
    position: fixed;
    left: 0;
    top: 0;
    box-shadow: 2px 0 10px rgba(0, 0, 0, 0.2);
}

.logo {
    text-align: center;
    font-size: 22px;
    font-weight: bold;
    margin-bottom: 20px;
}

.nav-links {
    list-style: none;
    padding: 0;
}

.nav-links li {
    padding: 15px;
    text-align: center;
}

.nav-links a {
    text-decoration: none;
    color: white;
    font-size: 16px;
    display: block;
    transition: 0.3s;
}

.nav-links a:hover {
    background-color: rgba(255, 255, 255, 0.1);
    border-radius: 5px;
}

/* Main Content */
.main-content {
    width: 600px;
    height: 500px; /* Adjust height as per requirement */
    margin-left: 380px; /* Ensures space from sidebar */
    padding: 20px;
    background: #f4f4f9;
    position: relative;
    top: 80px;
    left:0;
    background: linear-gradient(135deg, rgba(255, 255, 255, 0.2), rgba(230, 230, 250, 0.3));
    backdrop-filter: blur(20px);
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
    border-radius: 10px;
    text-align: center;
    overflow-y: auto; /* Enables vertical scrolling only within this div */
    overflow-x: hidden;
}

 /* Styling Employee Details */
.main-content h3 {
    font-size: 16px;
    font-weight: 500;
    background: #f8f8f8;
    padding: 12px;
    border-radius: 6px;
    margin-bottom: 12px;
    box-shadow: 2px 2px 6px rgba(0, 0, 0, 0.05);
    text-align: left;
    width: 90%;
    margin-left: auto;
    margin-right: auto;
}

        }
    </style>
</head>
<body>

<!-- Sidebar -->
<div class="sidebar">
    <div class="logo">Employee Management System</div>
    <ul class="nav-links">
    	<li><a href="add_emp.html">Add New Employee</a></li>
    	<li><a href="login.html">Login to Existing Employees Profile</a></li>
    	 	<li><a href="Employees.jsp">View All Employees</a></li>
        <li><a href="profile.jsp">Profile</a></li>
        <li><a href="signup.html">Register</a></li>
        <li><a href="admin_login.html">Login</a></li>
        
        <li><a href="Logout.java">Logout</a></li>
        
        
    </ul>
</div>

<!-- Main Content -->
<div class="main-content">
      
<h1>Employee Profile</h1>
<h3>FirstName : ${fname}</h3>
<br>
<h3>Last Name: ${lname}</h3>
<br>
<h3>Gender: ${gender}</h3>
<br>
<h3>Email: ${email}</h3>
<br>
<h3>Mobile Number: ${mobno}</h3>
<br>
<h3>Date Of Birth: ${dob}</h3>
<br>
<h3>Age: ${age}</h3>
<br>
<h3>Salary: ${salary}</h3>
<br>
<h3>Role: ${role}</h3>
<br>
<h3>Joining Date: ${join_date}</h3>
<br>
<h3>Experience: ${experience}</h3>
<br>
<h3>City: ${city}</h3>
<br>
<h3>State: ${state}</h3>
<br>
<h3>Country: ${country}</h3>
<br>
<h3>Marital Status: ${marital_status}</h3>
<br>
<span> 
    <a href="update.html">
        <button style="background-color: blue; color: white; height: 30px; width: 120px; padding: 5px; border: none; border-radius: 5px; cursor: pointer;">
            Update Profile
        </button>
    </a>  
    <a href="DeleteEmp.html">
        <button style="background-color: red; color: white; height: 30px; width: 120px; padding: 5px; border: none; border-radius: 5px; cursor: pointer;">
            Delete Profile
        </button>
    </a>
</span>
</div>
</body>
</html>
