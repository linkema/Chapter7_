package Chapter7_2.usermng.dao;

import Chapter7_2.usermng.domain.Book;
import Chapter7_2.usermng.domain.BorrowBook;
import Chapter7_2.usermng.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * 针对数据库的实现
 * @author mlk
 *
 */
public class JdbcUserDaoImpl implements UserDao {
	@Override
	public void addUser(User form) {
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
			String sql = "INSERT INTO card_login VALUES(?,?)";
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
    public User findByUsername(String username) {
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
            String sql = "SELECT * FROM card_login WHERE username = ?";
            pstmt = con.prepareStatement(sql);
            /*
             * 三、为pstmt中的问号赋值
             */
            pstmt.setString(1, username);

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
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
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

    @Override
    public Book findByBookname(String bookid) {
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
            pstmt.setString(1, bookid);

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

    @Override
    public ArrayList<Book> showAllBook() {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        ArrayList<Book> list=new ArrayList<>();
        try {
            con=JdbcUtils.getConnection();
            String sql="select * from book ";
            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()){
                Book b=new Book();
                b.setBookNo(rs.getString(1));
                b.setBookName(rs.getString(2));
                b.setAuthor(rs.getString(3));
                b.setPrice(rs.getString(4));
                b.setNote(rs.getString(5));
                list.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
            }
        }
        return list;
    }

    @Override
    public ArrayList<BorrowBook> showAllBorrowedBook() {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        ArrayList<BorrowBook> list=new ArrayList<>();
        try {
            con=JdbcUtils.getConnection();
            String sql="select * from book_borrow ";
            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()){
                BorrowBook b=new BorrowBook();
                b.setB_name(rs.getString(1));
                b.setBookno(rs.getString(2));
                list.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
            }
        }
        return list;
    }

    @Override
    public int borrowBook(BorrowBook form) {
        Connection con=null;
        PreparedStatement pstmt=null;
        int flag=0;
        try {
            /*
             * 一、得到连接
             */
            con = JdbcUtils.getConnection();
            /*
             * 二、准备sql模板，得到pstmt
             */
            String sql = "INSERT INTO book_borrow VALUES(?,?)";
            pstmt = con.prepareStatement(sql);
            /*
             * 三、为pstmt中的问号赋值
             */
            pstmt.setString(1, form.getB_name());
            pstmt.setString(2, form.getBookno());
            /*
             * 四、执行
             */
            flag=pstmt.executeUpdate();
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(pstmt != null) pstmt.close();
                if(con != null) con.close();
            } catch(SQLException e) {}
        }
       return flag;
    }

    @Override
    public void backBook(BorrowBook form) {
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
            String sql = "delete from book_borrow where bookid=? ";
            pstmt = con.prepareStatement(sql);
            /*
             * 三、为pstmt中的问号赋值
             */
            pstmt.setString(1,form.getBookno());
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

}
