package gmit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Maps {

	private static Map<String,String> polybius=new HashMap<String,String>(100);
	private static List<List<String>> matrix = new ArrayList<List<String>>();
	private static List<List<String>> matrixDec = new ArrayList<List<String>>();
	
	public void setMap() {
		polybius.put("AA", "P");polybius.put("P","AA");polybius.put("AD", "H");polybius.put("H", "AD");polybius.put("AF", "0");
		polybius.put("0", "AF");polybius.put("AG", "Q");polybius.put("Q", "AG");polybius.put("AV", "G");polybius.put("G", "AV");
		polybius.put("AX", "6");polybius.put("6", "AX");polybius.put("AZ", " ");polybius.put(" ", "AZ");polybius.put("DA", "4");
		polybius.put("4", "DA");polybius.put("DD", "M");polybius.put("M", "DD");polybius.put("DF", "E");polybius.put("E", "DF");
		polybius.put("DG", "A");polybius.put("A", "DG");polybius.put("DV", "1");polybius.put("1", "DV");polybius.put("DX", "Y");
		polybius.put("Y", "DX");polybius.put("DZ", ",");polybius.put(",", "DZ");polybius.put("FA", "L");polybius.put("L", "FA");
		polybius.put("FD", "2");polybius.put("2", "FD");polybius.put("FF", "N");polybius.put("N", "FF");polybius.put("FG", "O");
		polybius.put("O", "FG");polybius.put("FV", "F");polybius.put("F", "FV");polybius.put("FX", "D");polybius.put("D", "FX");
		polybius.put("FZ", ".");polybius.put(".", "FZ");polybius.put("GA", "X");polybius.put("X", "GA");polybius.put("GD", "K");
		polybius.put("K", "GD");polybius.put("GF", "R");polybius.put("R", "GF");polybius.put("GG", "3");polybius.put("3", "GG");
		polybius.put("GV", "C");polybius.put("C", "GV");polybius.put("GX", "V");polybius.put("V", "GX");polybius.put("GZ", "!");
		polybius.put("!", "GZ");polybius.put("VA", "S");polybius.put("S", "VA");polybius.put("VD", "5");polybius.put("5", "VD");
		polybius.put("VF", "Z");polybius.put("Z", "VF");polybius.put("VG", "W");polybius.put("W", "VG");polybius.put("VV", "7");
		polybius.put("7", "VV");polybius.put("VX", "B");polybius.put("B", "VX");polybius.put("VZ", "?");polybius.put("?", "VZ");
		polybius.put("XA", "J");polybius.put("J", "XA");polybius.put("XD", "9");polybius.put("9", "XD");polybius.put("XF", "U");
		polybius.put("U", "XF");polybius.put("XG", "T");polybius.put("T", "XG");polybius.put("XV", "I");polybius.put("I", "XV");
		polybius.put("XX", "8");polybius.put("8", "XX");polybius.put("XZ", "-");polybius.put("-", "XZ");polybius.put("ZA", "(");
		polybius.put("(", "ZA");polybius.put("ZD", ")");polybius.put(")", "ZD");polybius.put("ZF", ":");polybius.put(":", "ZF");
		polybius.put("ZG", ";");polybius.put(";", "ZG");polybius.put("ZV", "*");polybius.put("*", "ZV");
	}//setMap
	
	public Map<String, String> getMap() {

		return polybius;
		
	}
	
	public void createArrayLists(String keyword) {
		for(int i=0; i<keyword.length();i++){
			
			matrix.add(i, new ArrayList<String>());
			matrixDec.add(i, new ArrayList<String>());
		}
	}//createArrayLists
	
	public List<List<String>> getMatrix(){
		
		return matrix;
		
	}
	
	public List<List<String>> getMatrixDec(){
		
		return matrixDec;
	}
}
