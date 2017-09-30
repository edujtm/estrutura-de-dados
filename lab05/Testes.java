
public class Testes {

	public static void main(String[] args) {
		testConta();
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
}