
public class Testes {

	public static void main(String[] args) {
		test4();
	}

	public static void testASCII() {
		for (int i = 97; i < 97 + 26; ++i) {
			System.out.println(((char) i));
		}
	}

	public static void testConta() {
		System.out.println("Testando contas: ");
		Conta c1 = new Conta("124", "333", "1234", "10", "john doe");
		System.out.println(c1);
		Conta c2 = new Conta("John Doe", "10");
		System.out.println(c2);
		Conta c3 = new Conta("123", "321", "666");
		System.out.println(c3);
	}

	public static void test1() {
		System.out.println("Testando Criptografia");
		System.out.println("0x" + SecurityHandler.md5("teste"));
	}

	public static void test2() {
		System.out.println("Testando mensagem criptografada pra servidor: ");
		Conta c = new Conta("1234", "2222", "1245");
		System.out.println("0x" + SecurityHandler.md5ToServer(c));
	}

	public static void test3() {

		// Tenta inserir a conta no banco de dados
		Conta c = new Conta("1234", "2222", "1245");
		System.out.println("Tentando inserir conta...");
		boolean inserido = ServerDatabase.insereConta(c);
		System.out.println("Conta inserida: " + inserido + "\n");

		// Tenta inserir duas vezes a mesma conta
		System.out.println("Tentando inserir a mesma conta novamente...");
		inserido = ServerDatabase.insereConta(c);
		System.out.println("Conta inserida: " + inserido + "\n");
		
		// Tenta recuperar uma conta que está no banco de dados
		System.out.println("Testando recuperação da conta no servidor...");
		String chave = SecurityHandler.md5ToServer(c);
		System.out.println("Chave obtida: " + chave);
		Conta conta = ServerDatabase.getConta(chave);
		if (conta != null) {
			System.out.println("Conta recuperada com sucesso.");
			System.out.println(conta);
		} else {
			System.out.println("Falha ao recuperar conta.\n");
		}

		// Tenta recuperar uma conta que não está no banco de dados
		System.out.println("Tentando recuperar uma conta não existente...");
		Conta outraConta = new Conta("111", "2222", "123");
		chave = SecurityHandler.md5ToServer(outraConta);
		Conta contaNula = ServerDatabase.getConta(chave);
		if (contaNula == null) {
			System.out.println("Sucesso ao tentar recuperar conta nao existente. Retorno nulo\n");
		} else {
			System.out.println("Problema ao tentar recuperar conta nao existente. Retorno: " + contaNula);
		}
	}

	public static void test4()
	{
		Conta c = new Conta("124", "333", "1234","10", "john doe");
		ServerDatabase.insereConta(c);
		String chave = SecurityHandler.md5ToServer(c);
		Conta conta = ServerDatabase.getConta(chave);
		String chars[];
		chars = SecurityHandler.md5ToClient(conta);
		for(int i=0;i<chars.length;i++)
		{
			System.out.println(chars[i]);
		}
	}
}