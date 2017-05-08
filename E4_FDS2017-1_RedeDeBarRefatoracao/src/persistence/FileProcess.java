package persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import business.*;

public class FileProcess {

	public  void write(Cliente cli) throws IOException{
		FileWriter writer = new FileWriter("ClientesBar.txt",true);
		String line = cli.toString();
		writer.write(line);
		writer.write("\n");
		writer.flush();
		writer.close();

	}

	public ArrayList<Cliente> load() throws IOException{
		ArrayList<Cliente> clientesAntigos = new ArrayList<Cliente>();
		// Leitura do arquivo
		Scanner reader = new Scanner(new File("ClientesBar.txt"));
		// Variaveis iniciais
		String line;

		while(reader.hasNext()){
			line = reader.nextLine();
			String[] lineSplitada = line.split("/");
			 if(lineSplitada.length>4)
				 clientesAntigos.add(new ClienteSocio(lineSplitada[0], lineSplitada[1], Integer.parseInt(lineSplitada[2]), lineSplitada[3], lineSplitada[4]));			 
			 else
				 clientesAntigos.add(new Cliente(lineSplitada[0],lineSplitada[1],Integer.parseInt(lineSplitada[2]),lineSplitada[3]));	
		}

		return clientesAntigos;


	}


}
