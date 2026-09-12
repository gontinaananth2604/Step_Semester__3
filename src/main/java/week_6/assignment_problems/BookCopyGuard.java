package week_6.assignment_problems;

class BookInventory {
    private int copiesTotal;
    private int copiesAvailable;

    public BookInventory(int copiesTotal) {
        this.copiesTotal = copiesTotal;
        this.copiesAvailable = copiesTotal;
    }

    public void checkOut() {
        if (copiesAvailable > 0) {
            copiesAvailable--;
        }
    }

    public void checkIn() {
        if (copiesAvailable < copiesTotal) {
            copiesAvailable++;
        }
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }
}

public class BookCopyGuard {
    public static void main(String[] args) {
        BookInventory b1 = new BookInventory(3);
        b1.checkOut(); b1.checkOut(); b1.checkOut();
        b1.checkOut(); // 4th attempt
        System.out.println(b1.getCopiesAvailable()); // 0

        b1.checkIn(); b1.checkIn(); b1.checkIn();
        b1.checkIn(); // 4th attempt
        System.out.println(b1.getCopiesAvailable()); // 3
    }
}
