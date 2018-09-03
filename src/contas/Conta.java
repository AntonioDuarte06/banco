package contas;

public abstract class Conta {

	private long numConta;
	private double saldo;
	private String nome;
	private double LimiteExtra;
	private int senha;

	public long getNumConta() {
		return numConta;
	}

	public void setNumConta(long numConta) {
		this.numConta = numConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getLimiteExtra() {
		return LimiteExtra;
	}

	public void setLimiteExtra(double LimiteExtra) {
		this.LimiteExtra = LimiteExtra;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public double depositar(double valor) {
		if (valor > 0) {
			this.setSaldo(this.getSaldo() + valor);
		}
		return valor;
	}

	public void sacar(double valor) {
		if (valor < this.getSaldo() && valor > 0) {
			this.setSaldo(this.getSaldo() - valor);
		}
	}

	public void tranferir(Conta destino, double valor) {
		if (valor > 0) {
			this.sacar(valor);
			destino.depositar(valor);
		}
	}
	
	@Override
	public String toString() {
		return ("\nConta Número: " + this.getNumConta() + "\nTitular: " + this.getNome() + "\nSaldo Atual: "
				+ this.getSaldo());
	}

}
