package cadastros;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDao extends Dao{
	
	public void incluirPessoa(Pessoa p) throws Exception {
		open();
		stmt = con.prepareStatement("INSERT INTO PESSOA VALUES(?,?,?)");
		stmt.setInt(1, p.getIdPessoa());
		stmt.setString(2, p.getNomePessoa());
		stmt.setString(3, p.getEmail());
		stmt.execute();
		stmt.close();
		close();
	}
	
	public boolean alterarPessoa(Pessoa p) throws Exception {
		open();
		stmt = con.prepareStatement("UPDATE PESSOA SET NOMEPESSOA = ?, EMAIL = ? WHERE IDPESSOA = ?");
		try {
			stmt.setString(1, p.getNomePessoa());
			stmt.setString(2, p.getEmail());
			stmt.setInt(3, p.getIdPessoa());
			stmt.execute();
		} catch (SQLException ex) {
			System.out.println("Erro: " + ex.getMessage() + stmt);
			stmt.close();
			close();
			return false;
		}
		stmt.close();
		close();
		return true;
	}
	
	public void excluirPessoa(Pessoa p) throws Exception {
		open();
		stmt = con.prepareStatement("DELETE FROM PESSOA WHERE IDPESSOA = ?");
		stmt.setInt(1, p.getIdPessoa());
		stmt.execute();
		stmt.close();
		close();
	}
	
	public Pessoa consultarPessoaIndividual(int cod) throws Exception {
		open();
		stmt = con.prepareStatement("SELECT * FROM PESSOA WHERE IDPESSOA = ?");
		stmt.setInt(1, cod);
		rs = stmt.executeQuery();
		Pessoa p = null;
		if (rs.next()) {
			p = new Pessoa();
			p.setIdPessoa(rs.getInt("idPessoa"));
			p.setNomePessoa(rs.getString("nomePessoa"));
			p.setEmail(rs.getString("email"));
		} else {
			System.out.println("Registro não encontrado!");
		}
		close();
		return p;
	}
	
	public List<Pessoa> ListarPessoas() {
		try {
			open();
			stmt = con.prepareStatement("SELECT * FROM PESSOA ORDER BY IDPESSOA");
			rs = stmt.executeQuery();
			List<Pessoa> listaPessoas = new ArrayList<>();
			while (rs.next()) {
				Pessoa p = new Pessoa();
				p.setIdPessoa(rs.getInt("idPessoa"));
				p.setNomePessoa(rs.getString("nomePessoa"));
				p.setEmail(rs.getString("email"));
				listaPessoas.add(p);
			}
			close();
			return listaPessoas;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
