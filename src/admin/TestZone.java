package admin;

import java.util.Scanner;

import admin.data.cryptografhy.CypherCreator;
import admin.data.cryptografhy.Encrypt;

public class TestZone {

	public static void main(String[] args) {
		
		int chave;
		String texto;
		String textonovo;
		String novotextonovo;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Iniciando teste de criptografia \n");
		
		System.out.println("tipo de criptografia \n");
		
		
		texto = "AES";
		
		Encrypt encry = new Encrypt();
		
		CypherCreator cycry = new CypherCreator();
		
		CypherCreator.generate(texto);

		System.out.print("\nFeito"
				+ "");
	}
}
