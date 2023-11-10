package book;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "1234567890");
        book.getBookInfo();

        Ebook ebook = new Ebook("The Great Gatsby", "F. Scott Fitzgerald", "1234567890", "PDF");
        ebook.getBookInfo();
    }
}
