package week_6.assignment_problems;

class LibraryMember {
    private String membershipPin;
    String branchCode;
    protected double finesOwed;
    public String displayName;
}

public class MembershipFieldReach {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier.equals("public")) return "ALLOWED";
        if (fieldModifier.equals("private")) {
            return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
        }
        if (fieldModifier.equals("default")) {
            return (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")) ? "ALLOWED" : "DENIED";
        }
        if (fieldModifier.equals("protected")) {
            return (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")) ? "ALLOWED" : "DENIED";
        }
        return "DENIED";
    }

    public static String summarizeByModifier(String[][] attempts) {
        int[] allowed = new int[4];
        int[] denied = new int[4];
        String[] mods = {"private", "default", "protected", "public"};

        for (String[] attempt : attempts) {
            int idx = -1;
            for (int i = 0; i < 4; i++) {
                if (mods[i].equals(attempt[0])) idx = i;
            }
            if (idx != -1) {
                if (classifyAccess(attempt[0], attempt[1]).equals("ALLOWED")) allowed[idx]++;
                else denied[idx]++;
            }
        }
        return "private: " + allowed[0] + " allowed / " + denied[0] + " denied | " +
               "default: " + allowed[1] + " allowed / " + denied[1] + " denied | " +
               "protected: " + allowed[2] + " allowed / " + denied[2] + " denied | " +
               "public: " + allowed[3] + " allowed / " + denied[3] + " denied";
    }

    public static void main(String[] args) {
        System.out.println(classifyAccess("private", "SAME_CLASS"));
        System.out.println(classifyAccess("protected", "DIFFERENT_PACKAGE"));
        String[][] attempts = {
            {"private","SAME_CLASS"}, {"private","SAME_PACKAGE"},
            {"default","SAME_PACKAGE"}, {"default","DIFFERENT_PACKAGE"},
            {"protected","SAME_PACKAGE"}, {"protected","SAME_CLASS"},
            {"public","DIFFERENT_PACKAGE"}
        };
        System.out.println(summarizeByModifier(attempts));
    }
}
