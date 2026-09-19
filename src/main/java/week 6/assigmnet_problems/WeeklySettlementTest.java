class GymMember {

    private static int memberCounter = 2000;

    private final String membershipNumber;

    private int monthlyFee;
    private int feesPaid;
    private String paymentMode;

    public GymMember(int monthlyFee) {

        // Increment counter once for every object
        memberCounter++;

        // Final field assigned only once
        membershipNumber = "GYM-" + memberCounter;

        this.monthlyFee = monthlyFee;
        this.feesPaid = 0;
    }

    public void payFee(int amount) {
        feesPaid += amount;
    }

    public void payFee(int amount, String mode) {
        // Record payment mode
        this.paymentMode = mode;

        // Reuse the one-argument method
        payFee(amount);
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public static boolean isValidReferralCode(String code) {

        // Must be exactly 4 characters
        if (code == null || code.length() != 4) {
            return false;
        }

        // First character must be G
        if (code.charAt(0) != 'G') {
            return false;
        }

        // Second and third characters must be digits
        if (!Character.isDigit(code.charAt(1))) {
            return false;
        }

        if (!Character.isDigit(code.charAt(2))) {
            return false;
        }

        // Fourth character must be uppercase
        if (!Character.isUpperCase(code.charAt(3))) {
            return false;
        }

        return true;
    }

    public static int getMembersEnrolled() {
        return memberCounter - 2000;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }
}


class GroupClassMember extends GymMember {

    private String className;

    public GroupClassMember(int monthlyFee, String className) {
        super(monthlyFee);
        this.className = className;
    }
}


public class WeeklySettlementTest {

    public static String processWeeklyCheckIn(GymMember[] members) {

        int processed = 0;
        int nullSkipped = 0;
        int groupCount = 0;
        int individualCount = 0;

        for (GymMember member : members) {

            // Safely handle null entries
            if (member == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            // Separate GroupClassMember from regular GymMember
            if (member instanceof GroupClassMember) {
                groupCount++;
            } else {
                individualCount++;
            }
        }

        return processed + " processed | "
                + nullSkipped + " null skipped | "
                + groupCount + " group | "
                + individualCount + " individual";
    }


    public static void main(String[] args) {

        // Membership number example
        GymMember m1 = new GymMember(1000);

        System.out.println(m1.getMembershipNumber());
        System.out.println(GymMember.getMembersEnrolled());


        // Referral code examples
        System.out.println(GymMember.isValidReferralCode("G45B"));
        System.out.println(GymMember.isValidReferralCode("G4B"));
        System.out.println(GymMember.isValidReferralCode("X45B"));


        // Payment examples
        m1.payFee(500);
        m1.payFee(500, "UPI");

        System.out.println(m1.getFeesPaid());


        // Weekly check-in example
        GymMember[] members = {
            new GroupClassMember(1500, "Zumba"),
            null,
            new GymMember(1000)
        };

        System.out.println(
            processWeeklyCheckIn(members)
        );
    }
}