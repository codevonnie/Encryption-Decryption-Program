package gmit;

import java.io.*;
import java.util.*;

public class Encrypt{
	
	
	/* This method reads in a the file for encryption. It contains a while loop
	 * for reading using a buffered reader and a for loop to loop through the 
	 * read in characters.  It searches the hashmap using containsKey which is
	 * 0(1) time and gets the character associated with the key which is also
	 * 0(1) time
	 */
	
	public StringBuilder encryptFile(Map<String, String> polybius, String textFile) throws IOException {
		
		StringBuilder sb = new StringBuilder(); 
		//StringBuilder strB = new StringBuilder();
		File f=new File(textFile);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		String line;
		String chr;
		int i=0;
		
		while((line=br.readLine())!=null){ //while values still to be read in
			char[] ch = line.toCharArray(); //convert read in line to char array c
			
			int len=ch.length;
			//loop to convert chars to upper case and compare chars to polybius map
			while(i<len){
				chr = Character.toString(ch[i]).toUpperCase(); //chars to uppercase
				
				if(polybius.containsKey(chr)){ //if hashmap contains this key
							
					sb.append(polybius.get(chr)); //append value associated with key to stringbuilder
				}
				i++;
			}		
			i=0;
			sb.append(polybius.get("\n"));
		}//while */
		br.close();
		return sb;
   
	}//encryptFile
	
	/* This method fills the arraylist "matrix" with the encrypted chars from the file
	 * Filling an arraylist is linear time O(n)
	 */
	public void fillArrayListEnc(String codeWord, List<List<Character>> matrix, StringBuilder sb) {
		
		int count=0, i=0;
		int len=sb.length();
		int codeLen=codeWord.length();
		while(i<len){
			matrix.get(count).add(sb.charAt(i)); //using count, add value above to correct arraylist
			i++;
			count++;
			
			if(count==codeLen)
				count=0;
			}
		
	}//fillArrayListEnc
	
	/* This method sorts what order to write the arraylists to the file
	 * for columnar transposition - that is alphabetising the code word
	 * and reading the sorted columns to the file
	 * The nested for loops have a running time of O(n^m)
	 */
	public int[] sortArrayList(String codeWord) {
		char[] sortedKey=codeWord.toCharArray(); //make char array with keyword value
		char[] oriKey=codeWord.toCharArray();
		int len=codeWord.length();
		int keyInt [] = new int[len]; //make int array to correspond to keyword values
		Arrays.sort(sortedKey); //sort keyword alphabetically
		for(int i=0; i<len; i++){
			for(int j=0; j<len;j++){
				if(sortedKey[i]==oriKey[j]){
					keyInt[i]=j;
					sortedKey[i]='`';
					oriKey[j]='¬';
						}//if
				
			}//inner for
			
		}//outer for
		return keyInt;
	}//sortArrayList
	
	/* This method writes the chars in order of the alphabetised code word
	 * It uses both a for loop and a nested for-in loop with a running time of
	 * O(n*m) 
	 */
	public void writeToFile(List<List<Character>> matrix, int[] codeInt) throws FileNotFoundException {
		
		StringBuilder sb = new StringBuilder();
		PrintWriter writer = null;
		int len=codeInt.length;
		int i=0;

		writer = new PrintWriter("encrypted.txt");
		//loop to read arraylist columns in order of alphabetically sorted keyword
		while(i<len){
			for(Character list: matrix.get(codeInt[i])){
			
				sb.append(list);
			}
			i++;
			writer.print(sb);
			writer.println();
			sb.setLength(0);
		}
		
		writer.flush();
		writer.close();
	}//writeToFile
}
