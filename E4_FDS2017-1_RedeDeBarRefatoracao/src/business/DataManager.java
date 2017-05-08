package business;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import persistence.FileProcess;

public class DataManager {

	private ArrayList<Cliente> clientesNoBar;
	private FileProcess processador;
	private FileProcess reader;
	private ArrayList<Cliente> clientesAntigos;

	public DataManager() {
		clientesNoBar = new ArrayList<Cliente>();
		reader = new FileProcess();
		try {	clientesAntigos = reader.load();}
		 catch (IOException e) {e.printStackTrace();}
		
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

	
	public String setNumSocio(String cpf){
		try {	clientesAntigos = reader.load();} catch (IOException e) {e.printStackTrace();	}
		for(Cliente cli : this.clientesAntigos){
			if(cli instanceof ClienteSocio)
				if(cli.getCpf().equals(cpf))
					return ((ClienteSocio) cli).getNumSocio();
		}
		
		return gerarNumSocio();
	}
	
	private boolean isNumSocioJaUsado(String numSocio){
		boolean jaFoiUsada = false;
		for(Cliente cli : this.clientesAntigos)
			if(cli instanceof ClienteSocio)
				if(((ClienteSocio) cli).getNumSocio().equals(numSocio))
					jaFoiUsada = false;

		return jaFoiUsada;

	}

	private String gerarNumSocio(){
		int numSocio = (int)(Math.random()*1000000);
		String numSocioToString = ""+numSocio;
		
		if(isNumSocioJaUsado(numSocioToString))
			numSocioToString = gerarNumSocio();
		
		return numSocioToString;

	}
}


