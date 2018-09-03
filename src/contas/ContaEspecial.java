package contas;

public class ContaEspecial extends Conta {

	public double LimiteExtra;

	public ContaEspecial() {
	}

	public ContaEspecial(long id, double saldo, String nome, double limite) {
		this.setNumConta(id);
		this.setSaldo(saldo);
		this.setNome(nome);
		this.setLimiteExtra(limite);
	}

	public double getLimiteExtra() {
		return LimiteExtra;
	}

	public void setLimiteExtra(double LimiteExtra) {
		this.LimiteExtra = LimiteExtra;
	}

	@Override
	public void sacar(double valor) {
		if (valor < this.getLimiteExtra()) {
			this.setSaldo(this.getSaldo() - valor);
		} else {
			System.out.println("Você estourou o limite!");
		}
	}

}
