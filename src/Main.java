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
	private static int countSyllables = 0;
	private static int countWord = 0;

	/**
	 * Main application for run Word Counter.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		final String DICT_URL = "https://se.cpe.ku.ac.th/dictionary.txt";
		readInputFile(DICT_URL);
		System.out.println("Reading words from " + DICT_URL);
		long startTime = System.nanoTime();
		System.out.println("Counted " + countSyllables + " syllables in " + countWord + " words");
		double elapsedTime = (double) ((System.nanoTime() - startTime) * 1.0E-9);
		System.out.printf("Elapsed time: " + "%.8f" + " sec", elapsedTime);
	}

	/**
	 * Read file from URL and also count syllables and word.
	 * 
	 * @param URL
	 *            directory of file
	 */
	public static void readInputFile(String URL) {
		URL url;
		try {
			url = new URL(URL);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e.getMessage());
		}
		InputStream input;
		try {
			input = url.openStream();
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		OOSyllableCounter wordCounter = new OOSyllableCounter();
		while (true) {
			String word;
			try {
				word = reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage());
			}
			countWord++;
			if (word == null)
				break;
			countSyllables += wordCounter.countSyllables(word);
		}
	}
}
