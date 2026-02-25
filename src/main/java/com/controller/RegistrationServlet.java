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

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fname = request.getParameter("Fname");
		String lname = request.getParameter("Lname");
		String fathername = request.getParameter("Fathername");
		String gender = request.getParameter("Gender");
		String age = request.getParameter("Age");
		String passedout = request.getParameter("PassedOut");
		String phno = request.getParameter("Phno");
		String email = request.getParameter("Email");

		try {
			
			StudentModel sm = new StudentModel();
			sm.setFname(fname);
			sm.setLname(lname);
			sm.setFathername(fathername);
			sm.setGender(gender);
			sm.setAge(age);
			sm.setPassedout(passedout);
			sm.setPhno(phno);
			sm.setEmail(email);

			StudentDao sd = new StudentDao();
			boolean status = sd.insert(sm);

			RequestDispatcher rd = request.getRequestDispatcher(status ? "Login.jsp" : "Registration.jsp");
			rd.include(request, response);

		} catch (NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute("error", "Invalid input in age or year.");
			request.getRequestDispatcher("Registration.jsp").include(request, response);
		}
	}
}
