package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.StudentModel;
import com.model.UpdateModel;
import com.utilityy.utility;

public class StudentDao {

	public boolean insert(StudentModel sm) {
		boolean result = false;

		try {
			Connection con = utility.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO student(fname, lname, fathername, age, gender, passedout, phno, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, sm.getFname());
			ps.setString(2, sm.getLname());
			ps.setString(3, sm.getFathername());
			ps.setString(4, sm.getAge());
			ps.setString(5, sm.getGender());
			ps.setString(6, sm.getPassedout());
			ps.setString(7, sm.getPhno());
			ps.setString(8, sm.getEmail());

			int n = ps.executeUpdate();
			if (n > 0) {
				System.out.println(n + " row(s) inserted");
				result = true;
			} else {
				System.out.println("Insert failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean verify(String Fname, String sid) {

		try {
			Connection con = utility.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from student where fname=? and sid=?");
			ps.setString(1, Fname);
			ps.setString(2, sid);

			ResultSet n = ps.executeQuery();
			if (n.next()) {
				return true;
			} else {
				System.out.println("login failed");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return false;

	}

	public List<StudentModel> viewAllStudents() {
		List<StudentModel> studentList = new ArrayList<>();
		try {
			Connection con = utility.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM student");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StudentModel student = new StudentModel();
				student.setSid(rs.getInt("sid"));
				student.setFname(rs.getString("Fname"));
				student.setLname(rs.getString("Lname"));
				student.setFathername(rs.getString("Fathername"));
				student.setGender(rs.getString("Gender"));
				student.setAge(rs.getString("Age"));
				student.setPassedout(rs.getString("passedout"));
				student.setPhno(rs.getString("Phno"));
				student.setEmail(rs.getString("Email"));
				studentList.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentList;
	}

	public boolean Update(UpdateModel u) {
		boolean result = false;
		try {
			Connection con = utility.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"UPDATE student SET Fname=?, Lname=?, Fathername=?, Gender=?, Age=?, passedout=?, phno=?, email=? WHERE sid=?");
			ps.setString(1, u.getFname());
			ps.setString(2, u.getLname());
			ps.setString(3, u.getFathername());
			ps.setString(4, u.getGender());
			ps.setString(5, u.getAge());
			ps.setString(6, u.getPassedout());
			ps.setString(7, u.getPhno());
			ps.setString(8, u.getEmail());
			ps.setInt(9, u.getSid());

			int n = ps.executeUpdate();
			if (n > 0) {
				result = true; // Return true if update successful
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result; // Return false if update failed
	}

	public boolean deleteStudent(int sid) {
		try {
			Connection con = utility.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from student where sid='?'");
			ps.setInt(1, sid);
			int n = ps.executeUpdate();
			if (n > 0) {
				System.out.println(n + "rows affected");
			} else {
				System.out.println("something went wrong!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public static StudentModel getStudentById(int sid) {
		StudentModel student = null;
		try {
			Connection con = utility.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM student WHERE sid = ?");
			ps.setInt(1, sid); // Set the sid parameter to the query

			ResultSet rs = ps.executeQuery();

			// If a student with the given sid exists, create a StudentModel object
			if (rs.next()) {
				student = new StudentModel();
				student.setSid(rs.getInt("sid"));

				student.setFname(rs.getString("fname"));
				student.setLname(rs.getString("lname"));
				student.setFathername(rs.getString("fathername"));
				student.setGender(rs.getString("gender"));
				student.setAge(rs.getString("age"));
				student.setPassedout(rs.getString("passedout"));
				student.setPhno(rs.getString("phno"));
				student.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;

	}

	public boolean DeleteById(int sid) {
		try {
			Connection con = utility.getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM student WHERE sid = ?");
			ps.setInt(1, sid);
			int rowsAffected = ps.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Deleted successfully");
				return true;
			} else {
				System.out.println("No student found with the given ID");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

}
