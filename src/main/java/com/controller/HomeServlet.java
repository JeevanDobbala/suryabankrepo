package com.controller;

import java.io.IOException;
import java.util.List;

import com.dao.StudentDao;
import com.model.StudentModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentDao sd = new StudentDao();
		List<StudentModel> list = sd.viewAllStudents();
		request.setAttribute("studentList", list);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

}
