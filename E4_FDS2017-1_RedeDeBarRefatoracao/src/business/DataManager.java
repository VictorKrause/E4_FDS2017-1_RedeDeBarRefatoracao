	package business;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import persistence.FileProcess;

public class DataManager {

	private ArrayList<Cliente> clientesNoBar;
	private FileProcess processador;
	
	public DataManager() {
		clientesNoBar = new ArrayList<Cliente>();
	}

	
	public void adicionarCliente(Cliente cli ){
			clientesNoBar.add(cli);
	}
	public boolean clienteEstaNoBar(String cpfProcurado){

		for(Cliente cli : clientesNoBar){
			String cpfCliente = cli.getCpf();
			if(cpfProcurado.equals(cpfCliente))
				return true;
		}
		return false;
	}	
	public int qtdSocios(){
		int acum=0;
		
		for(Cliente cli : clientesNoBar)
			if(cli instanceof ClienteSocio)
				acum++;
		
		return acum;
	}
	public double  getPorcentagemDeHomens(){
		double percentual;
		int qtdHomens=0;
		int qtdTotal = clientesNoBar.size();
		for(Cliente cli : clientesNoBar){
			String genero = cli.getGenero().toLowerCase();
			if(genero.equals("masculino"))
				qtdHomens++;
		}
			
		percentual = (qtdHomens*100)/qtdTotal;
		
		return percentual;
	}
	public double  getPorcentagemDeMulheres(){
		double percentual;
		int qtdMulheres=0;
		int qtdTotal = clientesNoBar.size();
		for(Cliente cli : clientesNoBar){
			String genero = cli.getGenero().toLowerCase();
			if(genero.equals("feminino"))
				qtdMulheres++;
		}
			
		percentual = (qtdMulheres*100)/qtdTotal;
		
		return percentual;
	}
 	public void removerCliente(String cpf){
		Cliente clienteARemover=null;
		for(Cliente cli: clientesNoBar){
			if(cli.getCpf().equals(cpf))
				clienteARemover = cli;
		}
	clientesNoBar.remove(clienteARemover);
	}
 	public ArrayList<Cliente> getClientes(){
		return clientesNoBar;
 	}
}
 

