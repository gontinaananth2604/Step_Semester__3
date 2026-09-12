package week_1.class_problems;

public class PalindromeChecker {
    public static boolean isPalindromeIterative(String text) {
        text = text.toLowerCase();
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) return false;
            left++; right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        text = text.toLowerCase();
        if (text.length() <= 1) return true;
        if (text.charAt(0) != text.charAt(text.length() - 1)) return false;
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        text = text.toLowerCase();
        char[] arr = text.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
        return text.equals(new String(arr));
    }

    public static void main(String[] args) {
        String[] tests = {"madam", "hello"};
        for (String t : tests) {
            System.out.printf("\"%s\"\nIterative: %s | Recursive: %s | Array Reversal: %s\n\n",
                t,
                isPalindromeIterative(t) ? "Palindrome" : "Not Palindrome",
                isPalindromeRecursive(t) ? "Palindrome" : "Not Palindrome",
                isPalindromeArrayReversal(t) ? "Palindrome" : "Not Palindrome");
        }
    }
}
