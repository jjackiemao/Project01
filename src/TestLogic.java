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
        String english = translator.toEnglish("**** * *-** *-** ---  *-- --- *-* *-** -**");
        assertEquals("HELLO WORLD", english);
    }

    @Test
    public void testInvalidMorseCharacter() {
        Logic translator = new Logic();
        String english = translator.toEnglish("***&* * *-** *-** ---  *-- --- *-* *-** -**");
        assertEquals("*** * HELLO WORLD", english);
    }



    @Test
    public void testInvalidInputToEnglish() {
        Logic translator = new Logic();
        String morse = translator.toEnglish("5#3#!#7");
        assertEquals("", morse); 
    }

    @Test
    public void testInvalidInputToMorse() {
        Logic translator = new Logic();
        String english = translator.toMorse("##%¤&¤@£$€");
        assertEquals("", english);
    }
}

