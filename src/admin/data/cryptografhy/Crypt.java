package data.cryptografhy;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

public class Crypt {

	static String algorithm = "AES/CBC/PKCS5Padding";

	//Generate the key by the personal user and pass
	public static SecretKey getKeyFromPassword(String user, String pass) throws NoSuchAlgorithmException, InvalidKeySpecException {

		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		KeySpec spec = new PBEKeySpec(user.toCharArray(), pass.getBytes(), 65536, 256);
		SecretKey originalKey = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");

		return originalKey;

	}

	//Secure pass
	public static IvParameterSpec generateIv() {
		byte[] iv = new byte[16];
		new SecureRandom().nextBytes(iv);
		return new IvParameterSpec(iv);
	}

	//Encrypt Code
	public static String encrypt(String textinput, String user, String pass, IvParameterSpec iv)

			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, InvalidAlgorithmParameterException,
			IllegalBlockSizeException, BadPaddingException{

		SecretKey key = null;

		try {
			key = getKeyFromPassword(user, pass);

		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {

			JOptionPane.showMessageDialog(null, "Não foi possivel gerar chave", " Alerta ", JOptionPane.ERROR_MESSAGE);
		}

		Cipher cipher = Cipher.getInstance(algorithm);

		cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		byte[] cipherText = cipher.doFinal(textinput.getBytes());

		return Base64.getEncoder().encodeToString(cipherText);
	}

	//Decrypt Code
	public static String decrypt(String cipherText, String user, String pass, IvParameterSpec iv)

			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, InvalidAlgorithmParameterException,
			IllegalBlockSizeException, BadPaddingException{

		SecretKey key = null;

		try {
			key = getKeyFromPassword(user, pass);

		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {

			JOptionPane.showMessageDialog(null, "Não foi possivel gerar chave", " Alerta ", JOptionPane.ERROR_MESSAGE);
		}

		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.DECRYPT_MODE, key, iv);
		byte[] originaltext = cipher.doFinal(Base64.getDecoder().decode(cipherText));
		return new String(originaltext);
	}

}
