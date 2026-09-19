class LibraryMember {
    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed;

    public LibraryMember(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().isEmpty()
                || memberId.length() < 4) {
            throw new IllegalArgumentException("Invalid member ID");
        }

        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
    }

    public void borrowBook() {
        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public void displayInfo() {
        System.out.println("General Member | Books Borrowed: "
                + booksBorrowed);
    }
}

class StudentMember extends LibraryMember {
    private String course;

    public StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    @Override
    public void displayInfo() {
        System.out.println("Student Member | Course: "
                + course + " | Books Borrowed: "
                + booksBorrowed);
    }

    protected String getCourse() {
        return course;
    }
}

class HonorsStudentMember extends StudentMember {
    private int bonusLimit;

    public HonorsStudentMember(String memberId, int borrowLimit,
                               String course, int bonusLimit) {
        super(memberId, borrowLimit, course);
        this.bonusLimit = bonusLimit;
    }

    @Override
    public void borrowBook() {
        if (booksBorrowed < borrowLimit + bonusLimit) {
            booksBorrowed++;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Honors Student Member | Course: "
                + getCourse()
                + " | Bonus Limit: " + bonusLimit
                + " | Books Borrowed: " + booksBorrowed);
    }
}

class FacultyMember extends LibraryMember {
    private String department;

    public FacultyMember(String memberId, int borrowLimit,
                         String department) {
        super(memberId, borrowLimit);
        this.department = department;
    }

    @Override
    public void displayInfo() {
        System.out.println("Faculty Member | Department: "
                + department
                + " | Books Borrowed: "
                + booksBorrowed);
    }
}

public class MembershipValidator {

    public static String classifyGeneration(LibraryMember member) {

        if (member instanceof HonorsStudentMember) {
            return "Multilevel descendant (3 generations deep)";
        } else if (member instanceof FacultyMember) {
            return "Hierarchical sibling (independent branch)";
        } else if (member instanceof StudentMember) {
            return "Student branch (2 generations deep)";
        } else {
            return "General Member";
        }
    }

    public static int getTotalBooksBorrowed(LibraryMember[] members) {
        int total = 0;

        for (LibraryMember member : members) {
            total += member.getBooksBorrowed();
        }

        return total;
    }
}