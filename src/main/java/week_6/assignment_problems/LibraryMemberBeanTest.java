package week_6.assignment_problems;

class LibraryMemberBean {
    private String membershipId = null;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;

    public LibraryMemberBean() {}

    public String getMembershipId() { return membershipId; }
    public void setMembershipId(String id) {
        if (this.membershipId == null) {
            this.membershipId = id;
        }
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isPremiumMember() { return premiumMember; }
    public void setPremiumMember(boolean premiumMember) { this.premiumMember = premiumMember; }

    public void setSecurityAnswer(String answer) {
        this.securityAnswer = String.valueOf(answer.hashCode()); 
    }
}

public class LibraryMemberBeanTest {
    public static void main(String[] args) {
        LibraryMemberBean m = new LibraryMemberBean();
        m.setMembershipId("LIB-8841");
        m.setName("Priya Nair");
        m.setPremiumMember(true);
        System.out.println(m.getMembershipId());
        
        m.setMembershipId("FAKE-0000");
        System.out.println(m.getMembershipId());
        
        System.out.println(m.isPremiumMember());
        m.setSecurityAnswer("BlueMountain");
        System.out.println("(no observable output — no method anywhere on the class can retrieve this value again)");
    }
}
