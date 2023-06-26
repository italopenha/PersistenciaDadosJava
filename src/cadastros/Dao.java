package cadastros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.CallableStatement;

public class Dao {
	
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	CallableStatement call;
	
	public void open() throws Exception {
		String url = "jdbc:mysql://localhost:3306/cadastros";
		String user = "root";
		String password = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("Erro ao conectar com o banco!");
		}
	}
	
	public void close() throws Exception {
		con.close();
	}
}
