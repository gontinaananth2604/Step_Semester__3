package week_2.assignment_problems;

public class ISBNValidator {
    public static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed;
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }
    public static String validateAndFormat(String code) {
        if (code.length() != 13) return "Invalid: wrong length";
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) return "Invalid: publisher code must be 3 letters";
        }
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) return "Invalid: remaining characters must be digits";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(code.substring(0, 3)).append("] YEAR: ");
        sb.append("20").append(code.substring(3, 5)).append(" | CATALOG: "); // Output shows YEAR: 2026, let's use 20XX format assumption or just substring
        sb.append(code.substring(7));
        // Actually sample output shows 2026 for year part 2026. Wait.
        // Code is 13 chars: 3 letters + 4 digits(year) + 6 digits(catalog).
        // 3 + 4 + 6 = 13.
        return "[" + code.substring(0, 3) + "] YEAR: " + code.substring(3, 7) + " | CATALOG: " + code.substring(7);
    }
    public static void main(String[] args) {
        String raw1 = " pen2026004251 ";
        System.out.println(validateAndFormat(normalizeCode(raw1)));
        
        String raw2 = "12N2026004251";
        System.out.println(validateAndFormat(normalizeCode(raw2)));
    }
}
