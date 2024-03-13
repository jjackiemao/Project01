import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Logic translator = new Logic();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Initiating the Morse Code Translator!");

        while (true) {
            System.out.println("Please enter '1' for English to Morse code or '2' for Morse code to English:");
            try {
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty. Please enter a valid option.");
                    continue; 
                }

                int option = Integer.parseInt(input);

                if (option == 1) {
                    System.out.println("Enter text:");
                    String englishText = scanner.nextLine();
                    String morseCode = translator.toMorse(englishText);
                    System.out.println("Translation: " + morseCode);
                    break; 

                } else if (option == 2) {
                    System.out.println("Enter code (use '*' for dot and '-' for dash):");
                    String morseCode = scanner.nextLine();
                    String englishText = translator.toEnglish(morseCode);
                    System.out.println("Translation: " + englishText);
                    break;

                } else {
                    System.out.println("Invalid option. Please enter '1' or '2'.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric option.");

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }
}
