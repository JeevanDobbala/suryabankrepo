<%@ page import="java.util.*, com.model.StudentModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Records</title>
<link rel="stylesheet"
    href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<style>
/* Custom Theme Colors */
body {
    background-color: #f8f9fa;
    font-family: Arial, sans-serif;
}

/* Banner Style */
.banner {
    background-color: #ff6f00;
    color: white;
    padding: 20px 0;
    font-size: 2rem;
    font-weight: bold;
    letter-spacing: 1px;
    position: relative;
    text-align: center;
}

.banner-title {
    text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
}

.add-student-link {
    position: absolute;
    right: 30px;
    top: 50%;
    transform: translateY(-50%);
    font-size: 1.1rem;
    color: white;
    background-color: #28a745;
    padding: 8px 16px;
    border-radius: 5px;
    text-decoration: none;
    font-weight: bold;
    box-shadow: 2px 2px 6px rgba(0, 0, 0, 0.3);
    transition: background-color 0.3s ease;
    text-shadow: 1px 1px 2px black;
}

.add-student-link:hover {
    background-color: #218838;
    text-decoration: none;
}

.container {
    background-color: #ffffff;
    padding: 30px;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

h2 {
    color: #ff6f00;
}

.table {
    background-color: #ffffff;
    border: 1px solid #ddd;
}

.thead-dark {
    background-color: #ff6f00;
    color: white;
}

.table th, .table td {
    padding: 10px;
    text-align: center;
}

.table-striped tbody tr:nth-child(odd) {
    background-color: #f2f2f2;
}

.table-bordered {
    border: 1px solid #ddd;
}

.text-center {
    text-align: center;
}

.no-data {
    font-size: 1.2rem;
    color: #ff6f00;
}

.btn-custom {
    margin: 0 5px;
}
</style>
</head>
<body>
    <!-- Banner Section -->
    <div class="banner">
        <div class="banner-title">Osmania College</div>
        <a href="./Registration.jsp" class="add-student-link">+ Add Student</a>
    </div>

    <div class="container mt-5">
        <h2 class="mb-4" style="text-align: center">STUDENT DETAILS</h2>
        <table class="table table-bordered table-striped">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Father's Name</th>
                    <th>Gender</th>
                    <th>Age</th>
                    <th>Passed Out</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                List<StudentModel> students = (List<StudentModel>) request.getAttribute("studentList");
                if (students != null && !students.isEmpty()) {
                    for (StudentModel s : students) {
                %>
                <tr>
                    <td><%=s.getSid()%></td>
                    <td><%=s.getFname()%></td>
                    <td><%=s.getLname()%></td>
                    <td><%=s.getFathername()%></td>
                    <td><%=s.getGender()%></td>
                    <td><%=s.getAge()%></td>
                    <td><%=s.getPassedout()%></td>
                    <td><%=s.getPhno()%></td>
                    <td><%=s.getEmail()%></td>
                    <td>
                        <a href="UpdateServlet?sid=<%=s.getSid()%>" class="btn btn-warning btn-custom">Update</a>
                        <form action="DeleteServlet" method="post" style="display:inline-block;">
                            <input type="hidden" name="sid" value="<%=s.getSid()%>">
                            <button type="submit" class="btn btn-danger btn-custom"
                                onclick="return confirm('Are you sure you want to delete this record?');">Delete</button>
                        </form>
                    </td>
                </tr>
                <%
                }
                } else {
                %>
                <tr>
                    <td colspan="10" class="text-center no-data">No data found</td>
                </tr>
                <%
                }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
