/**
 * Behavior of state in Word Counter.
 * 
 * @author Patinya Yongyai
 *
 */
public abstract class State {
	/**
	 * Check current the character.
	 * 
	 * @param c
	 *            character from a word
	 */
	public abstract void handleChar(char c);

	/**
	 * Use it to increment the syllable count entering the initial vowel(or
	 * single-vowel) state.
	 */
	public void enterState() {
		// default is do nothing
	}
}
