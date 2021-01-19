package web;
import java.sql.*;
public class ConnectToUser {
	Connection connection;  
	public User  connect(String email, String password) throws SQLException, ClassNotFoundException{
	       
	        Class.forName("com.mysql.jdbc.Driver");
	        connection = DriverManager.getConnection("jdbc:mysql://localhost/logindb","root","");
		  String sql = "SELECT * FROM login WHERE email = ? and password = ?";
		  PreparedStatement statement = connection.prepareStatement(sql);
		  statement.setString(1, email);
		  statement.setString(2, password);
		
		  ResultSet result = statement.executeQuery();
		
		  User user = null;
		
		  if (result.next()) {
		      user = new User();
		      user.setEmail(email);
		  }
		
		  connection.close();
		
		  return user;
		}
}
