import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            String text = "Ми зустрілися наступного дня, як і було домовлено, і оглянули помешкання на Бейкер-стріт, номер двісті двадцять один б, про яке він говорив під час нашої першої зустрічі. Воно складалося з двох зручних спалень і однієї простої, але просторої вітальні, затишно вмебльованої і освітленої двома великими вікнами. Кімнати були чисті, світлі, а ціна, поділена на двох, виявилася настільки помірною, що ми того ж вечора домовилися про оренду і негайно перевезли свої речі. Холмс не був людиною, з якою важко жити під одним дахом; він мав тихі звички і регулярний розпорядок дня. Його енергія була неймовірною, коли на нього находив робочий запал, але час від часу він міг цілими днями лежати на канапі у вітальні, не вимовляючи ні слова і ледь ворушачись.";
            char startChar = 'а';
            char endChar = 'и';

            if (text == null || text.isEmpty()) {
                throw new IllegalArgumentException("Текст порожній");
            }

            System.out.println(processText(text, startChar, endChar));
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }

    public static String processText(String text, char start, char end) {
        String[] sentences = text.split("(?<=[.!?])\\s*");
        StringBuilder finalResult = new StringBuilder();

        for (String sentence : sentences) {
            int first = sentence.indexOf(start);
            int last = sentence.lastIndexOf(end);

            if (first != -1 && last != -1 && first < last) {
                String processed = sentence.substring(0, first) + sentence.substring(last + 1);
                finalResult.append(processed).append(" ");
            } else {
                finalResult.append(sentence).append(" ");
            }
        }
        return finalResult.toString().trim();
    }
}