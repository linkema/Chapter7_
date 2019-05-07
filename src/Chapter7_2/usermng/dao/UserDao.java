package Chapter7_2.usermng.dao;

import Chapter7_2.usermng.domain.Book;
import Chapter7_2.usermng.domain.BorrowBook;
import Chapter7_2.usermng.domain.User;

import java.util.ArrayList;

/**
 * UserDao接口
 * @author mlk
 *
 */
public interface UserDao {
	public void addUser(User form);
    public User findByUsername(String username);
    //public void search(User form);
    public Book findByBookname(String bookid);
    public int borrowBook(BorrowBook form);
    public void backBook(BorrowBook form);
    public ArrayList<Book> showAllBook();
    public ArrayList<BorrowBook> showAllBorrowedBook();
}
