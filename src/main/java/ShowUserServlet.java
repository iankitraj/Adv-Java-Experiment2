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


@WebServlet("/ShowUserServlet")
public class ShowUserServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
private final static String query = "select id,userName,email,mobile,dob,city,gender from register";


public ShowUserServlet() {
super();
// TODO Auto-generated constructor stub
}



protected void doGet(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException {

// TODO Auto-generated method stub
//response.getWriter().append("Served at:").append(request.getContextPath());
//get PrintWriter

PrintWriter pw = response.getWriter();
//set content type
response.setContentType("text/html");
//link the bootstrap
pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
pw.println("<marquee><h2 class='text-primary'>User Data</h2></marquee>");
try {
//load driver JDBC

Class.forName("com.mysql.cj.jdbc.Driver");
//generate the connection
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/experiment2","root","807280");

PreparedStatement psmt=con.prepareStatement(query);
ResultSet rs=psmt.executeQuery();
pw.println("<div style='margin:auto;width:900px;margin-top:100px;'>");
pw.println("<table class='table table-hover table-striped'>");

pw.println("<tr>");
pw.println("<th>ID</th>");
pw.println("<th>Name</th>");
pw.println("<th>Email</th>");
pw.println("<th>Mobile No</th>");
pw.println("<th>DOB</th>");

pw.println("<th>City</th>");
pw.println("<th>Gender</th>");
pw.println("<th>Edit</th>");
pw.println("<th>Delete</th>");
pw.println("</tr>");
while(rs.next()) {
pw.println("<tr>");
pw.println("<td>"+rs.getInt(1)+"</td>");
pw.println("<td>"+rs.getString(2)+"</td>");
pw.println("<td>"+rs.getString(3)+"</td>");
pw.println("<td>"+rs.getString(4)+"</td>");
pw.println("<td>"+rs.getString(5)+"</td>");
pw.println("<td>"+rs.getString(6)+"</td>");
pw.println("<td>"+rs.getString(7)+"</td>");
pw.println("<td><a href='EditScreenServlet?id="+rs.getInt(1)+"'>Edit</a></td>");
pw.println("<td><a href='DeleteServlet?id="+rs.getInt(1)+"'>Delete</a></td>");
pw.println("</tr>");
}
pw.println("</table>");

} catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

pw.println("<button class='btn btn-outline-success d-block'><a href='index.html'>Home</a></button>");

pw.println("</div>");
pw.close();

}


protected void doPost(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException {

// TODO Auto-generated method stub
doGet(request, response);
}

}