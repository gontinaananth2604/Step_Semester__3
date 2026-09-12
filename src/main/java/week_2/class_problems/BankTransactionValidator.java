package week_2.class_problems;

public class BankTransactionValidator {
    public static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed;
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }
    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) return "Invalid: reference must be 14 characters";
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) return "Invalid: bank code must be 3 letters";
        }
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) return "Invalid: remaining 11 characters must be digits";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(reference.substring(0, 3)).append("] DATE: ");
        sb.append(reference.substring(3, 5)).append("/").append(reference.substring(5, 7)).append("/").append(reference.substring(7, 9));
        sb.append(" | SEQ: ").append(reference.substring(9));
        return sb.toString();
    }
    public static void main(String[] args) {
        String raw1 = " hdf03022600042 ";
        String normalized1 = normalizeReference(raw1);
        System.out.println(validateAndFormat(normalized1));
        
        String raw2 = "12F03022600042";
        String normalized2 = normalizeReference(raw2);
        System.out.println(validateAndFormat(normalized2));
    }
}
