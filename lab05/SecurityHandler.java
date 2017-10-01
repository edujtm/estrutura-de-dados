import java.security.MessageDigest;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;
import java.util.logging.Level;

// Classe que irá possuir os metodos de tradução das entradas e saidas do banco de dados

public class SecurityHandler {

	public static final String salt = "5a1t";

	public static String md5(String stringToConvert)
	{
		String hashtext="";
		// salt é uma string aleatória qualquer
		stringToConvert += salt;
		MessageDigest m;
		try
		{
			m = MessageDigest.getInstance("MD5");
			m.reset();
			m.update(stringToConvert.getBytes());
			byte[] digest = m.digest();

			// O construtor possui dois parametros, o primeiro indica o sinal do BigInteger 
			// e o segundo a magnitude
			BigInteger bigInt = new BigInteger(1,digest);
			hashtext = bigInt.toString(16);

		}
		catch (NoSuchAlgorithmException ex)
		{
			Logger mylogger = Logger.getLogger(SecurityHandler.class.getName());
			mylogger.log(Level.SEVERE, null, ex);
		}
		return hashtext;
	}

	public static String md5ToServer(Conta conta) {
		StringBuilder sb = new StringBuilder("");
		sb.append(conta.getAgencia());
		sb.append(conta.getNumeroConta());
		sb.append(conta.getSenha());
		// Adding salt twice because i'm a Master Chef.
		sb.append(salt);
		String result = md5(sb.toString());
		return result;
	}

	public static String[] md5ToClient(Conta conta) {
		String toCrypt = conta.getNomeCliente() + " " + conta.getSaldo();
		String[] cryptedChars = new String[toCrypt.length()];
		for (int i = 0; i < toCrypt.length(); ++i) {
			String charToCrypt = Character.toString(toCrypt.charAt(i));
			cryptedChars[i] = md5(charToCrypt);
		}

		return cryptedChars;
	}
}