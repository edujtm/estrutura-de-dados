import java.security.MessageDigest;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

// Classe que irá possuir os metodos de tradução das entradas e saidas do banco de dados

public class SecurityHandler {

	public static String md5(String stringToConvert)
	{
		String hashtext="";
		// salt é uma string aleatória qualquer
		salt = "rickmorty"
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
			//Logger.getLogger(SecurityProvider.class.getName());
			log(Level.SEVERE, null, ex);
		}
		return hashtext;
	}

}