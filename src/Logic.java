import java.util.HashMap;

public class Logic {

    // HashMap to store mappings from Morse code to characters
    private final HashMap<String, Character> morseToChar;

    // HashMap to store mappings from characters to Morse code
    private final HashMap<Character, String> charToMorse;

    // Constructor: initializes HashMaps and populates them with mappings
    public Logic() {
        morseToChar = new HashMap<>();
        charToMorse = new HashMap<>();
        populateMaps();
    }

    // Populate the HashMaps with predefined Morse code and character mappings
    private void populateMaps() {
        // Populate morseToChar HashMap
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
        morseToChar.put("-----", '0');
        morseToChar.put("*----", '1');
        morseToChar.put("**---", '2');
        morseToChar.put("***--", '3');
        morseToChar.put("****-", '4');
        morseToChar.put("*****", '5');
        morseToChar.put("-****", '6');
        morseToChar.put("--***", '7');
        morseToChar.put("---**", '8');
        morseToChar.put("----*", '9');

        // Populate charToMorse HashMap by reversing morseToChar
        for (String morse : morseToChar.keySet()) {
            charToMorse.put(morseToChar.get(morse), morse);
        }
    }

    // Translate Morse code to English text
    public String toEnglish(String morseCode) {
        StringBuilder english = new StringBuilder();
        String[] words = morseCode.split(" ");

        for (String word : words) {
            if (morseToChar.containsKey(word)) {
                english.append(morseToChar.get(word));
            } else if (word.isEmpty()) {
                english.append(' '); // Append a space if the word is empty
            } else {
                // If Morse code input is invalid, print an error message and return an empty string
                System.out.println("Invalid Morse code input: " + morseCode);
                return ""; // Return empty string to signify error
            }
        }

        return english.toString();
    }

    // Translate English text to Morse code
    public String toMorse(String englishText) {
        StringBuilder morse = new StringBuilder();
        char[] chars = englishText.toUpperCase().toCharArray();

        for (char c : chars) {
            if (charToMorse.containsKey(c)) {
                morse.append(charToMorse.get(c)).append(" ");
            } else if (c == ' ') {
                morse.append(" "); // Append a space for space character
            } else {
                // If character input is invalid, print an error message and return an empty string
                System.out.println("Invalid character input: " + c);
                return ""; // Return empty string to signify error
            }
        }

        return morse.toString();
    }
}
