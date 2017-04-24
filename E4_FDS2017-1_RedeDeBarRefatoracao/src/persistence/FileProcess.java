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

}
