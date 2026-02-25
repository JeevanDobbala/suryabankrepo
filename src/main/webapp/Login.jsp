<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Login - Osmania PG College</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<style>
body {
	background-color: #ffffff;
}

.TitleDiv {
	background-color: orange;
	position: relative;
	top: 0;
	width: 100%;
	height: 70px;
	text-align: center;
	line-height: 70px;
	font-family: Arial, sans-serif;
	z-index: 1000;
}

.Heading {
	color: white;
	text-shadow: 1px 1px 2px black;
	margin: 0;
	font-size: 28px;
}

.body-content {
	margin-top: 90px;
}

.form-container {
	border: 2px solid orange;
	padding: 30px;
	border-radius: 10px;
	background-color: #fffaf0;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

.btn-green {
	background-color: #28a745;
	color: white;
	font-weight: bold;
}

.btn-green:hover {
	background-color: #218838;
}
</style>
</head>
<body>

	<div class="TitleDiv">
		<h1 class="Heading">OSMANIA PG COLLEGE</h1>
	</div>

	<div class="container body-content">
		<div class="row justify-content-center">
			<div class="col-md-6 col-lg-4">
				<div class="form-container">
					<h4 class="text-center text-orange mb-4" style="color: orange;">Login</h4>
					<form action="LoginServlet" method="post">
						<div class="form-group">
							<label for="Fname">First Name</label> <input type="text"
								id="Fname" name="Fname" placeholder="Enter First Name"
								class="form-control" required>
						</div>

						<div class="form-group">
							<label for="StudentId">Student ID</label> <input type="text"
								id="StudentId" name="sid" placeholder="Enter ID Number"
								class="form-control" required>
						</div>

						<div class="text-center">
							<button type="submit" class="btn btn-green btn-block mt-4">Login</button>
						</div>
					</form>

					<!-- Display error message if login fails -->
					<%
					String error = (String) request.getAttribute("error");
					if (error != null) {
					%>
					<div class="alert alert-danger mt-3 text-center"><%=error%></div>
					<%
					}
					%>

					<!-- Register Button -->
					<div class="text-center mt-3">
						<button type="button"
							onclick="window.location.href='./Registration.jsp'"
							class="btn btn-primary">Register</button>
					</div>

				</div>
			</div>
		</div>
	</div>

</body>
</html>
a
