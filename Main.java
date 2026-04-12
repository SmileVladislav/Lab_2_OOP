public class Main {
    public static void main(String[] args) {
        try {
            String input = "Ми зустрілися наступного дня, як і було домовлено.\n" +
                    "Воно складалося з двох зручних спалень і вітальні.";

            TextProcessor processor = new TextProcessor(input);
            String result = processor.process('а', 'и');

            System.out.println(result);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
