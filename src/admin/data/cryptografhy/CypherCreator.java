package admin.data.cryptografhy;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class CypherCreator {
	
	public static SecretKey generate(String entype) {
		
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance(entype);
			SecretKey key = keyGenerator.generateKey();
			
			createfile(key);
			return key;
		}
		catch(Exception e) {
			return null;
		}
	}
	
		public static void createfile(SecretKey key) {
		
		try {
		File file = new File("src/admin/data/cypher/Codec.txt");
		file.createNewFile();
		if(!file.exists()) {
				file.createNewFile();
		}
		
		PrintWriter pw = new PrintWriter(file);
		
		pw.print("/******************************************************************************************\n");
		pw.print("*-----------+++++++-------+++++------+++++++++------+++++++++++++------+++++++------------*\n");
		pw.print("*---------++++++++++-----+++-+++-----++-----+++-----++---------++---+++++++++++-----------*\n");
		pw.print("*--------++++----+++---+++-----+++---++------+++----++-------------++++-----+++-----------*\n");
		pw.print("*--------++++----------+++-----+++---++-------++----++-------------++++-------------------*\n");
		pw.print("+--------++++----------+++-----+++---++-------+++---++++++++++++---++++-------------------*\n");
		pw.print("*--------++++----------+++-----+++---++-------++----++-------------++++-------------------*\n");
		pw.print("*--------++++----+++---+++-----+++---++------+++----++-------------++++-----+++-----------*\n");
		pw.print("*----------+++++++++----+++---+++----++-----+++-----++--------++-----+++++++++------------*\n");
		pw.print("*-----------+++++++------+++++++-----+++++++++------++++++++++++------+++++++-------------*\n");
		pw.print("******************************************************************************************/\n");
		pw.print("key: " + key);
		
		pw.close();
		
		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
