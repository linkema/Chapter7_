package Chapter7_2.usermng.domain;

public class BorrowBook {
    private String b_name;
    private String bookno;

    public BorrowBook(){}
    public BorrowBook(String b_name, String bookno){
        this.b_name=b_name;
        this.bookno=bookno;
    }
    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }


    public String getBookno() {
        return bookno;
    }

    public void setBookno(String bookno) {
        this.bookno = bookno;
    }
}
