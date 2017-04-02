# Syllable Counter

This application count the words and syllables of a file.

## How to count syllables?

The number of syllables in a word is equal to the number of vowel sequences -- groups of vowels.
A vowel sequence is one or more vowels that occur together. A vowel is a, e, i, o, u, or (sometimes) y.
Here are the cases with examples:
```
1. Groups of consecutive vowels count as one syllable. vowels are: a e i o u. y counts as vowel only
if it is the first vowel in a vowel group.
  banana = 3 vowel sequences b(a)n(a)n(a)
  durian = 2 vowel sequences d(u)r(ia)n
  beauty = 2 vowel sequences b(eau)t(y)
  layout = 2 vowel sequences l(a)y(ou)t. "y" is not counted as a vowel because it comes after another vowel.

2. A final "e" as a single vowel is not counted, unless it is the only vowel in the word.
  apple = 1 vowel sequence (a)pple Don't count final "e".
  louvre = 1 vowel sequence l(ou)vre Don't count final "e".
  The, me, he, she, we = 1 vowel sequence. Count the final "e" because it is the only vowel.
  movie = 2 vowel sequences m(o)v(ie) Final "e" is part of a multi-vowel group, so count it!
  levee = 2 vowel sequences l(e)v(ee). Same reason as "movie".

3. "y" counts as a vowel if is the first vowel in a vowel group; it is a consonant otherwise.
  try = 1 vowel sequence, "y" acts like vowel: tr(y)
  beyond = 2 vowel sequences, "y" acts like consonant: b(e)y(o)nd
  yesterday = 3 vowel sequences: (ye)st(e)rd(a)y
  Yahoo = 2 vowel sequences (Ya)h(oo)

4. A dash '-' in the middle of word acts like a consonant and divides vowel sequences.
  anti-oxidant = 5 vowel sequences (a)nt(i)-(o)x(i)d(a)nt
  next-door = 2 vowel sequences in one word n(e)xt-d(oo)r
  -oxidant = not a word. Dash cannot be at start of a word.
  anti- = Ignore dash at end of word. It sometimes occurs in writing.

5. Ignore apostrophe (') anywhere in the word, including beginning and end.
  isn't = isnt
  student's = students' = students

6. Not a word. Any string that contains non-letters or doesn't contain any vowels is not a word.
The only exceptions are "-" and apostophe (') in case 4 and 5.
  mrtg
  Java5se
  I.B.M. ("." between letters)
  7-Eleven (contains "7")
```
## Author
* **Patinya Yongyai**
