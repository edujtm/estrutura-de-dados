import java.util.HashMap;

public class Database {

	// Utilizei o hashmap para facilitar as consultas, usar o ArrayList<Letra>
	// iria dar uma complexidade O(N) para cada letra do nome + saldo.
	public static final HashMap<String, Character> caracteres;

	static {
		caracteres = new HashMap<>(60);

		for (char c = 'a'; c <= 'z'; ++c) {
			String md5 = SecurityHandler.md5(Character.toString(c));
			caracteres.put(md5, c);
		}

		for (char c = 'A'; c <= 'Z'; ++c) {
			String md5 = SecurityHandler.md5(Character.toString(c));
			caracteres.put(md5, c);
		}

		for (char c = '0'; c <= '9'; ++c) {
			String md5 = SecurityHandler.md5(Character.toString(c));
			caracteres.put(md5, c);
		}

		String md5 = SecurityHandler.md5(Character.toString(' '));
		caracteres.put(md5, ' ');
	}

	public static char getLetra(String md5) {
		return caracteres.get(md5);
	}

	public static Conta getConta(String[] md5Chars) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < md5Chars.length; ++i) {
			char c = getLetra(md5Chars[i]);
			sb.append(c);
		}
		String[] info = sb.toString().split(" ");
		Conta resultado;

		// Para o caso de haver vários nomes na conta;
		if (info.length > 1) {
			StringBuilder sbName = new StringBuilder();
			sbName.append(info[0]);
			for (int i = 1; i < info.length-1; ++i) {
				sbName.append(" " + info[i]);
			}
			String name = sbName.toString();
			String saldo = info[info.length-1];
			resultado = new Conta(name, saldo);
		} else {
			// Algum erro deveria ser retornado aqui, mas acredito que isso nunca vai acontecer
			return null;
		}
		return resultado;
	}
}