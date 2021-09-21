package admin.data.cryptografhy;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class Encrypt {
	
	private static final String UNICODE_FORMAT = "UTF-8";
	
	public void cypherreader() {
		 
	}
	
	
	public static byte[] crypty(String text, SecretKey key, Cipher cipher) {
		
		try {
			byte[] maintext = text.getBytes(UNICODE_FORMAT);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] exittext = cipher.doFinal(maintext);
			
			return exittext;
		}
		catch (Exception e) {
			return null;
		}
		
	}
	
	public static String incrypty(byte[] text, SecretKey key, Cipher cipher) {
		
		try {
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] exittext = cipher.doFinal(text);
			String exit = new String(exittext);
			
			return exit;
		}
		catch(Exception e) {
			return null;
		}
		
	}
}
