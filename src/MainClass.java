import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Logic translator = new Logic();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Initiating the Morse Code Translator!");
        System.out.println("Please enter '1' for English to Morse code or '2' for Morse code to English:");

        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (option == 1) {
            System.out.println("Enter text:");
            String englishText = scanner.nextLine();
            String morseCode = translator.toMorse(englishText);
            System.out.println("Translation: " + morseCode);
        } else if (option == 2) {
            System.out.println("Enter code (use '*' for dot and '-' for dash):");
            String morseCode = scanner.nextLine();
            String englishText = translator.toEnglish(morseCode);
            System.out.println("Translation: " + englishText);
        } else {
            System.out.println("Invalid option. Please enter '1' or '2'.");
        }

        scanner.close();
    }
}