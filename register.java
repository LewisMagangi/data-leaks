
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException; // Added import for SQLException
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L; // Fixed typo in serialVersionUID

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ss1 = request.getParameter("ID");
        String ss2 = request.getParameter("Name");
        String ss3 = request.getParameter("Password");
        String ss4 = request.getParameter("Email");
        PrintWriter pw = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data_base", "root", "sony2603"); // Fixed password string
            String s = "INSERT INTO registration VALUES(?, ?, ?, ?)"; // Changed "insert into" to "INSERT INTO" and fixed missing space
            PreparedStatement ps = conn.prepareStatement(s);
            ps.setString(1, ss1);
            ps.setString(2, ss2);
            ps.setString(3, ss3);
            ps.setString(4, ss4);
            int i = ps.executeUpdate();
            if (i > 0) {
                // System.out.println("Data entered successfully");
                response.sendRedirect("login.html");
            } else {
                System.out.println("Data not entered successfully");
            }
            conn.close(); // Added closing of the connection
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Database error");
            e.printStackTrace();
        }
    }
}