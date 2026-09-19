class GymMember {
    private String memberId;
    private int monthlyFee;
    private int sessionsAttended;

    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.length() < 4) {
            throw new IllegalArgumentException("Invalid member ID");
        }

        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        this.sessionsAttended = 0;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    public void displayInfo() {
        System.out.println("Standard Member | Sessions: " + sessionsAttended);
    }

    public static String signUpBatch(String[] memberIds, int monthlyFee) {
        int signedUp = 0;
        int rejected = 0;

        for (String id : memberIds) {
            try {
                new GymMember(id, monthlyFee);
                signedUp++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Signed Up: " + signedUp + " | Rejected: " + rejected;
    }
}


class PremiumMember extends GymMember {
    private String trainerName;

    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    public void displayInfo() {
        System.out.println(
            "Premium Member | Trainer: " + trainerName +
            " | Sessions: " + getSessionsAttended()
        );
    }
}


class EliteMember extends PremiumMember {
    private String lockerNumber;

    public EliteMember(String memberId, int monthlyFee,
                       String trainerName, String lockerNumber) {
        super(memberId, monthlyFee, trainerName);
        this.lockerNumber = lockerNumber;
    }

    @Override
    public void displayInfo() {
        System.out.println(
            "Elite Member | Trainer: " + getTrainerName() +
            " | Locker: " + lockerNumber +
            " | Sessions: " + getSessionsAttended()
        );
    }

    public String getTrainerName() {
        return trainerNameValue();
    }

    private String trainerNameValue() {
        return getTrainerFromParent();
    }

    private String getTrainerFromParent() {
        return super.getTrainerName();
    }
}


class GroupClassMember extends GymMember {
    private String className;

    public GroupClassMember(String memberId, int monthlyFee,
                            String className) {
        super(memberId, monthlyFee);
        this.className = className;
    }

    @Override
    public void displayInfo() {
        System.out.println(
            "Group Class Member | Class: " + className +
            " | Sessions: " + getSessionsAttended()
        );
    }
}


public class GymMembershipDemo {

    public static String classifyGeneration(GymMember member) {
        if (member instanceof EliteMember) {
            return "Multilevel descendant (3 generations deep)";
        } else if (member instanceof GroupClassMember) {
            return "Hierarchical sibling (independent branch)";
        } else if (member instanceof PremiumMember) {
            return "Premium descendant";
        } else {
            return "Standard Member";
        }
    }

    public static int getTotalSessionsAttended(GymMember[] members) {
        int total = 0;

        for (GymMember member : members) {
            total += member.getSessionsAttended();
        }

        return total;
    }

    public static void main(String[] args) {

        GymMember standardMember =
            new GymMember("MEM1", 1000);

        PremiumMember premiumMember =
            new PremiumMember("MEM2", 2000, "Coach Riya");

        EliteMember eliteMember =
            new EliteMember("MEM3", 3000, "Coach Arjun", "L12");

        GroupClassMember groupClassMember =
            new GroupClassMember("MEM4", 1500, "Zumba");

        // Display information
        standardMember.displayInfo();
        premiumMember.displayInfo();
        eliteMember.displayInfo();
        groupClassMember.displayInfo();

        // Attend sessions
        premiumMember.attendSession();
        premiumMember.attendSession();
        premiumMember.attendSession();

        eliteMember.attendSession();
        eliteMember.attendSession();

        groupClassMember.attendSession();
        groupClassMember.attendSession();
        groupClassMember.attendSession();
        groupClassMember.attendSession();

        // Classification
        System.out.println(
            classifyGeneration(eliteMember)
        );

        System.out.println(
            classifyGeneration(groupClassMember)
        );

        // Total sessions
        GymMember[] members = {
            premiumMember,
            eliteMember,
            groupClassMember
        };

        System.out.println(
            getTotalSessionsAttended(members)
        );
    }
}