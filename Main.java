/**
 * Клас для обробки тексту: видалення підрядка між першим та останнім заданими символами.
 * @author SmileVladislav
 */
public class Main {
    /**
     * Головний метод, де ми перевіряємо логіку на уривку з "Шерлока Холмса".
     */
    public static void main(String[] args) {
        try {
            String text = "Ми зустрілися наступного дня, як і було домовлено.\n" +
                    "Воно складалося з двох зручних спалень і вітальні.";

            char startChar = 'а';
            char endChar = 'и';

            if (text == null || text.isEmpty()) {
                throw new IllegalArgumentException("Текст не може бути порожнім");
            }

            System.out.println("Результат обробки тексту");
            System.out.println(processText(text, startChar, endChar));

        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }

    /**
     * Розбиває текст на речення, зберігаючи оригінальні роздільники (пробіли, переноси).
     * * @param text вхідний текст
     * @param start початковий символ для видалення
     * @param end кінцевий символ для видалення
     * @return оброблений текст із збереженим форматуванням
     */
    public static String processText(String text, char start, char end) {
        String[] sentences = text.split("(?<=[.!?])");
        StringBuilder finalResult = new StringBuilder();

        for (String sentence : sentences) {
            int first = sentence.indexOf(start);
            int last = sentence.lastIndexOf(end);

            if (first != -1 && last != -1 && first < last) {
                String processed = sentence.substring(0, first) + sentence.substring(last + 1);
                finalResult.append(processed);
            } else {
                finalResult.append(sentence);
            }
        }
        return finalResult.toString();
    }
}
