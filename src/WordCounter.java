/**
 * 
 * @author Patinya Yongyai
 *
 */
public class WordCounter {
	private final State START = new StartState();
	private final State SINGLEVOWEL = new SingleVowelState();
	private final State CONSONANT = new ConsonantState();
	private final State HYPHEN = new HyphenState();
	private final State MULTIVOWEL = new MultivowelState();
	private final State NONWORD = new NonwordState();
	private final State E = new EState();
	private State state; // the current state
	private int syllableCount = 0;

	/**
	 * 
	 */
	public WordCounter() {
		this.setState(START);
	}

	/**
	 * 
	 * @param word
	 * @return
	 */
	public int countSyllables(String word) {
		char c = ' ';
		syllableCount = 0;
		for (int i = 0; i < word.length(); i++) {
			c = word.charAt(i);
			state.handleChar(c);
		}
		if (state == E && syllableCount > 1)
			syllableCount = syllableCount - 1;
		this.setState(START);
		return syllableCount;
	}

	/** change to a a new state */
	public void setState(State newstate) {
		state = newstate;
	}

	/**
	 * 
	 * @author Not-PC
	 *
	 */
	class SingleVowelState extends State {

		@Override
		public void handleChar(char c) {
			if (isVowelOrY(c)) {
				if (c == 'y' || c == 'Y')
					setState(CONSONANT);
				else
					setState(MULTIVOWEL);
			} else if (isLetter(c) && !isVowelOrY(c)) {
				setState(CONSONANT);
			} else if (c == '-')
				setState(HYPHEN);
			else if (isWhitespace(c))
				setState(START);
		}

	}

	/**
	 * 
	 * @author Not-PC
	 *
	 */
	public class StartState extends State {

		@Override
		public void handleChar(char c) {
			if (isVowelOrY(c)) {
				enterState();
				setState(SINGLEVOWEL);
			} else if (isLetter(c) && !isVowelOrY(c))
				setState(CONSONANT);
			else if (isWhitespace(c))
				setState(START);
			else
				setState(NONWORD);
		}

		public void enterState() {
			syllableCount++;
		}

	}

	/**
	 * 
	 * @author Not-PC
	 *
	 */
	class ConsonantState extends State {

		@Override
		public void handleChar(char c) {
			if (isVowelOrY(c)) {
				if (c == 'e' || c == 'E')
					setState(E);
				else
					setState(SINGLEVOWEL);
				enterState();
			} else if (isLetter(c))/* stay in consonant state */;
			else if (c == '-')
				setState(HYPHEN);
			else if (isWhitespace(c))
				setState(START);
			else
				setState(NONWORD);
		}

		public void enterState() {
			syllableCount++;
		}

	}

	/**
	 * 
	 * @author Not-PC
	 *
	 */
	class HyphenState extends State {

		@Override
		public void handleChar(char c) {
			if (isVowelOrY(c)) {
				setState(SINGLEVOWEL);
				enterState();
			}
			if (isLetter(c) && !isVowelOrY(c))
				setState(CONSONANT);
			else if (c == '-')
				setState(NONWORD);
			else if (isWhitespace(c))
				setState(START);
		}

		public void enterState() {
			syllableCount++;
		}

	}

	/**
	 * 
	 * @author Not-PC
	 *
	 */
	class MultivowelState extends State {

		@Override
		public void handleChar(char c) {
			if (isLetter(c) && !isVowelOrY(c))
				setState(CONSONANT);
			else if (isWhitespace(c))
				setState(START);
		}

	}

	/**
	 * 
	 * @author Not-PC
	 *
	 */
	class NonwordState extends State {

		@Override
		public void handleChar(char c) {
			if (isWhitespace(c))
				setState(START);
		}

	}

	/**
	 * 
	 * @author Not-PC
	 *
	 */
	class EState extends State {

		@Override
		public void handleChar(char c) {
			if (isVowelOrY(c)) {
				if (c == 'e' || c == 'E')
					setState(MULTIVOWEL);
				else if (c == 'y' || c == 'Y')
					setState(CONSONANT);
			} else if (isLetter(c) && !isVowelOrY(c))
				setState(CONSONANT);
			else if (c == '-')
				setState(HYPHEN);
			else if (isWhitespace(c))
				setState(START);
		}

	}

	/**
	 * 
	 * @param c
	 * @return
	 */
	private boolean isLetter(char c) {
		return Character.isLetter(c);
	}

	/**
	 * 
	 * @param c
	 * @return
	 */
	private boolean isWhitespace(char c) {
		return Character.isWhitespace(c);
	}

	/**
	 * 
	 * @param c
	 * @return
	 */
	private boolean isVowelOrY(char c) {
		String str = c + "";
		if (str.equalsIgnoreCase("a") || str.equalsIgnoreCase("e") || str.equalsIgnoreCase("i")
				|| str.equalsIgnoreCase("o") || str.equalsIgnoreCase("u") || str.equalsIgnoreCase("y")) {
			return true;
		}
		return false;
	}
}
