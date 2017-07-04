package br.com.caelum.contas.modelo;

public class Cliente {
	private String nome;
	private String cpf;
	private String dataDeNascimento;

	public Cliente() {
	};

	public Cliente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

}
