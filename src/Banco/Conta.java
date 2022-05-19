package Banco; //kath

public abstract class Conta {
	private static final int NUMERO_AGENCIA = 1;
	private static int NUMERO_CONTA = 1;
	
	protected int agencia;
	protected int numeroConta;
	protected double saldo;
	protected Cliente cliente;
	
	public Conta(Cliente cliente) {
		this.agencia = NUMERO_AGENCIA;
		this.numeroConta = NUMERO_CONTA++;
		this.cliente = cliente;
	}
	
	public int getAgencia() {
		return agencia;
	}
	
	public int getNumeroConta() {
		return numeroConta;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void sacar(double valor) {
		saldo -= valor;
	}
	
	public void depositar(double valor) {
		saldo += valor;
	}
	
	public void transferir(double valor, Conta contaDestinada) {
		sacar(valor);
		contaDestinada.depositar(valor);
	}
	
	public void imprimirDadosConta() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()+" "+this.cliente.getSobrenome()));
		System.out.println("Conta: "+this.agencia+" - "+this.numeroConta);
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
	 
}

class ContaCorrente extends Conta{	
	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}
	
}

class ContaPoupanca extends Conta{	
	public ContaPoupanca(Cliente cliente) {
		super(cliente);
		
	}

	@Override
	public double getSaldo() {
		return super.getSaldo()*0.01; //acrescentando os juros da poupança
	}
}
