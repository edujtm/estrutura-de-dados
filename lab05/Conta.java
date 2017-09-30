import SecurityHandler;

public class Conta {

	private String nomeCliente;
	private String saldo;
	private String agencia;
	private String numero;
	private String senha;
	private String md5;

	public Conta(String agencia, String numero, String senha) {
		this.agencia = agencia;
		this.numero = numero;
		this.senha = senha;
	}

	public Conta(String agencia, String numero, String senha, String saldo, String nomeCliente) {
		this.agencia = agencia;
		this.numero = numero;
		this.senha = senha;
		this.saldo = saldo;
		this.nomeCliente = nomeCliente;
	}

	public Conta(String nomeCliente, String saldo) {
		this.nomeCliente = nomeCliente;
		this.saldo = saldo;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public String getSaldo() {
		return saldo;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getConta() {
		return conta;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public void setMD5(String md5) {
		this.md5 = md5;
	}

	public String getMD5() {
		return md5;
	}

	@Override
	public void toString() {
		System.out.println("AGENCIA: " + agencia);
		System.out.println("CONTA: " + conta);
		System.out.println("SENHA: " + senha);
		System.out.println("NOME CLIENTE: " + nomeCliente);
		System.out.println("SALDO: " + saldo);
		System.out.println("MD5: " + md5);
	}
}