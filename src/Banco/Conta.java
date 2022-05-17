package Banco; //kath

public class Conta {
	private int agencia;
	protected int numeroConta;
	private double saldo;
	private Cliente cliente;
	
	public Conta(Cliente cliente) {
		this.agencia = 0001;
		this.cliente = cliente;
	}
	
	public int getAgencia() {
		return agencia;
	}
	
	/*
	  public int getNumeroConta() {
		return numeroConta;
	}
	*/
	
	public double getSaldo() {
		return saldo;
	}
	
	public double sacar(double valor) {
		return saldo - valor;
	}
	
	public double depositar(double valor) {
		return saldo + valor;
	}
	
	public void transferir(double valor, Conta contaDestinada) {
		sacar(valor);
		contaDestinada.depositar(valor);
	}
	 
}

class ContaCorrente extends Conta{
	public int getNumeroConta() {
		return numeroConta = 12345;
	}
}

class ContaPoupanca extends Conta{
	public int getNumeroConta() {
		return numeroConta = 123456789;
	}
	
	@Override
	public double getSaldo() {
		return super.getSaldo()*0.01; //acrescentando os juros da poupança
	}
}