package br.com.caelum.contas.modelo;

public class SeguroDeVida implements Tributavel {
	private double valor;
	private String titular;
	private int numeroApolice;

	@Override
	public double getValorImposto() {
		return 42 + this.valor * 0.02;
	}

	@Override
	public String getTitular() {
		return this.titular;
	}

	@Override
	public String getTipo() {
		return "Seguro de Vida";
	}

	public int getNumeroApolice() {
		return numeroApolice;
	}

	public void setNumeroApolice(int numeroApolice) {
		this.numeroApolice = numeroApolice;
	}

}
