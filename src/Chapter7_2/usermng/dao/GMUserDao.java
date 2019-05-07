package Chapter7_2.usermng.dao;

import Chapter7_2.usermng.domain.Book;
import Chapter7_2.usermng.domain.User;

import java.util.ArrayList;

public interface GMUserDao extends UserDao{
    public void deleteUser(User form);
    public void addBook(Book form);
    public void deleteBook(String bookid);
    public Book modifyBook(Book form);
    public ArrayList<User> showAllUser();
}
