package br.com.caelum.contas.modelo;

public class ContaCorrente extends Conta implements Tributavel {
	@Override
	public String getTipo() {
		return "Conta Corrente";
	}

	@Override
	public boolean saca(double valor) {
		if (valor > this.saldo || valor < 0) {
			return false;
		} else {
			this.saldo -= (valor + 0.10);
			return true;
		}
	}

	@Override
	public double getValorImposto() {
		return this.saldo * 0.01;
	}
}
