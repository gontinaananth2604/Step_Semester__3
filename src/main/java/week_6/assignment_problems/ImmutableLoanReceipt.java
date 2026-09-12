package week_6.assignment_problems;

import java.util.Arrays;

class LoanReceipt {
    protected final String memberId;
    protected final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        this.bookIds = bookIds != null ? Arrays.copyOf(bookIds, bookIds.length) : new String[0];
    }

    public String[] getBookIds() {
        return Arrays.copyOf(bookIds, bookIds.length);
    }

    public LoanReceipt withCorrectedBookId(int index, String newId) {
        String[] newIds = getBookIds();
        newIds[index] = newId;
        return new LoanReceipt(this.memberId, newIds);
    }
}

class ReferenceOnlyLoanReceipt extends LoanReceipt {
    private final String roomNumber;
    public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
        super(memberId, bookIds);
        this.roomNumber = roomNumber;
    }
}

class CirculationLedger {
    static String branchCode;
    static {
        branchCode = "BR-001";
    }

    public static String processNightlyCirculation(LoanReceipt[] receipts) {
        int processed = 0, nullSkipped = 0, ref = 0, regular = 0;
        for (LoanReceipt r : receipts) {
            if (r == null) {
                nullSkipped++;
            } else {
                processed++;
                if (r instanceof ReferenceOnlyLoanReceipt) ref++;
                else regular++;
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + ref + " reference-only | " + regular + " regular";
    }
}

public class ImmutableLoanReceipt {
    public static void main(String[] args) {
        LoanReceipt r = new LoanReceipt("LIB-8841", new String[]{"BK-100", "BK-101"});
        String[] ids = r.getBookIds();
        ids[0] = "HACKED";
        System.out.println(r.getBookIds()[0]); // "BK-100"

        LoanReceipt corrected = r.withCorrectedBookId(1, "BK-102");
        System.out.println(Arrays.toString(r.getBookIds()));
        System.out.println(Arrays.toString(corrected.getBookIds()));

        LoanReceipt[] batch = {
            new ReferenceOnlyLoanReceipt("LIB-001", new String[]{"BK-200"}, "Reading Room 3"),
            null,
            new LoanReceipt("LIB-002", new String[]{"BK-201"})
        };
        System.out.println(CirculationLedger.processNightlyCirculation(batch));
    }
}
