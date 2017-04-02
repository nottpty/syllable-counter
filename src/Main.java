import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * A main class to create objects and run the program.
 * 
 * @author Patinya Yongyai
 *
 */
public class Main {
	/**
	 * Main application for run Word Counter.
	 * 
	 * @param args not used
	 * @throws IOException when Input file is invalid
	 */
	public static void main(String[] args) throws IOException {
		final String DICT_URL = "https://se.cpe.ku.ac.th/dictionary.txt";
		URL url = new URL(DICT_URL);
		InputStream input = url.openStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		int count = 0;
		WordCounter wordCounter = new WordCounter();
		while(true) {
			String word = reader.readLine();
			if(word == null) break;
			count += wordCounter.countSyllables(word);
		}
		System.out.println("Counted "+count+" syllables");
	}
	
	public BufferedReader readInputFile(String URL) throws IOException{
		final String DICT_URL = "https://se.cpe.ku.ac.th/dictionary.txt";
		URL url = new URL(DICT_URL);
		InputStream input = url.openStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		return reader;
	}
}
