package com.controller;

import java.io.IOException;
import java.util.List;

import com.dao.StudentDao;
import com.model.StudentModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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

}
