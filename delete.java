import java.io.IOException; import java.sql.Connection; import java.sql.DriverManager; import java.sql.PreparedStatement; import javax.servlet.ServletException; import javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet; import javax.servlet.http.HttpServletRequest; import javax.servlet.http.HttpServletResponse; 
@WebServlet("/Delete") public class Delete extends HttpServlet { private static final long serialVersionUIL; 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { String b=request.getParameter("abc"); try{ 
	    Class.forName("com.mysql.jdbc.Driver"); 
Connection 
    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/data_base","root","sony26 03"); 
String s="Delete from registration where (Name=?)"; PreparedStatement ps=conn.prepareStatement(s); ps.setString(1, b); 
int i=ps.executeUpdate(); if(i>0) { 
    System.out.println("delete successful"); } 
Else { 
    System.out.println("delete not success"); } } catch(Exception e)  { 
	    System.out.println("Database error"); 
	    e.printStackTrace(); } } } 
