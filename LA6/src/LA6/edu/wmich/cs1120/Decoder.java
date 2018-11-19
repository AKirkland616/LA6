package LA6.edu.wmich.cs1120;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Decoder implements IDecoder {

	@Override
	public void decode(String filePath) {
		// TODO Auto-generated method stub
		try {
			RandomAccessFile rF = new RandomAccessFile(filePath, "rw");
			try {
				while(1==1){
					System.out.print(rF.readChar());
					int skip = rF.readInt();
					if (skip==-1) {
						break;
					}
					rF.skipBytes(skip);
				}
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


