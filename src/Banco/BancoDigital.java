package Banco;

import java.util.ArrayList;
import java.util.List;

public class BancoDigital {
	/*
	 * Um banco oferece aos seus clientes dois tipos de contas (corrente e poupança),
	 * as quais possuem funcionalidades de depósito, saque e transferência (entre contas da própria instituição)
	 * */

	public static void main(String[] args) {
		//Criando uma lista para armazenar clientes
//		Cliente cliente = new Cliente();
		
		List<Cliente> cadCliente = new ArrayList<>() {{
			add(new Cliente("Lewis", "Hamilton")); //0
			add(new Cliente("George", "Russel")); //1
			add(new Cliente("Sebastian", "Vettel")); //2
		}};
		
		List<Conta> listaContas = new ArrayList<Conta>(){{
			add(new ContaCorrente(cadCliente.get(0))); //0
			add(new ContaPoupanca(cadCliente.get(0))); //1	
			add(new ContaPoupanca(cadCliente.get(1))); //2
			add(new ContaCorrente(cadCliente.get(1))); //3
			add(new ContaCorrente(cadCliente.get(2))); //4
			add(new ContaPoupanca(cadCliente.get(2))); //5
		}};
		
		listaContas.get(0).depositar(1000);
		listaContas.get(2).depositar(2000);
		listaContas.get(4).depositar(500);
		listaContas.get(3).depositar(950);
		
		for(Conta conta : listaContas) {
			conta.imprimirDadosConta();
		}
		
		listaContas.get(0).transferir(450, listaContas.get(1));
		listaContas.get(2).transferir(500, listaContas.get(3));
		listaContas.get(3).transferir(300, listaContas.get(4));
		listaContas.get(4).transferir(100, listaContas.get(5));
		
		listaContas.get(0).sacar(200);
		
		for(Conta conta1 : listaContas) {
			conta1.imprimirDadosConta();
		}
		
	}
}

