package br.com.caelum.contas;

import br.com.caelum.contas.modelo.Tributavel;
import br.com.caelum.javafx.api.util.Evento;

public class ManipuladorDeTributaveis {
	private int total;

	public void calculaImposto(Evento evento) {
		total = 0;
		int tamanho = evento.getTamanhoDaLista("listaTributaveis");
		for (int i = 0; i < tamanho; i++) {
			Tributavel t = evento.getTributavel("listaTributaveis", i);
			total += t.getValorImposto();
		}
	}

	public int getTotal() {
		return this.total;
	}
}
