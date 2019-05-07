package Chapter7_2.usermng.service;

import Chapter7_2.usermng.dao.DaoFactory;
import Chapter7_2.usermng.dao.GMUserDao;
import Chapter7_2.usermng.domain.Book;
import Chapter7_2.usermng.domain.User;

import java.util.ArrayList;

public class GmUserService {
    private GMUserDao gmUserDao = DaoFactory.getGMDao();

    public User login(User form) throws UserException {
        User user = gmUserDao.findByUsername(form.getUsername());
        if (!user.getPassword().equals(form.getPassword())) {
            throw new UserException("密码错误！");
        }
        return user;
    }

    public void deleteUser(String username) throws UserException {
        User user = gmUserDao.findByUsername((username));
        gmUserDao.deleteUser(user);
    }

    public void addBook(Book form) throws UserException {
        /*
         * 2. 插入书籍对象
         */
        gmUserDao.addBook(form);
    }

    public void deleteBook(String bookid) throws UserException {
        Book book = gmUserDao.findByBookname(bookid);
        if (book == null) throw new UserException("该书不存在！");
        /*
            2.删除书籍
         */
        gmUserDao.deleteBook(bookid);
    }

    public ArrayList<User> showAllUser() throws UserException {
        ArrayList<User> list1 = gmUserDao.showAllUser();
        if (list1 == null) throw new UserException("页面显示错误！");
        return list1;
    }

    public void modifyBook(Book form) throws UserException {
        gmUserDao.modifyBook(form);
    }

    public ArrayList<Book> showAllBook() throws UserException {
        ArrayList<Book> list2 = gmUserDao.showAllBook();
        if (list2 == null) throw new
                UserException("页面显示错误！");
        return list2;
    }
    public Book searchBook(String bookid) throws UserException{
        Book form=gmUserDao.findByBookname(bookid);
        if(form==null) throw new UserException("该书不存在请重新输入！");
        return form;
    }
}
