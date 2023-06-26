package cadastros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.CallableStatement;

public class Dao {
	
	Connection con; // Conexão ao banco de dados
	PreparedStatement stmt; // Acesso a tabela (insert, update, delete, select)
	ResultSet rs; // Consulta a tabela (select)
	CallableStatement call; // Procedimentos e funções
	
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
