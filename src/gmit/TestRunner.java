package gmit;

import java.text.*;
import java.util.*;

public class TestRunner {
	
	public static void main(String[] args) throws Exception {
	
		Scanner s = new Scanner(System.in);//new scanner s
		System.out.println("Enter text file for encryption (eg filename.txt)"); 
		String textFile = s.next(); //read in textname from user to encrypt
		System.out.println("Enter key for encryption");
		String keyword = s.next(); //read in keyword from user to encrypt file
		s.close(); //close scanner
		long start = System.currentTimeMillis(); //start timing program
		
		Maps maps = new Maps(); //create instance of Maps class
		maps.setMap(); //set hashmap values
		Encrypt encrypt = new Encrypt(); //create instance of Encrypt class
		Decode decode = new Decode(); //create instance of Decode class
		
		maps.createArrayLists(keyword);	//pass user inputed keyword to method	
		char[] letters=encrypt.encrypt(maps.getMap(), textFile); //char array takes value returned by encrypt method
		
		encrypt.fillArrayListEnc(keyword, maps.getMatrix(), letters); //pass keyword, arraylist and 
		
		int[] keyInt = decode.sortArrayList(keyword);
		
		encrypt.writeToFile(maps.getMatrix(), keyInt);
		
		
		int noChars = decode.readEncyptFile(keyword, maps.getMatrixDec(), keyInt);
		
		
		String words=decode.fillArrayListDec(keyword, maps.getMatrixDec(), noChars);
				
		decode.decode(maps.getMap(), words);
		
		
		long end = System.currentTimeMillis();
	
		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
	
	}//main
	
}
