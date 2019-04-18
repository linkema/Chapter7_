package Chapter7_2.usermng.dao;

import Chapter7_2.usermng.domain.Book;
import Chapter7_2.usermng.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcGmDaoImpl extends JdbcUserDaoImpl implements GMUserDao{

    @Override
    public void deleteUser(User form) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            /*
             * 一、得到连接
             */
            con = JdbcUtils.getConnection();
            /*
             * 二、准备sql模板，得到pstmt
             */
            String sql = "delete card_login where username=? and password=?";
            pstmt = con.prepareStatement(sql);
            /*
             * 三、为pstmt中的问号赋值
             */
            pstmt.setString(1, form.getUsername());
            pstmt.setString(2, form.getPassword());
            /*
             * 四、执行之
             */
            pstmt.executeUpdate();
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();
            } catch(SQLException e) {}
        }
    }

    @Override
    public void addBook(Book form) {

    }

    @Override
    public void deleteBook(Book form) {

    }

    @Override
    public void modifyBook(Book form) {

    }

    @Override
    public void searchBook(Book form) {

    }

    @Override
    public Book findByBookname(String bookname) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            /*
             * 一、得到连接
             */
            con = JdbcUtils.getConnection();
            /*
             * 二、准备sql模板，得到pstmt
             */
            String sql = "SELECT * FROM book WHERE ID=?";
            pstmt = con.prepareStatement(sql);
            /*
             * 三、为pstmt中的问号赋值
             */
            pstmt.setString(1, bookname);

            /*
             * 四、执行之
             */
            rs = pstmt.executeQuery();

            /*
             * 五、把rs转换成User类型，返回！
             */
            if(rs == null) {
                return null;
            }
            if(rs.next()) {
                //转换成User对象，并返回
                // ORM --> 对象关系映射！ hibernate!
                Book book = new Book();
                book.setBookNo(rs.getString("ID"));
                book.setBookName(rs.getString("NAME"));
                book.setPrice(rs.getString("PRICE"));
                book.setAuthor(rs.getString("AUTHOR"));
                book.setNote(rs.getString("NOTE"));
                return book;
            } else {
                return null;
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();
            } catch(SQLException e) {}
        }
    }
}
