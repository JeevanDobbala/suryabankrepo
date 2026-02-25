<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.*, com.model.StudentModel"%>
<%
    List<StudentModel> students = (List<StudentModel>) request.getAttribute("students");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Records</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">

	<div class="container mt-4">
		<h2 class="text-center mb-4 text-primary">Student Records</h2>
		<table class="table table-bordered table-hover">
			<thead class="table-dark">
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
				</tr>
			</thead>
			<tbody>
				<%
            if (students != null && !students.isEmpty()) {
                for (StudentModel s : students) {
        %>
				<tr>
					<td><%= s.getSid() %></td>
					<td><%= s.getFname() %></td>
					<td><%= s.getLname() %></td>
					<td><%= s.getFathername() %></td>
					<td><%= s.getGender() %></td>
					<td><%= s.getAge() %></td>
					<td><%= s.getPassedout() %></td>
					<td><%= s.getPhno() %></td>
					<td><%= s.getEmail() %></td>
				</tr>
				<%
                }
            } else {
        %>
				<tr>
					<td colspan="9" class="text-center text-danger">No student
						data found.</td>
				</tr>
				<%
            }
        %>
			</tbody>
		</table>
	</div>

</body>
</html>
