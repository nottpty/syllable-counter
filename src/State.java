/**
 * State of Word Counter
 * 
 * @author Patinya Yongyai
 *
 */
public abstract class State {
	/**
	 * 
	 * @param c
	 */
	public abstract void handleChar(char c);
	/**
	 * 
	 */
	public void enterState() {
		// default is do nothing
	}
}
