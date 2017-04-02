
public class WordCounter {
	private final State START = new StartState();
	private final State SINGLEVOWEL = new SingleVowelState();
	private final State CONSONANT = new ConsonantState();
	private final State HYPHEN = new HyphenState();
	private final State MULTIVOWEL = new MultivowelState();
	private final State NONWORD = new NonwordState();
	private State state; // the current state
	private int syllableCount = 0;

	/** change to a a new state */
	public void setState(State newstate) {
		// this "if" may not be necessary.
		if (newstate != state){
			newstate.enterState();
		}
		state = newstate;
	}
}
