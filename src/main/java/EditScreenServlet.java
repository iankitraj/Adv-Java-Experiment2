import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
* Servlet implementation class EditScreenServlet
*/
@WebServlet("/EditScreenServlet")
public class EditScreenServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

private final static String query = "select userName,email,mobile,dob,city,gender from register where id=?";

/**
* @see HttpServlet#HttpServlet()
*/
public EditScreenServlet() {
super();
// TODO Auto-generated constructor stub
}

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {

// TODO Auto-generated method stub
PrintWriter pw = response.getWriter();
//set content type
response.setContentType("text/html");
int id = Integer.parseInt(request.getParameter("id"));
pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
try {
//load driver JDBC

Class.forName("com.mysql.cj.jdbc.Driver");
//generate the connection
Connection

con=DriverManager.getConnection("jdbc:mysql://localhost:3306/experiment2","root","807280");

PreparedStatement psmt=con.prepareStatement(query);
//set value
psmt.setInt(1,id);

ResultSet rs=psmt.executeQuery();
rs.next();
pw.println("<div style='margin:auto;width:500px;margin-top:100px;'>");
pw.println("<form action='EditRecordServlet?id="+id+"' method='post'>");
pw.println("<table class='table table-hover table-striped'>");

pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Name</td>");
pw.println("<td><input type='text' name='userName' value='"+rs.getString(1)+"'></td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Email</td>");
pw.println("<td><input type='email' name='email' value='"+rs.getString(2)+"'></td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Mobile</td>");
pw.println("<td><input type='text' name='mobile' value='"+rs.getString(3)+"'></td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>DOB</td>");
pw.println("<td><input type='date' name='dob' value='"+rs.getString(4)+"'></td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>City</td>");
pw.println("<td><input type='text' name='city' value='"+rs.getString(5)+"'></td>");
pw.println("</tr>");
pw.println("<tr>");

pw.println("<td>Gender</td>");
pw.println("<td><input type='text' name='gender' value='"+rs.getString(6)+"'></td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td><button type='submit' class='btn btn-outline-success'>Edit</button></td>");
pw.println("<td><button type='reset' class='btn btn-outline-danger'>Cancel</button></td>");

pw.println("</tr>");
pw.println("</table>");
pw.println("</form>");
}catch(SQLException se) {

pw.println("<h2 class='bg-danger text-light text-center'>"+se.getMessage()+"</h2>");

se.printStackTrace();
}catch(Exception e) {
e.printStackTrace();
}

pw.println("<a href='index.html'><button class='btn btn-outline-success'>Home</button></a>");

pw.println("</div>");
//close the stream
pw.close();
pw.println("</table>");
}
/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {

// TODO Auto-generated method stub
doGet(request, response);

}

}