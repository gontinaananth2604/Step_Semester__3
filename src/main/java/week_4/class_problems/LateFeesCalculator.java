package week_4.class_problems;

class Account {
    String regNo;
    double totalFee;

    public Account(String regNo, double totalFee) {
        this.regNo = regNo;
        this.totalFee = totalFee;
    }

    public final double calculateLateFee(int daysLate) {
        if (daysLate <= 0) return 0;
        return daysLate * 2000.0; // Assuming Rs 2000 per late day based on the sample output (10 days -> 20000)
    }

    public final void printSummary(int daysLate) {
        if (daysLate <= 0) {
            System.out.println(regNo + " - On time, no late fee");
        } else {
            double lateFee = calculateLateFee(daysLate);
            System.out.println(regNo + " | Total Fee: Rs " + totalFee + " | Late Fee: Rs " + lateFee);
        }
    }
}

public class LateFeesCalculator {
    public static void main(String[] args) {
        String[] regNos = {"RA001", "RA002", "RA003", "RA004"};
        double[] totalFees = {200000, 150000, 180000, 220000};
        int[] daysLate = {10, 0, -2, 5};

        for (int i = 0; i < regNos.length; i++) {
            Account acc = new Account(regNos[i], totalFees[i]);
            acc.printSummary(daysLate[i]);
        }
    }
}
