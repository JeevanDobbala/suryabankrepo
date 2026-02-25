package com.controller;

import java.io.IOException;
<<<<<<< HEAD
import java.util.List;

import com.dao.StudentDao;
import com.model.StudentModel;

import jakarta.servlet.RequestDispatcher;
=======
import java.sql.Connection;

import com.dao.UserDao;
import com.utility.Utility;

>>>>>>> 62908b6178c1b46ecf50c318a22722c300f5dc7d
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
<<<<<<< HEAD

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Fname = request.getParameter("Fname");
		String sid = request.getParameter("sid");

		StudentDao sd = new StudentDao();
		boolean b = sd.verify(Fname, sid);

		if (b) {
			request.setAttribute("Fname", Fname);
			request.getRequestDispatcher("HomeOs.jsp").forward(request, response); // Forward to home.jsp
		} else {
			request.setAttribute("error", "Invalid credentials. Please try again.");
			request.getRequestDispatcher("Login.jsp").include(request, response);
		}
	}

=======
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		try {
			UserDao dao = new UserDao();
			if (dao.validateUser(username, password)) {
				HttpSession session = req.getSession();
				session.setAttribute("username", username);
				res.sendRedirect("dashboard.jsp");
			} else {
				req.setAttribute("error", "Invalid credentials");
				req.getRequestDispatcher("login.jsp").forward(req, res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
>>>>>>> 62908b6178c1b46ecf50c318a22722c300f5dc7d
}
