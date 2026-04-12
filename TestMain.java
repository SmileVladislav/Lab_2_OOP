import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestMain {
    @Test
    void testProcessing() {
        TextProcessor processor = new TextProcessor("Аліса мила раму.");
        String result = processor.process('А', 'а');
        assertEquals("му.", result);
    }

    @Test
    void testNoMatch() {
        TextProcessor processor = new TextProcessor("Текст без збігів.");
        String result = processor.process('z', 'x');
        assertEquals("Текст без збігів.", result);
    }
}
