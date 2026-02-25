<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Osmania University</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<style>
.TitleDiv {
	background-color: orange;
	position: fixed;
	top: 0px;
	width: 100vw;
	height: 70px;
	text-align: center;
	line-height: 70px;
	font-family: Arial, sans-serif;
	z-index: 1000;
}

.body-content {
	margin-top: 90px;
	margin-bottom: 50px;
}

.Heading {
	color: white;
	text-shadow: 1px 1px 2px black;
	margin: 0;
}
</style>
</head>
<body>
	<div class="TitleDiv">
		<h1 class="Heading">OSMANIA PG COLLEGE</h1>
	</div>

	<div class="container body-content">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<form action="RegistrationServlet" method="post"
					class="border p-4 shadow-sm bg-light rounded">

					<h2 class="mb-4 text-center">Student Registration Form</h2>

					<div class="form-group">
						<label for="Fname">First Name</label> <input type="text"
							id="fname" name="Fname" class="form-control"
							placeholder="First Name" required>
					</div>

					<div class="form-group">
						<label for="Lname">Last Name</label> <input type="text" id="lname"
							name="Lname" class="form-control" placeholder="Last Name"
							required>
					</div>

					<div class="form-group">
						<label for="Fathername">Father's Name</label> <input type="text"
							id="fathername" name="Fathername" class="form-control"
							placeholder="Father's Name" required>
					</div>

					<div class="form-group">
						<label for="Age">Age</label> <input type="number" id="age"
							name="Age" class="form-control" placeholder="Age" min="1"
							required>
					</div>

					<div class="form-group">
						<label>Gender</label><br>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="Gender"
								id="genderM" value="M" required> <label
								class="form-check-label" for="genderM">Male</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="Gender"
								id="genderF" value="F"> <label class="form-check-label"
								for="genderF">Female</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="Gender"
								id="genderO" value="O"> <label class="form-check-label"
								for="genderO">Other</label>
						</div>
					</div>

					<div class="form-group">
						<label for="PassedOut">Passed-out Year</label> <select
							id="passedout" name="PassedOut" class="form-control" required>
							<option value="">Select Year</option>
							<option>2025</option>
							<option>2024</option>
							<option>2023</option>
							<option>2022</option>
							<option>2021</option>
							<option>2020</option>
						</select>
					</div>

					<div class="form-group">
						<label for="Phno">Phone Number</label> <input type="text"
							id="phno" name="Phno" class="form-control"
							placeholder="Enter Phone Number" pattern="^\d{10}$"
							title="Phone number must be 10 digits." required>
					</div>


					<div class="form-group">
						<label for="Email">Email</label> <input type="email" id="email"
							name="Email" class="form-control" placeholder="Email" required>
					</div>

					<div class="form-group text-center">
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>
				</form>

				<p class="text-center">
					Are you an existing student? <a href="./Login.jsp">Click here</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>
