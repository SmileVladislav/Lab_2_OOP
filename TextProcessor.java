public class TextProcessor {
    private String content;

    public TextProcessor(String content) {
        if (content == null || content.isEmpty()) {
            throw new IllegalArgumentException("Текст не може бути порожнім");
        }
        this.content = content;
    }

    public String process(char startChar, char endChar) {
        String[] sentences = content.split("(?<=[.!?])");
        StringBuilder result = new StringBuilder();

        for (String sentence : sentences) {
            int first = sentence.indexOf(startChar);
            int last = sentence.lastIndexOf(endChar);

            if (first != -1 && last != -1 && first < last) {
                String modified = sentence.substring(0, first) + sentence.substring(last + 1);
                result.append(modified);
            } else {
                result.append(sentence);
            }
        }
        return result.toString();
    }
}