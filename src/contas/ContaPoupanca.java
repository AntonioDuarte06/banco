package contas;

public class ContaPoupanca extends Conta {
    protected double TaxaRend;
    
    public ContaPoupanca() {
    }

    public ContaPoupanca(long id, double saldo, String nome, double limite){
        this.setNumConta(id);
        this.setSaldo(saldo);
        this.setNome(nome);
        this.setLimiteExtra(limite);
    }

          
    public double getTaxaRend() {
        return TaxaRend;
    }

    public void setTaxaRend(double TaxaRend) {
        this.TaxaRend = TaxaRend;
    }
        
    public double AtualizaConta(){
        this.setSaldo(this.getSaldo() + this.TaxaRend);
        return this.getSaldo();
        
    }
    
}
