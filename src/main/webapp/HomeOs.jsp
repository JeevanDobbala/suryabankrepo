<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Osmania College of Engineering</title>
<style>
body {
	margin: 0;
	font-family: Arial, sans-serif;
	background-color: #ffffff;
}

header {
	background-color: #ff6600;
	color: white;
	padding: 30px 20px;
	position: relative;
}

.banner-title {
	position: absolute;
	left: 50%;
	top: 50%;
	transform: translate(-50%, -50%);
	text-align: center;
	font-size: 26px;
	font-weight: bold;
	text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
}


.nav-links {
	display: flex;
	gap: 15px;
}

.nav-links a {
	color: white;
	text-decoration: none;
	font-weight: bold;
}

.nav-links a:hover {
	text-decoration: underline;
}


footer {
	background-color: #ffcc99;
	text-align: center;
	padding: 10px;
	font-size: 14px;
	color: #333;
	position: fixed;
	width: 100%;
	bottom: 0;
}

main {
	padding: 30px;
	min-height: 80vh;
	color: #333;
}
</style>
</head>
<body>

	<header>
		<div class="nav-links">
			<a href="HomeServlet">Student List</a> <a href="#">About</a> <a
				href="#">Contact Us</a>
		</div>
		<div class="banner-title">Osmania College of Engineering</div>
	</header>

	<main style="text-align: center">
		<p>
		<h3 style="color: green">
			Welcome to the Osmania College of Engineering homepage!
			<%=request.getAttribute("Fname")%>
		</h3>
		</p>
	</main>

	<footer> &copy; 2025 Copyrights. All Rights Reserved. </footer>

</body>
</html>
