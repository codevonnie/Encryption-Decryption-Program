package gmit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

public class Encrypt{
	
	
	public char[] encrypt(Map<String, String> polybius, String textFile) throws IOException {
		
		StringBuilder sb = new StringBuilder();  
	
		try {
			File f=new File(textFile);
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			String chr;
			char ch;
			int c;
			//String line;
			while((c=br.read())!=-1){ //while values still to be read in
				
				ch = (char)c; //chars to uppercase
				chr=Character.toString(ch).toUpperCase();
				if(polybius.containsKey(chr)){ //if hashmap contains this key
							
					sb.append(polybius.get(chr)); //append value associated with key to stringbuilder
				}
				
			}//while */
			br.close();
			char[] character=sb.toString().toCharArray();
					
			return character;
		} catch (Exception e) {
			System.out.println("[ERROR] Encountered a problem reading the inputed file. " + e.getMessage());
			return null;
			
		} //printwriter to write decrypted values to
   
	}//encrypt
	
	public void fillArrayListEnc(String keyword, List<List<String>> matrix, char[] letters) {
		int count=0;
		int len=letters.length;
		int wordLen=keyword.length();
		for(int i=0;i<len;i++){
			
			if(count==wordLen){ //if var count is equal to the length of the keyword, reset to zero
				count=0;
			}
			matrix.get(count).add(Character.toString(letters[i]).toString()); //using count var, add value above to correct arraylist
			count++;
		}//for
		
	}//fillArrayListEnc
	
	public void writeToFile(List<List<String>> matrix, int[] keyInt) {
		PrintWriter writer = null;
		int len=keyInt.length;
		try {
			writer = new PrintWriter("encrypted.txt", "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //printwriter to write encrypted values to
		//loop to read arraylist columns in order of alphabetically sorted keyword
		for(int i=0; i<len;i++){
			for(String list: matrix.get(keyInt[i])){
			
				writer.print(list);
			}
			writer.println();
		}
		writer.flush();
		writer.close();
	}//writeToFile
}
