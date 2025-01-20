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

/**
* Servlet implementation class RegisterServlet
*/
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

/**
* @see HttpServlet#HttpServlet()
*/
public RegisterServlet() {
super();
// TODO Auto-generated constructor stub
}

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

// TODO Auto-generated method stub
//get PrintWriter
PrintWriter pw = response.getWriter();
//set content type
response.setContentType("text/html");

String name = request.getParameter("userName");
String email = request.getParameter("email");
String mobile = request.getParameter("mobile");
String dob = request.getParameter("dob");
String city = request.getParameter("city");
String gender = request.getParameter("gender");
try {

//load JDBC driver
Class.forName("com.mysql.cj.jdbc.Driver");
//CREATING CONNECTION
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/experiment2","root","807280");

//create statement
PreparedStatement ps=con.prepareStatement("insert into register (userName,email, mobile, dob, city, gender) values(?,?,?,?,?,?)");

//setString(table col, servlet variable name)
ps.setString(1,name);// INSERT FROM HTML PAGE
ps.setString(2,email);
ps.setString(3,mobile);
ps.setString(4,dob);
ps.setString(5,city);
ps.setString(6, gender);
int count =ps.executeUpdate();
if(count==1)
{
pw.println("<h2>record registered successfully </h2> ");
}
else
{
pw.println("<h2>record not registered </h2> ");
}
} catch (ClassNotFoundException e) {

// TODO Auto-generated catch block
e.printStackTrace();
} catch (SQLException e) {
// TODO Auto-generated catch block
pw.println("<h2>"+e.getMessage()+"</h2>");
e.printStackTrace();
}

}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

// TODO Auto-generated method stub
//doGet(request, response);
}

}