package business;

public class ClienteSocio extends Cliente{
	private String numSocio;
	
	public String getNumSocio() {
		return numSocio;
	}

	public void setNumSocio(String numSocio) {
		this.numSocio = numSocio;
	}

	public ClienteSocio(String nome, String cpf, int idade, String genero, String numSocio) {
		super(nome, cpf, idade, genero);	
		this.numSocio=numSocio;
	}

	
	public String toString(){
		return super.toString()+"numSocio: "+numSocio+"\n";
	}
}
