package br.com.caelum.contas.main;

import br.com.caelum.contas.modelo.Conta;

public class Teste {
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setTitular("Patrick");
		conta.setNumero(123);
		conta.setAgencia("321-0");

		conta.deposita(1000);
		conta.saca(100);

		System.out.println(conta.retornaDadosParaImpressao());

	}
}
