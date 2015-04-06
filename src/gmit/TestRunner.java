package gmit;

import java.text.*;
import java.util.*;

public class TestRunner {
	
	public static void main(String[] args) throws Exception {
	
		Scanner s = new Scanner(System.in);//new scanner s
		System.out.println("Enter text file for encryption (eg filename.txt)"); 
		String textFile = s.next(); //read in textname from user to encrypt
		System.out.println("Enter code word for encryption");
		String codeWord = s.next(); //read in code word from user to encrypt file
		s.close(); //close scanner
		long start = System.currentTimeMillis(); //start timing program
		
		Maps maps = new Maps(); //create instance of Maps class
		maps.setMap(); //set hashmap values
		Encrypt encrypt = new Encrypt(); //create instance of Encrypt class
		Decrypt decrypt = new Decrypt(); //create instance of Decode class
		
		long start1 = System.currentTimeMillis(); //start timing program
		maps.createArrayLists(codeWord);	//create required number of arraylists
		long end1 = System.currentTimeMillis();
		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.println("Create ArrayLIsts " + formatter.format((end1 - start1) / 1000d) + " seconds");
		//encryption methods
		long start2 = System.currentTimeMillis(); //start timing program
		StringBuilder sb=encrypt.encryptFile(maps.getMap(), textFile); //char array takes value returned by encrypt method
		long end2 = System.currentTimeMillis();
		formatter = new DecimalFormat("#0.00000");
		System.out.println("After encrypt method " + formatter.format((end2 - start2) / 1000d) + " seconds");
		
		long start3 = System.currentTimeMillis(); //start timing program
		encrypt.fillArrayListEnc(codeWord, maps.getMatrix(), sb); //file arraylists with encrypted values 
		long end3 = System.currentTimeMillis();
		formatter = new DecimalFormat("#0.00000");
		System.out.println("After Fill array method " + formatter.format((end3 - start3) / 1000d) + " seconds");
		
		long start4 = System.currentTimeMillis(); //start timing program
		int[] codeInt = encrypt.sortArrayList(codeWord); //order of arraylists to be read to file
		long end4 = System.currentTimeMillis();
		formatter = new DecimalFormat("#0.00000");
		System.out.println("After sort array method " + formatter.format((end4 - start4) / 1000d) + " seconds");
		
		long start5 = System.currentTimeMillis(); //start timing program
		encrypt.writeToFile(maps.getMatrix(), codeInt); //write encrypted message to file
		long end5 = System.currentTimeMillis();
		formatter = new DecimalFormat("#0.00000");
		System.out.println("After write to file method " + formatter.format((end5 - start5) / 1000d) + " seconds");
		
		//decryption methods
		long start6 = System.currentTimeMillis(); //start timing program
		int noChars = decrypt.readEncyptFile(codeWord, maps.getMatrixDec(), codeInt); //read in encrypted file and count number of chars read in 
		long end6 = System.currentTimeMillis();
		formatter = new DecimalFormat("#0.00000");
		System.out.println("After read encrypt file method " + formatter.format((end6 - start6) / 1000d) + " seconds");

		
		long start7 = System.currentTimeMillis(); //start timing program
		sb=decrypt.fillArrayListDec(codeWord, maps.getMatrixDec(), noChars); //fill arraylist with read in chars
		long end7 = System.currentTimeMillis();
		formatter = new DecimalFormat("#0.00000");
		System.out.println("Fill decrypt Array " + formatter.format((end7 - start7) / 1000d) + " seconds");
		
		
		long start8 = System.currentTimeMillis(); //start timing program
		decrypt.decryptFile(maps.getMap(), sb); //decrypt the message
		long end8 = System.currentTimeMillis();
		formatter = new DecimalFormat("#0.00000");
		System.out.println("Write decryption file " + formatter.format((end8 - start8) / 1000d) + " seconds");
				
		long end = System.currentTimeMillis();
		formatter = new DecimalFormat("#0.00000");
		System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
	
	}//main
	
}
