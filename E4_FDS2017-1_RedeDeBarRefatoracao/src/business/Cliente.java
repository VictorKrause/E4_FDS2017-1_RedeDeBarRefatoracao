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
	public Cliente(){
		this.nome = "";
		this.cpf="";
		this.idade=0;
		this.genero="";
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setGenero(String genero) {
		this.genero = genero;
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
		return nome+"/"
				+cpf+"/"
						+idade+ "/"
								+genero;
	}
}
