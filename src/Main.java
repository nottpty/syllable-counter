import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {
	public static void main(String[] args) throws IOException {
		final String DICT_URL = "https://se.cpe.ku.ac.th/dictionary.txt";
		URL url = new URL(DICT_URL);
		InputStream input = url.openStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		int count = 0;
		SimpleSyllableCounter simpleSyllableCounter = new SimpleSyllableCounter();
		while(true) {
			String word = reader.readLine();
			if(word == null) break;
			count += simpleSyllableCounter.countSyllables(word);
		}
		System.out.println("Counted "+count+" syllables");
	}
}
