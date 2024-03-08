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

@WebServlet("/Update")
public class Update extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String v1 = request.getParameter("id");
        String v2 = request.getParameter("eid");
        String v3 = request.getParameter("name");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data_base", "root", "sony2603");
            String q = "UPDATE registration SET ID=?, Email=? WHERE Name=?";
            PreparedStatement ps = conn.prepareStatement(q);
            ps.setString(1, v1);
            ps.setString(2, v2);
            ps.setString(3, v3);
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("Update successful");
            } else {
                System.out.println("Update not successful");
            }
            conn.close(); // Added closing of the connection
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Database error: " + e.getMessage());
        }
    }
}