package com.controller;

import java.io.IOException;

import com.dao.StudentDao;
import com.model.StudentModel;
import com.model.UpdateModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {

	// doGet method to handle the HTTP GET request
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Fetch student ID (sid) from the request
		int sid = Integer.parseInt(request.getParameter("sid"));

		// Fetch student details from the database using the DAO
		StudentDao dao = new StudentDao();
		StudentModel student = dao.getStudentById(sid);

		// Set the student object in the request scope
		request.setAttribute("student", student);

		// Forward to the Update.jsp page with the student details
		RequestDispatcher dispatcher = request.getRequestDispatcher("Update.jsp");
		dispatcher.forward(request, response);
	}

	
}
