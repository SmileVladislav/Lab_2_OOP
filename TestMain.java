import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestMain {
    @Test
    void testStandard() {
        String input = "Аліса мила раму.";
        assertEquals(" му.", Main.processText(input, 'А', 'а'));
    }

    @Test
    void testNoMatch() {
        String input = "Текст без збігів.";
        assertEquals("Текст без збігів.", Main.processText(input, 'z', 'x'));
    }

    @Test
    void testEmpty() {
        assertEquals("", Main.processText("", 'a', 'b'));
    }

    @Test
    void testMultipleSentences() {
        String input = "Перше речення. Друге речення.";
        String result = Main.processText(input, 'е', 'е');
        assertNotEquals(input, result);
    }
}