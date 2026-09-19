class NightAuditMember {
    private static int memberCounter = 100;

    public final String memberNumber;

    protected int borrowLimit;
    protected int booksBorrowed;

    public NightAuditMember(int borrowLimit) {
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;

        memberCounter++;
        this.memberNumber = "LIB-" + memberCounter;
    }

    void borrowBook() {
        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }

    void borrowBook(String genre) {
        borrowBook();
    }

    int getBooksBorrowed() {
        return booksBorrowed;
    }

    static boolean isValidRenewalCode(String code) {

        if (code == null || code.length() != 4) {
            return false;
        }

        if (code.charAt(0) != 'R') {
            return false;
        }

        if (!Character.isDigit(code.charAt(1))) {
            return false;
        }

        if (!Character.isDigit(code.charAt(2))) {
            return false;
        }

        if (!Character.isUpperCase(code.charAt(3))) {
            return false;
        }

        return true;
    }

    static int getMembersEnrolled() {
        return memberCounter - 100;
    }

    static String processNightlyAudit(NightAuditMember[] members) {

        int processed = 0;
        int nullSkipped = 0;
        int faculty = 0;
        int regular = 0;

        for (NightAuditMember member : members) {

            if (member == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (member instanceof NightFacultyMember) {
                faculty++;
            } else {
                regular++;
            }
        }

        return processed + " processed | "
                + nullSkipped + " null skipped | "
                + faculty + " faculty | "
                + regular + " regular";
    }
}


class NightFacultyMember extends NightAuditMember {

    private String department;

    public NightFacultyMember(int borrowLimit, String department) {
        super(borrowLimit);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}
