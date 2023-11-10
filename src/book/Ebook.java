package book;

public class Ebook extends Book{
    private String fileFormat;

    public Ebook(String title, String author, String isbn, String fileFormat) {
        super(title, author, isbn);
        this.fileFormat = fileFormat;
    }

    @Override
    void getBookInfo(){
        super.getBookInfo();
        System.out.println(", Format: " + fileFormat);
    }

}
