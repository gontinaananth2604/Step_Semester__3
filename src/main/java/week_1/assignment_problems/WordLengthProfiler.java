package week_1.assignment_problems;

public class WordLengthProfiler {
    public static void classifyWordLengths(String review) {
        String[] words = review.split("\\s+");
        int shortCount = 0, mediumCount = 0, longCount = 0;
        for (String word : words) {
            int len = word.length();
            if (len >= 1 && len <= 4) shortCount++;
            else if (len >= 5 && len <= 8) mediumCount++;
            else if (len >= 9) longCount++;
        }
        System.out.printf("Short: %d | Medium: %d | Long: %d\n", shortCount, mediumCount, longCount);
    }

    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}
