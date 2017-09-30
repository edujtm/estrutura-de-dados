
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
		this.md5 = SecurityHandler.md5ToServer(this);
	}

	public Conta(String agencia, String numero, String senha, String saldo, String nomeCliente) {
		this.agencia = agencia;
		this.numero = numero;
		this.senha = senha;
		this.saldo = saldo;
		this.nomeCliente = nomeCliente;
		this.md5 = SecurityHandler.md5ToServer(this);
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

	public void setNumeroConta(String conta) {
		this.numero = numero;
	}

	public String getNumeroConta() {
		return numero;
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
		return this.md5;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append("AGENCIA: " + agencia + "\n");
		sb.append("CONTA: " + numero + "\n");
		sb.append("SENHA: " + senha + "\n");
		sb.append("NOME CLIENTE: " + nomeCliente + "\n");
		sb.append("SALDO: " + saldo + "\n");
		sb.append("MD5: " + md5 + "\n");
		return sb.toString();
	}

	@Override
	public boolean equals(Object rhs) {
		if (rhs instanceof Conta) {
			return this.md5.equals(((Conta) rhs).md5);
		}
		return false;
	}
}