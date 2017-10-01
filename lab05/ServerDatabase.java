import java.math.BigInteger;
import java.util.ArrayList;

public class ServerDatabase {

	public static final ArrayList<ArrayList<Conta>> contas;
	public static final int N = 100;

	static {
		contas = new ArrayList<ArrayList<Conta>>();
		for (int i = 0; i < N; ++i) {
			contas.add(new ArrayList<Conta>());
		}
	}

	public static int hashCode(String md5) {
		BigInteger bi = new BigInteger(md5, 16);
		BigInteger m = new BigInteger(Integer.toString(N), 10);
		int pos;
		pos = bi.mod(m).intValue();
		return pos;
	}

	public static boolean insereConta(Conta conta) {
		String md5Conta = SecurityHandler.md5ToServer(conta);
		int index = hashCode(md5Conta);

		// Se a conta já estiver inserida retorna false indicando que a operação
		// de inserção não foi feita
		for (int i = 0; i < contas.get(index).size(); ++i) {
			if (conta == contas.get(index).get(i)) return false;
		}

		contas.get(index).add(conta);
		return true;
	}

	public static Conta getConta(String md5) {
		int index = hashCode(md5);
		Conta contaArmazenada;


		for (int i = 0; i < contas.get(index).size(); ++i) {
			contaArmazenada = contas.get(index).get(i);
			if (md5.equals(contaArmazenada.getMD5())) {
				return contaArmazenada;
			}
		}

		return null;
	}

}