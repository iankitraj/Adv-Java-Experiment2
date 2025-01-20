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


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
private final static String query = "delete from register where id = ?";

/**
* @see HttpServlet#HttpServlet()
*/
public DeleteServlet() {
super();
// TODO Auto-generated constructor stub
}

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {

// TODO Auto-generated method stub
//response.getWriter().append("Served at: ").append(request.getContextPath());
PrintWriter pw = response.getWriter();
response.setContentType("text/html");
//link the bootstrap

pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
//get the values
int id = Integer.parseInt(request.getParameter("id"));
//load the JDBC driver
try {

Class.forName("com.mysql.cj.jdbc.Driver");
//build a connection
Connection

con=DriverManager.getConnection("jdbc:mysql://localhost:3306/experiment2", "root", "807280");

//create a statement
PreparedStatement ps=con.prepareStatement(query);
ps.setInt(1,id);
int count=ps.executeUpdate();
if(count ==1)
{
pw.println("<h1>Record delete successfully </h1>");
}
else
{
pw.println("<h1>Record Not delete </h1>");
}
} catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

pw.println("<a href='index.html'><button class='btn btn-outline-success'>Home</button></a>");

pw.println("&nbsp; &nbsp;");

pw.println("<a href='ShowUserServlet'><button class='btn btn-outline-success'>Show User</button></a>");
pw.println("</div>");

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