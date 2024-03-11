import java.util.HashMap;

public class Logic {
    private final HashMap<String, Character> morseToChar;
    private final HashMap<Character, String> charToMorse;

    public Logic() {
        morseToChar = new HashMap<>();
        charToMorse = new HashMap<>();
        populateMaps();
    }

    private void populateMaps() {
        morseToChar.put("*-", 'A');
        morseToChar.put("-***", 'B');
        morseToChar.put("-*-*", 'C');
        morseToChar.put("-**", 'D');
        morseToChar.put("*", 'E');
        morseToChar.put("**-*", 'F');
        morseToChar.put("--*", 'G');
        morseToChar.put("****", 'H');
        morseToChar.put("**", 'I');
        morseToChar.put("*---", 'J');
        morseToChar.put("-*-", 'K');
        morseToChar.put("*-**", 'L');
        morseToChar.put("--", 'M');
        morseToChar.put("-*", 'N');
        morseToChar.put("---", 'O');
        morseToChar.put("*--*", 'P');
        morseToChar.put("--*-", 'Q');
        morseToChar.put("*-*", 'R');
        morseToChar.put("***", 'S');
        morseToChar.put("-", 'T');
        morseToChar.put("**-", 'U');
        morseToChar.put("***-", 'V');
        morseToChar.put("*--", 'W');
        morseToChar.put("-**-", 'X');
        morseToChar.put("-*--", 'Y');
        morseToChar.put("--**", 'Z');
        morseToChar.put("*-*-*-", '.');
        morseToChar.put("--**--", ',');
        morseToChar.put("**--**", '?');


        for (String morse : morseToChar.keySet()) {
            charToMorse.put(morseToChar.get(morse), morse);
        }
    }

    public String toEnglish(String morseCode) {
        StringBuilder english = new StringBuilder();
        String[] words = morseCode.split(" ");

        for (String word : words) {
            if (morseToChar.containsKey(word)) {
                english.append(morseToChar.get(word));
            } else {
                english.append(' ');
            }
        }

        return english.toString();
    }

    public String toMorse(String englishText) {
        StringBuilder morse = new StringBuilder();
        char[] chars = englishText.toUpperCase().toCharArray();

        for (char c : chars) {
            if (charToMorse.containsKey(c)) {
                morse.append(charToMorse.get(c)).append(" ");
            } else if (c == ' ') {
                morse.append(" ");
            }
        }

        return morse.toString();
    }
}