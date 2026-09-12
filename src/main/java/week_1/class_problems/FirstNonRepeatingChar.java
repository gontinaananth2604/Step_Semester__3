package week_1.class_problems;

public class FirstNonRepeatingChar {
    public static char findFirstNonRepeatingChar(String text) {
        int[] freq = new int[256];
        for (char c : text.toCharArray()) {
            freq[c]++;
        }
        for (char c : text.toCharArray()) {
            if (freq[c] == 1) return c;
        }
        return '\0'; // Return null character if none found
    }

    public static void main(String[] args) {
        String[] tests = {"swiss", "aabbcc"};
        for (String t : tests) {
            char res = findFirstNonRepeatingChar(t);
            if (res != '\0') {
                System.out.println("First Non-Repeating Character: '" + res + "'");
            } else {
                System.out.println("No Non-Repeating Character Found");
            }
        }
    }
}
