package br.com.caelum.contas.modelo;

/**
 * Classe responsável por moldar as Contas do Banco
 *
 * @author Patrick
 *
 */
public abstract class Conta {
	private Cliente titular;
	private int numero;
	private String agencia;
	private Data dataDeAbertura;
	protected double saldo;
	private double limite = 1000;
	private static int identificador = 0;

	/**
	 * Construtor padrão, nele já é gerado a Data de abertura, cria um Cliente e
	 * soma 1 ao identificador
	 *
	 */
	public Conta() {
		this.dataDeAbertura = new Data();
		this.titular = new Cliente();
		Conta.identificador++;
	}

	/**
	 * Construtor que recebe um nome, ele chama o construtor padrão e depois
	 * definir o nome do Titular
	 *
	 * @param nome
	 *
	 *
	 */
	public Conta(String nome) {
		super();
		this.titular.setNome(nome);
	}

	public static int getIdentificador() {
		return identificador;
	}

	public String getTitular() {
		return this.titular.getNome();
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public void setTitular(String nome) {
		this.titular.setNome(nome);
	}

	public Data getDataDeAbertura() {
		return dataDeAbertura;
	}

	public void setDataDeAbertura(Data dataDeAbertura) {
		this.dataDeAbertura = dataDeAbertura;
	}

	public int getNumero() {
		return numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public double getSaldo() {
		return saldo;
	}

	public double getLimite() {
		return limite;
	}

	/**
	 * Método responsável por realizar um saque da Conta
	 *
	 * @param valor
	 * @return
	 */
	public void saca(double valor) {
		if (valor < 0) {
			throw new IllegalArgumentException("Você tentou sacar um valor negativo");
		}
		if (this.saldo < valor) {
			throw new SaldoInsuficienteException(valor);
		}
		this.saldo -= valor;
	}

	/**
	 * Método reponsável por depositar um valor na Conta
	 *
	 * @param valor
	 */
	public void deposita(double valor) {
		if (valor < 0) {
			throw new IllegalArgumentException("Você tentou depositar um valor negativo");
		}
		if (valor > 0) {
			this.saldo += valor;
		}
	}

	/**
	 * Método que transfere um valor para a conta de destino
	 *
	 * @param valor
	 * @param conta
	 */
	public void transfere(double valor, Conta conta) {
		this.saca(valor);
		conta.deposita(valor);
	}

	/**
	 * Método que retorna o rendimento atual da Conta
	 *
	 * @return
	 */
	public double getRendimento() {
		return this.saldo * 0.006;
	}

	/**
	 * Método criado para devolver os dados da Conta formatado, antes de
	 * sobreescrever o toString
	 *
	 * @return
	 */
	public String retornaDadosParaImpressao() {
		String dados = "Nome: " + this.titular.getNome() + "\n";
		dados += "Agência: " + this.agencia + "\n";
		dados += "Número: " + this.numero + "\n";
		dados += "Data de abertura: " + this.dataDeAbertura + "\n";
		dados += "Saldo: " + this.saldo + "\n";
		dados += "Limite: " + this.limite + "\n";
		return dados;
	}

	public abstract String getTipo();

	@Override
	public String toString() {
		return "Conta [titular=" + titular.getNome() + ", numero=" + numero + ", agencia=" + agencia + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
		result = prime * result + numero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}

}
