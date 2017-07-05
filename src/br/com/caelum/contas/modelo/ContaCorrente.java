package br.com.caelum.contas.modelo;

public class ContaCorrente extends Conta {
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
}
