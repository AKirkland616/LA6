package LA6.edu.wmich.cs1120;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Encoder implements IEncoder {

	@Override
	public void encode(String inputFileName, String outputFilePath) {
		// TODO Auto-generated method stub				
		File f = new File(inputFileName);
		try {
		Scanner reader = new Scanner(f);
		ArrayList<Character> a = new ArrayList<>();
		while(reader.hasNextLine()) {
		String s = reader.nextLine();
		Random rand = new Random();
		char[] v = s.toCharArray();
		for (int i =0;i<v.length;i++) {
			a.add(v[i]);
			if(i!=s.length()-1) {
				String p = Integer.toString((rand.nextInt(20)+1));
				a.add(p.toCharArray()[0]);
			}
		}
		a.add('q');
		}
		a.add('z');
		RandomAccessFile randomFile = new RandomAccessFile(outputFilePath, "rw");
		for(int i =0;i<a.size();i++) {
			try {
				randomFile.writeChar(a.get(i));
				if(Character.isDigit(a.get(i)) && Character.getNumericValue(a.get(i))!= -1) {
					int b = Character.getNumericValue(a.get(i));
					for(int z =1;z<b;z++) {
						randomFile.write(' ');
					}
				}else if (a.get(i)== 'z') {
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//randomFile.w);
		
		}catch(FileNotFoundException e) {
			//e.getMessage();
		}
		
		
	}

}
