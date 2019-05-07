package Chapter7_2.usermng.dao;

import Chapter7_2.usermng.domain.Book;
import Chapter7_2.usermng.domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
                String sql = "delete from card_login where username = ? and password = ? ";
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
                String sql = "INSERT INTO book VALUES(?,?,?,?,?)";
                pstmt = con.prepareStatement(sql);
                /*
                 * 三、为pstmt中的问号赋值
                 */
                pstmt.setString(1, form.getBookNo());
                pstmt.setString(2, form.getBookName());
                pstmt.setString(3,form.getPrice());
                pstmt.setString(4,form.getAuthor());
                pstmt.setString(5,form.getNote());
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
        public void deleteBook(String bookid) {
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
                String sql = "delete from book where ID=? ";
                pstmt = con.prepareStatement(sql);
                /*
                 * 三、为pstmt中的问号赋值
                 */
                pstmt.setString(1,bookid);
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
        public Book modifyBook(Book form) {
        Connection con=null;
        PreparedStatement pstmt=null;
            try {
                con=JdbcUtils.getConnection();
                String sql="update book set ID=?,NAME=?,AUTHOR=?,PRICE=?,NOTE=? where ID=?";
                pstmt=con.prepareStatement(sql);
                String bookID=form.getBookNo();
                String bookName=form.getBookName();
                String bookAu=form.getAuthor();
                String bookPr=form.getPrice();
                String bookNote=form.getNote();
                String oldid=form.getBookNo();
                pstmt.setString(1,bookID);
                pstmt.setString(2,bookName);
                pstmt.setString(3,bookAu);
                pstmt.setString(4,bookPr);
                pstmt.setString(5,bookNote);
                pstmt.setString(6,oldid);
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    if(pstmt != null) pstmt.close();
                    if(con != null) con.close();
                } catch(SQLException e) {}
            }

            return null;
        }

    @Override
    public ArrayList<User> showAllUser() {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        ArrayList<User> list=new ArrayList<>();
        try {
            con=JdbcUtils.getConnection();
            String sql="select * from card_login ";
            pstmt=con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()){
                User ug=new User();
                ug.setUsername(rs.getString(1));
                ug.setPassword(rs.getString(2));
                list.add(ug);
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

}
