package week_4.class_problems;

class LibraryBook {
    String title;
    String isbn;
    String status;

    public LibraryBook(String title, String isbn) {
        this.title = title;
        if (isbn == null || isbn.isEmpty()) {
            this.status = "PENDING";
            this.isbn = "";
        } else {
            this.isbn = isbn;
            this.status = "Catalogued: true";
        }
    }

    public LibraryBook(String title) {
        this(title, "");
    }

    public void printStatus() {
        if (this.status.equals("PENDING")) {
            System.out.println(title + " | PENDING | Catalogued: true");
        } else {
            System.out.println(title + " | " + isbn + " | Catalogued: true");
        }
    }
}

public class LibraryBookCataloguing {
    public static void main(String[] args) {
        String[] titles = {"Clean Code", "Untitled Draft", "1984", "Notes"};
        String[] isbns = {"978-0132350884", "", "9780451524935", ""};

        for (int i = 0; i < titles.length; i++) {
            LibraryBook book;
            if (isbns[i].isEmpty()) {
                book = new LibraryBook(titles[i]);
            } else {
                book = new LibraryBook(titles[i], isbns[i]);
            }
            book.printStatus();
        }
    }
}
