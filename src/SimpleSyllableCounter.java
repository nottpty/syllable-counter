
public class SimpleSyllableCounter {
	int countSyllables(String word) {
		int syllables = 0;
		char c = ' ';
		State state = State.START;
		for (int k = 0; k < word.length(); k++) {
			c = word.charAt(k);
			if (c == '\'')
				continue; // ignore apostrophe
			switch (state) {
			// process character c using state machine
			case START:
				if (isVowelOrY(c)) {
					syllables++;
					state = State.SINGLE_VOWEL;
				} else if (isLetter(c) && !isVowelOrY(c)) {
					state = State.CONSONANT;
				} else
					state = State.NONWORD;
				break;
			case E:
				if (isVowelOrY(c)) {
					if(c == 'e' || c == 'E'){
						state = State.MULTIVOWEL;
					}
					else if (c == 'y' || c == 'Y')
						state = State.CONSONANT;
				} else if (isLetter(c) && !isVowelOrY(c)) {
					state = State.CONSONANT;
				} else if (c == '-')
					state = State.HYPHEN;
				break;
			case CONSONANT:
				if (isVowelOrY(c)) {
					if(c == 'e' || c == 'E')
						state = State.E;
					else
						state = State.SINGLE_VOWEL;
					syllables++;
				} else if (isLetter(c))
					/* stay in consonant state */;
				else if (c == '-')
					state = State.HYPHEN;
				else
					state = State.NONWORD;
				break;
			case SINGLE_VOWEL:
				if (isVowelOrY(c)) {
					if (c == 'y' || c == 'Y')
						state = State.CONSONANT;
					else
						state = State.MULTIVOWEL;
				} else if (isLetter(c) && !isVowelOrY(c)) {
					state = State.CONSONANT;
				} else if (c == '-')
					state = State.HYPHEN;
				break;
			case MULTIVOWEL:
				if (isLetter(c) && !isVowelOrY(c)) {
					state = State.CONSONANT;
				}
			case NONWORD:
				break;
			case HYPHEN:
				if (isVowelOrY(c)) {
					state = State.SINGLE_VOWEL;
					syllables++;
				}
				if (isLetter(c) && !isVowelOrY(c)) {
					state = State.CONSONANT;
				} else if (c == '-') {
					state = State.NONWORD;
				}
			default:
				if (isWhitespace(c))
					break;
			}
		}
		if(state == State.E && syllables > 1) syllables = syllables-1;
		return syllables;
	}

	private boolean isLetter(char c) {
		return Character.isLetter(c);
	}

	private boolean isWhitespace(char c) {
		return Character.isWhitespace(c);
	}

	private boolean isVowelOrY(char c) {
		String str = c + "";
		if (str.equalsIgnoreCase("a") || str.equalsIgnoreCase("e") || str.equalsIgnoreCase("i")
				|| str.equalsIgnoreCase("o") || str.equalsIgnoreCase("u") || str.equalsIgnoreCase("y")) {
			return true;
		}
		return false;
	}
}
