import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestMain {

    @Test
    void testStandard() {
        String input = "Аліса мила раму.";
        assertEquals("му.", Main.processText(input, 'А', 'а'));
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
        String input = "Мама мила. Тато мив.";
        String result = Main.processText(input, 'а', 'а');
        assertEquals("М. Тато мив.", result);
    }

    @Test
    void testPreserveFormatting() {
        String input = "Перше речення.\nДруге речення.";
        String result = Main.processText(input, 'x', 'y');
        assertEquals(input, result);
    }
}
