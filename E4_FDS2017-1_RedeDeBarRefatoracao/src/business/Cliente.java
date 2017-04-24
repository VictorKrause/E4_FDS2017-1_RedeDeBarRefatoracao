package business;

public class Cliente {
	private String nome;
	private String cpf;
	private int idade;
	private String genero;
	
	public Cliente (String nome, String cpf, int idade, String genero){
		this.nome = nome;
		this.cpf=cpf;
		this.idade=idade;
		this.genero=genero;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public int getIdade() {
		return idade;
	}

	public String getGenero() {
		return genero;
	}
	
	public String toString(){
		return "nome: " +nome+"\n"
				+ "cpf: "+cpf+"\n"
						+ "idade: "+ idade+ "\n"
								+ "genero: "+genero+"\n";
	}
}
