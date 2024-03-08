import java.io.IOException; import java.sql.Connection; import java.sql.DriverManager; import java.sql.PreparedStatement; import javax.servlet.ServletException; import javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet; import javax.servlet.http.HttpServletRequest; import javax.servlet.http.HttpServletResponse; import javax.websocket.Session; @WebServlet("/Update") public class Update extends HttpServlet { private static final long serialVersionUID = 1L; protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
    String v1=request.getParameter("id"); 
    String v2=request.getParameter("eid"); 
    String v3=request.getParameter("name"); 
    Try { 
	Class.forName("com.mysql.jdbc.Driver"); 
	Connection conn=(Connection) 
	    DriverManager.getConnection("jdbc:mysql://localhost:3306/data_base","root","sony2603"); 
	String q="update registration set ID=?,Email=? where Name=?"; PreparedStatement ps=conn.prepareStatement(q); ps.setString(1, v1); ps.setString(2, v2); ps.setString(3, v3); int i=ps.executeUpdate(); if(i>0) { 
	    System.out.println("update succes"); } 
	Else { 
	    System.out.println("not updated"); } 
    }catch(Exception e){ 
	e.printStackTrace(); }}} 
