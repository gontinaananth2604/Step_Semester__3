package week_2.class_problems;

public class VowelConsonantCounter {
    public static void countVowelsAndConsonants(String text) {
        int vowels = 0, consonants = 0;
        text = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'a' && c <= 'z') {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vowels++;
                else consonants++;
            }
        }
        System.out.printf("Vowels: %d | Consonants: %d\n", vowels, consonants);
    }
    public static void main(String[] args) {
        countVowelsAndConsonants("Java Programming");
    }
}
