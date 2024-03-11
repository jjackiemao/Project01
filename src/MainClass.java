import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        // Create an instance of the Logic class for translation
        Logic translator = new Logic();
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Print a welcome message
        System.out.println("Initiating the Morse Code Translator!");

        // Infinite loop to keep prompting the user until a valid option is selected
        while (true) {
            // Prompt the user to select the translation mode
            System.out.println("Please enter '1' for English to Morse code or '2' for Morse code to English:");
            try {
                // Read user input and trim leading/trailing spaces
                String input = scanner.nextLine().trim();

                // Checks if the input is empty, if empty prints a warning
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty. Please enter a valid option.");
                    continue; // Continue to next iteration of the loop
                }

                // Converts the input to an integer
                int option = Integer.parseInt(input);

                // Perform actions based on the selected option
                if (option == 1) {
                    // Translates English text to Morse code
                    System.out.println("Enter text:");
                    String englishText = scanner.nextLine();
                    String morseCode = translator.toMorse(englishText);
                    System.out.println("Translation: " + morseCode);
                    break; // Exit loop after successful translation

                } else if (option == 2) {
                    // Translates Morse code to English text
                    System.out.println("Enter code (use '*' for dot and '-' for dash):");
                    String morseCode = scanner.nextLine();
                    String englishText = translator.toEnglish(morseCode);
                    System.out.println("Translation: " + englishText);
                    break; // Exit loop after successful translation

                } else {
                    // Display error message for invalid option
                    System.out.println("Invalid option. Please enter '1' or '2'.");
                }
            } catch (NumberFormatException e) {
                // Handle non-numeric input
                System.out.println("Invalid input. Please enter a numeric option.");

            } catch (IllegalArgumentException e) {
                // Handle exceptions from Logic class (ex. invalid Morse code)
                System.out.println(e.getMessage());
            }
        }

        // Closing the scanner
        scanner.close();
    }
}
