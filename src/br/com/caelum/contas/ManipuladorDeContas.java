package br.com.caelum.contas;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.javafx.api.util.Evento;

public class ManipuladorDeContas {

	private Conta conta;

	public void criaConta(Evento evento) {
		conta = new Conta();
		conta.setNumero(123);
		conta.setAgencia("321-0");
		conta.setTitular("Batman");
	}

	public void deposita(Evento evento) {
		double valorDigitado = evento.getDouble("valor");
		this.conta.deposita(valorDigitado);
	}

	public void saca(Evento evento) {
		double valorDigitado = evento.getDouble("valor");
		this.conta.saca(valorDigitado);
	}
}