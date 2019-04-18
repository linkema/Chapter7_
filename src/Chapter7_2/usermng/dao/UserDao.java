package Chapter7_2.usermng.dao;

import Chapter7_2.usermng.domain.User;

/**
 * UserDao接口
 * @author mlk
 *
 */
public interface UserDao {
	public void addUser(User form);
    public User findByUsername(String username);
    //public void search(User form);
}
