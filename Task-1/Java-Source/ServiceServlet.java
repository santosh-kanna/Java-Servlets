package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Serviceservlet {

	private static String url="jdbc:postgresql://localhost:5432/base1?user=postgres&password=123";
	private static Connection con;
	private int result;
	   
	static {
			try {
				
				Class.forName("org.postgresql.Driver");
				con=DriverManager.getConnection(url);
				System.out.println("Database connection established Successfully");
			} catch (ClassNotFoundException  | SQLException e) {
				e.printStackTrace();	
			}
			
	    }	
	
	//Add Employee
	
	public int save(Student s) {
		
		String sql="Insert into login(id,name,age,password,email) values (?,?,?,?,?)";
		
		try {
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,s.getId());
			ps.setString(2, s.getName());
			ps.setInt(3, s.getAge());
			ps.setString(4, s.getPassword());
			ps.setString(5, s.getEmail());
			
			result=ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	public boolean validateLogin(String username, String password) {
		
		String sql="SELECT * FROM login WHERE name=? AND password=? ";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			return ps.executeQuery().next();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
}
