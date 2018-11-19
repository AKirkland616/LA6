package LA6.edu.wmich.cs1120;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;

public class Encoder implements IEncoder {

	@Override
	public void encode(String inputFileName, String outputFilePath) {
		// TODO Auto-generated method stub
		try {
			RandomAccessFile rF = new RandomAccessFile(outputFilePath, "rw");
			File f = new File(inputFileName);
			Scanner reader = new Scanner(f);
			String s ="";
			while(reader.hasNextLine()) {
				 s = s+reader.nextLine()+"\n";
			}
			Random rand = new Random();
			char[]v = s.toCharArray();
			for(int i=0;i<v.length;i++) {
				try {
					rF.writeChar(v[i]);
					if (i==v.length-1) {
						rF.writeInt(-1);
					}else {
					int rN = (rand.nextInt(20)+1);
					rF.writeInt(rN);
					byte[] bA=new byte[rN];
					rand.nextBytes(bA);
					rF.write(bA);
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
			reader.close();
			try {
				rF.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
