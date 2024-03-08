import java.io.IOException; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession;
 public class Login extends HttpServlet { private static final long serialVersionUID = 1L; 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	String ss1=request.getParameter("Name"); 
	String ss2=request.getParameter("Password");  HttpSession hs=request.getSession(true); 
	try { 
	    Class.forName("com.mysql.jdbc.Driver"); 
	    Connection conn=(Connection) 
		DriverManager.getConnection("jdbc:mysql://localhost:3306/data_base","root","sony2603"); 
	    String s="select * from registration where Name=? and Password=?"; PreparedStatement ps=conn.prepareStatement(s); 
	    ps.setString(1,ss1); 
	    ps.setString(2,ss2); ResultSet rs=ps.executeQuery(); 
	    if(rs.next()) { hs.setAttribute("ss2",ss1); hs.setAttribute("s0",ss2); System.out.println("Login successful"); response.sendRedirect("welcome.jsp"); } 
	    else { 
		System.out.println("data not entered");  } } catch(Exception e) {  System.out.println("database error"); 
	    e.printStackTrace(); }  }  } 
