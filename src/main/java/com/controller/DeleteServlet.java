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

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int sid = Integer.parseInt(request.getParameter("sid"));

		StudentDao dao = new StudentDao();
		boolean result = dao.DeleteById(sid);

		if (result) {
			// After successful deletion, reload the student list
			List<StudentModel> updatedList = dao.viewAllStudents();
			request.setAttribute("studentList", updatedList);

			// Forward to home.jsp to display the updated list
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else {
			// If deletion failed, show an error message (you can modify as needed)
			request.setAttribute("error", "Failed to delete student.");
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}
}
