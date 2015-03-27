package gmit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Encrypt{
	
	
	public char[] encrypt(Map<String, String> polybius, String textFile) throws IOException {
		
		StringBuilder sb = new StringBuilder();  
	
		try {
			File f=new File(textFile);
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			String line;
			String chr;
			
			while((line=br.readLine())!=null){ //while values still to be read in
				char[] ch = line.toCharArray(); //convert read in line to char array c
				int len=ch.length;
				//loop to convert chars to upper case and compare chars to polybius map
				for(int i=0; i<len;i++){
					chr = Character.toString(ch[i]).toUpperCase(); //chars to uppercase
					
					if(polybius.containsKey(chr)){ //if hashmap contains this key
								
						sb.append(polybius.get(chr)); //append value associated with key to stringbuilder
					}
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
			matrix.get(count).add(Character.toString(letters[i])); //using count var, add value above to correct arraylist
			count++;
		}//for
		
	}//fillArrayListEnc
	
	public int[] sortArrayList(String keyword) {
		char[] sortedKey=keyword.toCharArray(); //make char array with keyword value
		char[] oriKey=keyword.toCharArray();
		int len=keyword.length();
		int keyInt [] = new int[len]; //make int array to correspond to keyword values
		Arrays.sort(sortedKey); //sort keyword alphabetically
		for(int i=0; i<len; i++){
			for(int j=0; j<len;j++){
				if(sortedKey[i]==oriKey[j]){
					keyInt[i]=j;
					sortedKey[i]='¬';
					oriKey[j]='|';
				}//if
			}//inner for
		}//outer for
		return keyInt;
	}//sortArrayList
	
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
