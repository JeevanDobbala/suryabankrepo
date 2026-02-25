package com.controller;

import java.io.IOException;
import java.util.List;

import com.dao.StudentDao;
import com.model.StudentModel;
import com.model.UpdateModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateServlet1")
public class UpdateServlet1 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get updated student information from the request
		UpdateModel updateModel = new UpdateModel();
		updateModel.setSid(Integer.parseInt(request.getParameter("sid")));
		updateModel.setFname(request.getParameter("fname"));
		updateModel.setLname(request.getParameter("lname"));
		updateModel.setFathername(request.getParameter("fathername"));
		updateModel.setGender(request.getParameter("gender"));
		updateModel.setAge(request.getParameter("age"));
		updateModel.setPassedout(request.getParameter("passedout"));
		updateModel.setPhno(request.getParameter("phno"));
		updateModel.setEmail(request.getParameter("email"));

		// Update the student data in the database
		StudentDao studentDao = new StudentDao();
		boolean success = studentDao.Update(updateModel);

		if (success) {
			// Fetch updated list of students
			List<StudentModel> updatedStudentList = studentDao.viewAllStudents();
			request.setAttribute("studentList", updatedStudentList);

			// Forward to home.jsp to display the updated data
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else {
			// If update failed, show error message
			request.setAttribute("error", "Failed to update student data.");
			request.getRequestDispatcher("Update.jsp").forward(request, response);
		}
	}
}
