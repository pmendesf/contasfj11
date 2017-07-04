package br.com.caelum.contas.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Data {
	private String data;

	Data() {

		// Usando a API do Java8 para datas LocalDate para pegar a data atual
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.data = hoje.format(formatador);
	}

	@Override
	public String toString() {
		return data;
	}

}
