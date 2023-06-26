package cadastros;

import java.util.List;

public class Principal {
	public static void main(String[] args) throws Exception {
		PessoaDao pd = new PessoaDao();
		
		try {
			Pessoa p2 = new Pessoa(2, "joao", "joao@gmail.com");
			pd.incluirPessoa(p2);
			Pessoa p3 = new Pessoa(3, "maria", "maria@gmail.com");
			pd.incluirPessoa(p3);
			Pessoa p4 = new Pessoa(4, "ana", "ana@gmail.com");
			pd.incluirPessoa(p4);
			
			Pessoa pes = pd.consultarPessoaIndividual(56);
			if (pes != null) {
				pes.setEmail("joao2@gmail.com");
				pd.alterarPessoa(pes);
				System.out.println("Pessoa alterada com sucesso!");
			} else {
				System.out.println("Pessoa não encontrada ou falha no acesso ao banco de dados!");
			}
				
			Pessoa pes2 = pd.consultarPessoaIndividual(4);
			pd.excluirPessoa(pes2);
			
			Pessoa pes3 = pd.consultarPessoaIndividual(1);
			System.out.println("Código: " + pes3.getIdPessoa());
			System.out.println("Nome: " + pes3.getNomePessoa());
			System.out.println("Código: " + pes3.getEmail());
			
			List<Pessoa> listaDePessoas = pd.ListarPessoas();
			for (Pessoa p : listaDePessoas) {
				System.out.println("Código: " + p.getIdPessoa());
				System.out.println("Nome: " + p.getNomePessoa());
				System.out.println("E-mail: " + p.getEmail());
				System.out.println("---------------------------------");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
