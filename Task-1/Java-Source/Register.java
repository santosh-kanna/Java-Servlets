package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register") 
public class Registerser extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String age=req.getParameter("age");
		String password=req.getParameter("password");
		String email=req.getParameter("email");

		int idInt=Integer.parseInt(id);
		int ageInt=Integer.parseInt(age);
		
		Student s1= new Student(idInt,name,ageInt,password,email);
		
		Serviceservlet service=new Serviceservlet();
		int result=service.save(s1);
		
		PrintWriter pw=resp.getWriter();
		if(result!=0) {
			//log information to the console 
			System.out.println("New user registered:");
            System.out.println("Name: " + name);
            System.out.println("Age: " + ageInt);
            System.out.println("Email: " + email);
            
			pw.println("<h1>Registration done successfully !</h1>");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
			dispatcher.forward(req,resp);
		}
		else {
			pw.println("<h1>Registration Failed</h1>");
		}
		
	}
}
