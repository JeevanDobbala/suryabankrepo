package com.controller;

import java.io.IOException;

import com.dao.StudentDao;
import com.model.StudentModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public EditServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int sid = Integer.parseInt(request.getParameter("sid"));

		StudentModel student = StudentDao.getStudentById(sid); // Make sure this method returns correct data

		
		request.setAttribute("sid", student.getSid());
		request.setAttribute("fname", student.getFname());
		request.setAttribute("lname", student.getLname());
		request.setAttribute("fathername", student.getFathername());
		request.setAttribute("gender", student.getGender());
		request.setAttribute("age", student.getAge());
		request.setAttribute("passedout", student.getPassedout());
		request.setAttribute("phno", student.getPhno());
		request.setAttribute("email", student.getEmail());

		
		RequestDispatcher rd = request.getRequestDispatcher("Update.jsp");
		rd.forward(request, response);
	}

}
