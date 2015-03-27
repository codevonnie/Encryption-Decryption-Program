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

public class Decode {

	public int[] sortArrayList(String keyword) {
		char[] sortedKey=keyword.toCharArray(); //make char array with keyword value
		char[] oriKey=keyword.toCharArray();
		int keyInt [] = new int[keyword.length()]; //make int array to correspond to keyword values
		Arrays.sort(sortedKey); //sort keyword alphabetically
		for(int i=0; i<keyword.length(); i++){
			for(int j=0; j<keyword.length();j++){
				if(sortedKey[i]==oriKey[j]){
					keyInt[i]=j;
					sortedKey[i]='¬';
					oriKey[j]='|';
				}//if
			}//inner for
		}//outer for
		return keyInt;
	}//sortArrayList
	
	public int readEncyptFile(String keyword, List<List<String>> matrixDec, int[] keyInt)
			throws IOException {
		
		File decodeF=new File("encrypted.txt"); //new file containing encrypted message
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(decodeF))); //open new inputStream to read into bufferedReader
		String dline;
		int noChars=0;
		int count=0;
		while((dline=br.readLine())!=null){
			char[] ch = dline.toCharArray();
						
			for(int i=0;i<ch.length;i++){
								
				if(count>=keyword.length()){
					count=0;
				}
				matrixDec.get(keyInt[count]).add(Character.toString(ch[i]).toString()); //using count var, add value above to correct arraylist
				noChars++;
			}//for
			count++;
		}
		br.close();
		return noChars;
	}//readEncyptFile
	
	public String fillArrayListDec(String keyword,
			List<List<String>> matrixDec, int noChars) {
		
		
		StringBuilder sb = new StringBuilder();
		int rows, j=0, i=0;
		if(noChars%keyword.length()!=0){
			rows=(noChars/keyword.length())+1;
		}
		else{
			rows=(noChars/keyword.length());
		}
		while((j<rows)&&(noChars!=0)){
			while((i<keyword.length())&&(noChars!=0)){
							
					sb.append(matrixDec.get(i).get(j));
					noChars--;
					i++;
			}
			i=0;
			j++;
		}
		return sb.toString();
	}//fillArrayListDec

	public void decode(Map<String, String> polybius, String words) {
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("decoded.txt", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //printwriter to write decrypted values to
		StringBuilder sb = new StringBuilder();
		String chr;
		int i;
		char[] letters=words.toCharArray(); //convert string value to a character array
		for(i=0;i<letters.length;i+=2){
			
			chr=Character.toString(letters[i]).toString()+Character.toString(letters[i+1]).toString();
			
			if(polybius.containsKey(chr)){
					
				sb.append(polybius.get(chr));
			}
		}
		writer.println(sb);
		writer.flush();
		writer.close();
	}//decode
}
