package LA6.edu.wmich.cs1120;
/**
 * 
 * @author Chris Niersbach and Anthony Kirkland
 *
 */

public class Main {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		IEncoder encoder = new Encoder();
		IDecoder decoder = new Decoder();
		String inputFileName = "input.txt";
		String encodedFileName = inputFileName+".encode";
		encoder.encode(inputFileName,encodedFileName);
		decoder.decode(encodedFileName);		
	}
}

