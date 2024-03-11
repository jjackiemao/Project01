import java.util.HashMap;

public class Logic {
    // HashMap to store Morse code to character mappings
    private final HashMap<String, Character> morseToChar;
    // HashMap to store character to Morse code mappings
    private final HashMap<Character, String> charToMorse;

    // Constructor
    public Logic() {
        // Initialize HashMaps
        morseToChar = new HashMap<>();
        charToMorse = new HashMap<>();
        // Populate the mappings
        populateMaps();
    }

    // Populate the HashMaps with Morse code mappings
    private void populateMaps() {
        // Morse code to alphabet character mappings
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

        // Populate the charToMorse HashMap by reversing the morseToChar HashMap
        for (String morse : morseToChar.keySet()) {
            charToMorse.put(morseToChar.get(morse), morse);
        }
    }

    // Convert Morse code to English
    public String toEnglish(String morseCode) {
        StringBuilder english = new StringBuilder();
        // Split Morse code into words
        String[] words = morseCode.split(" ");

        // Translate each Morse code word to a character
        for (String word : words) {
            if (morseToChar.containsKey(word)) {
                english.append(morseToChar.get(word));
            } else {
                // If Morse code not found, throw an exception
                throw new IllegalArgumentException("Invalid Morse code input: " + morseCode);
            }
        }

        return english.toString();
    }

    // Convert English text to Morse code
    public String toMorse(String englishText) {
        StringBuilder morse = new StringBuilder();
        // Convert text to uppercase
        char[] chars = englishText.toUpperCase().toCharArray();

        // Translate each character to Morse code
        for (char c : chars) {
            if (charToMorse.containsKey(c)) {
                morse.append(charToMorse.get(c)).append(" ");
            } else if (c == ' ') {
                // If character is a space, append a space
                morse.append(" ");
            } else {
                // If character is not in the mapping, append an empty string and print a warning
                System.out.println("Warning: Character '" + c + "' cannot be translated to Morse code.");
            }
        }

        return morse.toString();
    }
}
