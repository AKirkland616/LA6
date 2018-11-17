package LA6.edu.wmich.cs1120;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Decoder implements IDecoder {

	@Override
	public void decode(String filePath) {
		// TODO Auto-generated method stub

		File f = new File(filePath);
		try {
			Scanner reader = new Scanner(f);
			ArrayList<Character> a = new ArrayList<>();
			//reader.
			while(reader.hasNextLine()) {
				char[] idk = reader.nextLine().toCharArray();
				for (int i=0;i<idk.length;i++) {
					
				if(idk[i]=='z') {
					break;
				}
				if (Character.isDigit(idk[i]) && Character.getNumericValue(idk[i]) != -1) {
					int skip=Character.getNumericValue(idk[i]);
					i = i+(skip-1);
				}
				else {
					a.add(idk[i]);
				//	System.out.print(idk[i]);
				}
				}
			}
			for(int i =0;i<a.size();i++) {
				if (a.get(i)=='-') {
					System.out.print("\n");
				}else {
					System.out.print(a.get(i));
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}

}
