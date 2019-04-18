package Chapter7_2.usermng.dao;

import Chapter7_2.usermng.domain.Book;
import Chapter7_2.usermng.domain.User;

public interface GMUserDao extends UserDao{
    public void deleteUser(User form);
    public void addBook(Book form);
    public void deleteBook(Book form);
    public void modifyBook(Book form);
    public void searchBook(Book form);
    public Book findByBookname(String bookname);
}
