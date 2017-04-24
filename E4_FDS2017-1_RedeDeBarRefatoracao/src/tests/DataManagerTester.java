package tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import javax.xml.crypto.Data;

import org.junit.*;
import org.junit.Test;

import business.*;

public class DataManagerTester {

	ClienteSocio cliSocio;
	Cliente cliNormal;
	DataManager data;
	
	@Before
	public void setUp(){
		cliSocio = new ClienteSocio("Cliente Socio","03265371042", 21, "masculino", "123456");
		cliNormal = new Cliente("Cliente Normal", "12345678910", 19, "feminino");
		data = new DataManager();
	}
	@Test
	public void testClienteEstaNoBar() {
		data.adicionarCliente(cliSocio);
		boolean actual = data.clienteEstaNoBar("03265371042");
		assertTrue(actual);
		assertFalse(data.clienteEstaNoBar("123123"));
	}
	
	@Test
	public void testQtdSocios(){
	data.adicionarCliente(cliSocio);
	data.adicionarCliente(cliSocio);
	data.adicionarCliente(cliSocio);
	data.adicionarCliente(cliSocio);
	data.adicionarCliente(cliNormal);
	data.adicionarCliente(cliNormal);
	
	assertEquals(4, data.qtdSocios());
	assertNotEquals(6, data.qtdSocios());
	}

	@Test
	public void testPercentualDeHomens(){
		// Add 4 homens
		data.adicionarCliente(cliSocio);
		data.adicionarCliente(cliSocio);
		data.adicionarCliente(cliSocio);
		data.adicionarCliente(cliSocio);
		// Add 6 mulheres
		data.adicionarCliente(cliNormal);
		data.adicionarCliente(cliNormal);
		data.adicionarCliente(cliNormal);
		data.adicionarCliente(cliNormal);
		data.adicionarCliente(cliNormal);
		data.adicionarCliente(cliNormal);
		
		double actual = data.getPorcentagemDeHomens();
		double expected = 40;
		
		assertEquals(expected, actual,0.01);
		
		}

	@Test
	public void testPercentualDeMulheres(){
		// Add 4 homens
		data.adicionarCliente(cliSocio);
		data.adicionarCliente(cliSocio);
		data.adicionarCliente(cliSocio);
		data.adicionarCliente(cliSocio);
		// Add 6 mulheres
		data.adicionarCliente(cliNormal);
		data.adicionarCliente(cliNormal);
		data.adicionarCliente(cliNormal);
		data.adicionarCliente(cliNormal);
		data.adicionarCliente(cliNormal);
		data.adicionarCliente(cliNormal);
		
		double actual = data.getPorcentagemDeMulheres();
		double expected = 60;
		
		assertEquals(expected, actual,0.01);
		
		}

	@Test
	public void testRemoverCliente(){
		data.adicionarCliente(cliSocio);
		assertTrue(data.clienteEstaNoBar("03265371042"));
		data.removerCliente("03265371042");
		assertFalse(data.clienteEstaNoBar("03265371042"));
		System.out.println(cliSocio);
		
		
	}
}
