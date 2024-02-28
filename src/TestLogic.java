import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestLogic {

    @Test
    public void testEnglishToMorse() {
        Logic translator = new Logic();
        String morse = translator.toMorse("HELLO WORLD");
        assertEquals("**** * *-** *-** ---  *-- --- *-* *-** -** ", morse);
    }

    @Test
    public void testMorseToEnglish() {
        Logic translator = new Logic();
        String english = translator.toEnglish("**** * *-** *-** ---  *-- --- *-* *-** -** ");
        assertEquals("HELLO WORLD", english);
    }

    @Test
    public void testInvalidMorseCharacter() {
        Logic translator = new Logic();
        String english = translator.toEnglish("**** * *-** *-** ---  *-- --- *-* *-** -**"); // Includes invalid character
        assertEquals("HELLO WORLD", english); // Invalid character should be preserved
    }
}
