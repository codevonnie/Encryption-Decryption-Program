package gmit;

import java.io.*;
import java.util.*;

public class Decode {
	
	public int readEncyptFile(String keyword, List<List<String>> matrixDec, int[] keyInt)
			throws IOException {
		
		File decodeF=new File("encrypted.txt"); //new file containing encrypted message
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(decodeF))); //open new inputStream to read into bufferedReader
		String dline=null;
		int noChars=0, count=0;
		
		while((dline=br.readLine())!=null){
			char[] ch = dline.toCharArray();
			int len=ch.length;
			for(int i=0;i<len;i++){
				
								
				if(count==len){
					count=0;
				}
				
				matrixDec.get(keyInt[count]).add(Character.toString(ch[i])); //using count var, add value above to correct arraylist
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
		int len=keyword.length();
		if(noChars%len!=0){
			rows=(noChars/len)+1;
		}
		else{
			rows=(noChars/len);
		}
		while((j<rows)&&(noChars!=0)){
			while((i<len)&&(noChars!=0)){
							
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
		int len=letters.length;
		for(i=0;i<len;i+=2){
			
			chr=Character.toString(letters[i])+Character.toString(letters[i+1]);
			
			if(polybius.containsKey(chr)){
					
				sb.append(polybius.get(chr));
			}
		}
		writer.println(sb);
		writer.flush();
		writer.close();
	}//decode
}
