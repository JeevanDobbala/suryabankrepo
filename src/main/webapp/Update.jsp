<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.model.StudentModel"%>
<%
    StudentModel student = (StudentModel) request.getAttribute("student");
    if (student == null) {
        out.println("<h3 style='color:red;'>Student data not found!</h3>");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
<title>Update Student</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-5">
		<h2 class="mb-4 text-center text-warning">Update Student
			Information</h2>
		<form action="UpdateServlet1" method="post">
			<input type="text" name="sid" value="<%= student.getSid() %>">

			<div class="form-group">
				<label for="fname">First Name</label> <input type="text"
					name="fname" value="<%= student.getFname() %>" class="form-control"
					required>
			</div>

			<div class="form-group">
				<label for="lname">Last Name</label> <input type="text" name="lname"
					value="<%= student.getLname() %>" class="form-control" required>
			</div>

			<div class="form-group">
				<label for="fathername">Father's Name</label> <input type="text"
					name="fathername" value="<%= student.getFathername() %>"
					class="form-control" required>
			</div>

			<div class="form-group">
				<label for="gender">Gender</label> <select name="gender"
					class="form-control" required>
					<option value="Male"
						<%= "Male".equals(student.getGender()) ? "selected" : "" %>>Male</option>
					<option value="Female"
						<%= "Female".equals(student.getGender()) ? "selected" : "" %>>Female</option>
				</select>
			</div>

			<div class="form-group">
				<label for="age">Age</label> <input type="number" name="age"
					value="<%= student.getAge() %>" class="form-control" required>
			</div>

			<div class="form-group">
				<label for="passedout">Passed Out Year</label> <input type="number"
					name="passedout" value="<%= student.getPassedout() %>"
					class="form-control" required>
			</div>

			<div class="form-group">
				<label for="phno">Phone Number</label> <input type="text"
					name="phno" value="<%= student.getPhno() %>" class="form-control"
					required>
			</div>

			<div class="form-group">
				<label for="email">Email ID</label> <input type="email" name="email"
					value="<%= student.getEmail() %>" class="form-control" required>
			</div>

			<div class="text-center">
				<button type="submit" class="btn btn-success">Update</button>
				<a href="StudentRecords.jsp" class="btn btn-secondary">Cancel</a>
			</div>
		</form>
	</div>
</body>
</html>
