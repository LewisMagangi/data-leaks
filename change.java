mport java.io.IOException; import java.sql.Connection; import java.sql.DriverManager; import java.sql.PreparedStatement; import javax.servlet.ServletException; import javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet; import javax.servlet.http.HttpServletRequest; import javax.servlet.http.HttpServletResponse; import javax.servlet.http.HttpSession; @WebServlet("/Change") public class Change extends HttpServlet { private static final long serialVersionUID = 1L; 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	HttpSession hs=request.getSession(true); 
	String s1=request.getParameter("o1"); 
	String s2=request.getParameter("n1"); 
	String s3=request.getParameter("c1"); 
	String s4=(String) hs.getAttribute("ss2"); String s5=(String) hs.getAttribute("s0"); if(s1.equals(s5)&&s2.equals(s3)){ try{ 
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/data_base","root","sony26 03"); 
		String q="update registration set Password=? where Name=?"; PreparedStatement ps=conn.prepareStatement(q); ps.setString(1, s2); ps.setString(2,s4); int i=ps.executeUpdate(); if(i>0){ 
		    System.out.println("change password"); 
		}else{ 
		    System.out.println("not change password"); } 
	    }catch(Exception  e){ } } } 
 
 
