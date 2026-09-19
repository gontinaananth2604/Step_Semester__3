class WeeklyLibraryMember {
    String memberId;
    int books;

    WeeklyLibraryMember(String memberId, int books) {
        this.memberId = memberId;
        this.books = books;
    }

    void displayInfo() {
        System.out.print("General | Books: " + books + " | ");
    }
}

class WeeklyStudentMember extends WeeklyLibraryMember {
    String course;

    WeeklyStudentMember(String memberId, int books, String course) {
        super(memberId, books);
        this.course = course;
    }

    @Override
    void displayInfo() {
        System.out.print("Student | Course: " + course + " | Books: " + books + " | ");
    }
}

public class WeeklyCirculationReport {

    static String batchPrint(WeeklyLibraryMember[] members) {
        StringBuilder report = new StringBuilder();

        for (WeeklyLibraryMember member : members) {

            // Polymorphic call
            member.displayInfo();

            // Downcast only after instanceof confirms the type
            if (member instanceof WeeklyStudentMember) {
                WeeklyStudentMember student = (WeeklyStudentMember) member;
                report.append("Course via downcast: ")
                      .append(student.course)
                      .append(" | ");
            }
        }

        return report.toString();
    }

    public static void main(String[] args) {
        WeeklyLibraryMember[] members = {
            new WeeklyLibraryMember("LB5", 0),
            new WeeklyStudentMember("STU6", 0, "ECE")
        };

        System.out.println(batchPrint(members));
    }
}