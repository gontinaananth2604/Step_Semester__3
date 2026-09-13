package week_5.class_problems;

public class MovieBookingProfileBean {
    private String name;
    private boolean confirmed;
    private String otp;

    public MovieBookingProfileBean() {
    }

    public MovieBookingProfileBean(String name) {
        this();
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isConfirmed() { return confirmed; }
    public void setConfirmed(boolean confirmed) { this.confirmed = confirmed; }

    public void setOtp(String otp) { this.otp = otp; }
    // No matching getter exists anywhere

    public static void main(String[] args) {
        System.out.println(new MovieBookingProfileBean("Rahul Dev").getName());
        
        MovieBookingProfileBean p = new MovieBookingProfileBean("Rahul Dev");
        p.setConfirmed(true);
        System.out.println(p.isConfirmed());
        
        p.setOtp("4471");
        System.out.println("(no observable output — no method anywhere on the class can retrieve this value again)");
    }
}
