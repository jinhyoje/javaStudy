package book;

public class Book {
     private String title;
     private String author;
     private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    void getBookInfo(){
        System.out.println("Title : " + title + ", Author : " + author + ", ISBN : " + isbn);
    }

}
