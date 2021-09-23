

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;

import data.cryptografhy.Crypt;

public class TestZone {

	public static void main(String[] args) {
		
		String texto= "hello world";
		String user= "fefeto";
		String pass= "madara";
		
		String novotexto = null;
		String novo = null;
		
		IvParameterSpec ivParameterSpec = Crypt.generateIv();
		
		System.out.println("Iniciando teste de criptografia \n");
				
		try {
			novotexto = Crypt.encrypt(texto, user, pass,ivParameterSpec);
			
			novo = Crypt.decrypt(novotexto, user, pass,ivParameterSpec);
			
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print("Feito");
		
		System.out.print("\nTexto original: " + texto);
		System.out.print("\nTexto encryptado: " + novotexto);
		System.out.print("\nTexto desencryptado: " + novo);
		
		
		
		

		
	}
}
