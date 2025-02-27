<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Details</title>
    <style>
        body { 
            font-family: Arial, sans-serif; 
            background-color: #f4f4f4; 
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 95%;
            margin: auto;
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            overflow-x: auto; /* Enables horizontal scrolling */
        }
        h2 {
            text-align: center;
            color: #333;
        }
        .table-wrapper {
            width: 100%;
            overflow-x: auto; /* Enables horizontal scrolling */
            background-color: #fff; /* Extends background */
            padding-bottom: 10px; /* Avoids text cutoff */
        }
        table { 
            width: 100%; 
            border-collapse: collapse; 
            white-space: nowrap; /* Prevents text wrapping */
            min-width: 1200px; /* Ensures the table doesn't shrink too much */
        }
        th, td { 
            border: 1px solid #ddd; 
            padding: 12px; 
            text-align: left; 
        }
        th { 
            background-color: #0073e6; 
            color: white; 
            position: sticky;
            top: 0;
            z-index: 2;
        }
        tr:nth-child(even) { 
            background-color: #f9f9f9; 
        }
        tr:hover { 
            background-color: #f1f1f1; 
        }
        .action-btn {
            padding: 8px 12px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 14px;
            transition: 0.3s;
        }
        .update-btn { 
            background-color: #28a745; 
            color: white; 
        }
        .update-btn:hover { 
            background-color: #218838; 
        }
        .delete-btn { 
            background-color: #dc3545; 
            color: white; 
        }
        .delete-btn:hover { 
            background-color: #c82333; 
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Employee Details</h2>
    <div class="table-wrapper">
        <table>
            <tr>
                <th>Employee ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Gender</th>
                <th>Email</th>
                <th>Mobile No</th>
                <th>DOB</th>
                <th>Age</th>
                <th>Salary</th>
                <th>Role</th>
                <th>Join Date</th>
                <th>Experience</th>
                <th>City</th>
                <th>State</th>
                <th>Country</th>
                <th>Marital Status</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            <%
                List<String[]> employees = (List<String[]>) request.getAttribute("employees");
                if (employees != null && !employees.isEmpty()) {
                    for (String[] emp : employees) {
            %>
            <tr>
                <td><%= emp[0] %></td> <!-- Employee ID -->
                <td><%= emp[1] %></td> <!-- First Name -->
                <td><%= emp[2] %></td> <!-- Last Name -->
                <td><%= emp[3] %></td> <!-- Gender -->
                <td><%= emp[4] %></td> <!-- Email -->
                <td><%= emp[5] %></td> <!-- Mobile No -->
                <td><%= emp[6] %></td> <!-- DOB -->
                <td><%= emp[7] %></td> <!-- Age -->
                <td><%= emp[8] %></td> <!-- Salary -->
                <td><%= emp[9] %></td> <!-- Role -->
                <td><%= emp[10] %></td> <!-- Join Date -->
                <td><%= emp[11] %></td> <!-- Experience -->
                <td><%= emp[12] %></td> <!-- City -->
                <td><%= emp[13] %></td> <!-- State -->
                <td><%= emp[14] %></td> <!-- Country -->
                <td><%= emp[15] %></td> <!-- Marital Status -->

                <!-- Update Button -->
                <td>
                    <a href="update.html?email=<%= emp[4] %>">
                        <button class="action-btn update-btn">Update</button>
                    </a>
                </td>

                <!-- Delete Button -->
                <td>
                    <a href="DeleteEmp.html?email=<%= emp[4] %>" onclick="return confirm('Are you sure you want to delete this employee?');">
                        <button class="action-btn delete-btn">Delete</button>
                    </a>
                </td>
            </tr>
            <% } } else { %>
            <tr>
                <td colspan="18" style="text-align:center; color: #555;">No Employees Found</td>
            </tr>
            <% } %>
        </table>
    </div>
</div>

</body>
</html>
