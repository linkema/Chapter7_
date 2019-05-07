package Chapter7_2.usermng.domain;

public class Book {
    private String bookNo;
    private String bookName;
    private String author;
    private String price;
    private String note;
    public Book(){}
    public Book(String bookid,String bookname,String price,String author,String note){
        bookNo=bookid;
        bookName=bookname;
        this.price=price;
        this.author=author;
        this.note=note;
    }
    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
