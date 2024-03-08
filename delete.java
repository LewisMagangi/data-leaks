import java.io.IOException; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.SQLException; // Added import for SQLException
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 

@WebServlet("/Delete") 
public class Delete extends HttpServlet {
    private static final long serialVersionUID = 1L; // Fixed typo in serialVersionUID

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        String b = request.getParameter("abc"); 
        try { 
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data_base", "root", "sony2603"); // Fixed password string
            String s = "DELETE FROM registration WHERE Name=?"; // Changed "Delete" to "DELETE" and added missing space
            PreparedStatement ps = conn.prepareStatement(s); 
            ps.setString(1, b); 
            int i = ps.executeUpdate(); 
            if(i > 0) { 
                System.out.println("Delete successful"); 
            } else { 
                System.out.println("Delete not successful"); 
            } 
            conn.close(); // Added closing of the connection
        } catch(ClassNotFoundException | SQLException e) { 
            System.out.println("Database error"); 
            e.printStackTrace(); 
        } 
    } 
}
