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

import java.sql.SQLException;


@WebServlet("/EditRecordServlet")
public class EditRecordServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

private final static String query = "update register set userName=?,email=?,mobile=?,dob=?,city=?,gender=? where id=?";

public EditRecordServlet() {
super();
// TODO Auto-generated constructor stub
}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {

// TODO Auto-generated method stub
PrintWriter pw = response.getWriter();
//set content type
response.setContentType("text/html");
int id = Integer.parseInt(request.getParameter("id"));
String name = request.getParameter("userName");
String email = request.getParameter("email");
String mobile = request.getParameter("mobile");
String dob = request.getParameter("dob");
String city = request.getParameter("city");
String gender = request.getParameter("gender");
pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
try {
//load driver JDBC

Class.forName("com.mysql.cj.jdbc.Driver");

//generate the connection
Connection

con=DriverManager.getConnection("jdbc:mysql://localhost:3306/experiment2","root","807280");

PreparedStatement

ps=con.prepareStatement(query);

ps.setString(1,name);
ps.setString(2, email);
ps.setString(3, mobile);
ps.setString(4, dob);
ps.setString(5, city);
ps.setString(6, gender);
ps.setInt(7, id);

int count =ps.executeUpdate();

pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px'>");
if(count==1) {

pw.println("<h2 class='bg-danger text-light text-center'>Record Edited Successfully</h2>");

}else {

pw.println("<h2 class='bg-danger text-light text-center'>Record Not Edited</h2>");

}
}catch(SQLException se) {

pw.println("<h2 class='bg-danger text-light text-center'>"+se.getMessage()+"</h2>");

se.printStackTrace();
}catch(Exception e) {
e.printStackTrace();
}

pw.println("<a href='index.html'><button class='btn btn-outline-success'>Home</button></a>");

pw.println("<a href='ShowUserServlet'><button class='btn btn-outline-success'>Show User</button></a>");

pw.println("</div>");
pw.println("</div>");
//close the stream
pw.close();
pw.println("</table>");

}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {

// TODO Auto-generated method stub
doGet(request, response);
}

}