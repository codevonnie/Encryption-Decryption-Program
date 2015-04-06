package gmit;

import java.io.*;
import java.util.*;

public class Decrypt {
	
	/* This method reads in line by line from the encrypted file 
	 * It fills the arraylist "matrixDec" with the characters in the order to be decrypted
	 * Filling the arraylist is linear time O(n) because the characters are being added to
	 * specific locations in the arraylist  
	 */
	public int readEncyptFile(String keyword, List<List<Character>> matrixDec, int[] codeInt)
			throws IOException {
		
		File decodeF=new File("encrypted.txt"); //new file containing encrypted message
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(decodeF))); //open new inputStream to read into bufferedReader
		String dline=null;
		int noChars=0, count=0;
		int listLen=codeInt.length;
		while((dline=br.readLine())!=null){
			char[] ch = dline.toCharArray();
			int chLen=ch.length;
			for(int i=0;i<chLen;i++){
								
				if(count==listLen){
					count=0;
				}
				
				matrixDec.get(codeInt[count]).add(ch[i]); //using count var, add value above to correct arraylist
				noChars++;
			}//for
			count++;
		}
		br.close();
		return noChars;
	}//readEncyptFile
	
	/* This method tilss the decrypted arraylist depending on
	 * the sorted order of the columns. The if-else statement
	 * runs at O(1) time. The nested while loop runs at
	 * O(n*m+n) time
	 */
	public StringBuilder fillArrayListDec(String codeWord,
			List<List<Character>> matrixDec, int noChars) {
		
		
		StringBuilder sb = new StringBuilder();
		int rows;
		int len=codeWord.length();
		
		if(noChars%len!=0){
			rows=(noChars/len)+1;
		}
		else{
			rows=(noChars/len);
		}
				
		for (int j = 0; j < rows; j++)
	    {
	      for (int i = 0; i < len; i++)
	      {
	        List<Character> rowList = matrixDec.get(i);
	        if (j < rowList.size())
	        {
	        	sb.append(rowList.get(j));
	        }
	      }
	      
	    }
	  		
		return sb;
	}//fillArrayListDec

	/* This method decrypts the message and writes it to file.
	 * It contains a for loop reading in two characters at a time at O(n) running time
	 *  and adds them to a string.  It searches the hashmap using containsKey which is
	 * 0(1) time and gets the character associated with the key which is also
	 * 0(1) time
	 */
	
	public void decryptFile(Map<String, String> polybius, StringBuilder sb) throws FileNotFoundException {
		
		PrintWriter writer = null;
		writer = new PrintWriter("decrypted.txt");
		StringBuilder strB = new StringBuilder();
		String chr;
		int i=0;
		int len=sb.length();
		while(i<len){
			
			chr=sb.substring(i, i+2);
			
			if(polybius.containsKey(chr)){
					
				strB.append(polybius.get(chr));
			}
			i+=2;
		}
		writer.println(strB);
		writer.flush();
		writer.close();
	}//decryptFile
}
